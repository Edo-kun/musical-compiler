/**
 * File: CodeGeneratorVisitor.java
 * @author Edward (osan) Zhou
 * @author Alex Rinker
 * @author Vivek Sah
 * Class: CS461
 * Project: 6
 * Date: April 30 2017
 */

package bantam.codegenmips;

import bantam.mast.*;
import bantam.util.SemanticTools;
import bantam.visitor.MusicVisitor;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.lang.*;

/**
 * Visitor for creating the .text code of mips
 */
public class CodeGeneratorVisitor extends MusicVisitor{
    /** support class for callGenerating code in mips */
    private MipsSupport mipsSupport;

    /** Print stream for printing to a file */
    private PrintStream out;

    /** root of the class tree */
    private Program root;

    /** Variable to Phrase expr matching - block stmts */
    private Map<String, PhraseExpr> variablesToPhrase;

    /** Variable to label matching - calls stmts */
    private Map<String, String> variablesToLabel;

    /** Manage looping expressions */
    private int currOffset;

    /** flag to generate code in a field */
    private boolean callGenerating;

    /** flag to play phrases in sequence */
    private boolean blockGenerating;

    /** keeps track of notes when block generating */
    private int currNoteIndex;

    /**
     * constructor method
     * @param root the root node of the program
     * @param mipsSupport the mipsSupport helper class
     */
    public CodeGeneratorVisitor(
            Program root,
            MipsSupport mipsSupport,
            PrintStream out) {
        this.mipsSupport = mipsSupport;
        this.out = out;
        this.root = root;
        this.variablesToPhrase = new HashMap<>();
        this.variablesToLabel = new HashMap<>();
        this.blockGenerating = false;
        this.callGenerating = false;
        this.currOffset = 0;
    }

    /**
     * generate mips code
     */
    public void generate() {
        // wait half a second...
        mipsSupport.genLoadImm(
                mipsSupport.getArg0Reg(),
                500
        );

        mipsSupport.genSyscall(32);

        // play
        this.root.accept(this);
    }

    @Override
    public Object visit(Score node) {
        if (node.getTicksPerMeasureExpr() != null) {
            // set ticks per measure if available
            SemanticTools.TPM =
                    ((ConstIntExpr) node.getTicksPerMeasureExpr()).getIntConstant();
        }
        return super.visit(node);
    }

    @Override
    public Object visit(Field node) {
        this.variablesToPhrase.put(node.getName(), (PhraseExpr) node.getInit());
        String fieldLabel = mipsSupport.getLabel();
        this.variablesToLabel.put(node.getName(), fieldLabel);
        String after = mipsSupport.getLabel();

        // branches past the field code
        mipsSupport.genUncondBr(after);
        mipsSupport.genLabel(fieldLabel);

        node.getInit().accept(this);

        mipsSupport.genRetn();
        mipsSupport.genLabel(after);
        return null;
    }

    @Override
    public Object visit(LoopStmt node) {
        String loopLabel = mipsSupport.getLabel();
        String endLabel = mipsSupport.getLabel();

        mipsSupport.genLoadImm(
                mipsSupport.getS0Reg(),
                ((ConstIntExpr)node.getExpr()).getIntConstant()
        );

        this.currOffset -= 4;
        mipsSupport.genLabel(loopLabel);

        // manage s0
        mipsSupport.genCondBeq(
                mipsSupport.getS0Reg(),
                mipsSupport.getZeroReg(),
                endLabel
        );

        mipsSupport.genSub(mipsSupport.getS0Reg(), mipsSupport.getS0Reg(), 1);

        // store s0 in case loop in a loop
        mipsSupport.genStoreWord(
                mipsSupport.getS0Reg(),
                currOffset,
                mipsSupport.getSPReg()
        );

        super.visit(node);

        // load s0 from stack
        mipsSupport.genLoadWord(
                mipsSupport.getS0Reg(),
                currOffset,
                mipsSupport.getSPReg()
        );

        mipsSupport.genUncondBr(loopLabel);
        mipsSupport.genLabel(endLabel);
        this.currOffset += 4;
        return null;
    }

    @Override
    public Object visit(CallStmt node) {
        if (node.getExpr().getExprType().equals(SemanticTools.PHRASE)) {
            node.getExpr().accept(this);
        } else {
            mipsSupport.genDirCall(
                    variablesToLabel.get(((ConstVarExpr)node.getExpr()).getName())
            );
        }
        return null;
    }


    @Override
    public Object visit(BlockStmt node) {
        this.blockGenerating = true;
        List<PhraseExpr> phrases = new ArrayList<>();

        int maxMeasures = 0;

        // collect the phrases
        for (Iterator it = node.getExprList().iterator(); it.hasNext(); ) {
            Expr temp = (Expr) it.next();
            if (temp.getExprType().equals(SemanticTools.VAR)) {
                PhraseExpr e = variablesToPhrase.get(((ConstVarExpr) temp).getName());
                phrases.add(e);
                maxMeasures = Math.max(maxMeasures, e.getMeasureList().getSize());
            } else {
                phrases.add((PhraseExpr) temp);
                maxMeasures =
                        Math.max(
                                maxMeasures,
                                ((PhraseExpr)temp).getMeasureList().getSize()
                        );
            }
        }

        // initialize measure list
        List<List<Measure>> measures = new ArrayList<>();
        for (int i = 0; i < maxMeasures; i++) {
            measures.add(new ArrayList<>());
        }

        // group overlayed measures with each other
        for (PhraseExpr phrase : phrases) {
            int index = 0;
            for (Iterator it = phrase.getMeasureList().iterator(); it.hasNext(); ) {
                measures.get(index).add(((Measure) it.next()));
                index++;
            }
        }

        // sleep times for each measure
        List<Integer> sleepTimes = new ArrayList<>();
        // note indices for each measure to keep track next note
        List<Integer> indices = new ArrayList<>();
        // loop through every list of measures

        for (List<Measure> measureList : measures ){
            int numNotes = 0; // total notes to play
            sleepTimes.clear();
            indices.clear();


            this.currNoteIndex = 0;
            // initialize first notes and sleepTimes
            for (Measure measure : measureList) {

                // initialize sleep times to 0 or -1 if measure list is empty
                sleepTimes.add(
                        Math.min(
                                SemanticTools.getMeasureNoteLength(
                                        measure.getSoundList().getSize()),
                                0
                        )
                );

                numNotes += measure.getSoundList().getSize();

                indices.add(0);
            }

            // Iterate through the notes
            for (int i = 0; i < numNotes; i++) {
                int keyIndex = sleepTimes.indexOf(0);
                // visit the note
                this.currNoteIndex = indices.get(keyIndex);
                measureList.get(keyIndex).accept(this);
                indices.set(keyIndex, indices.get(keyIndex)+1);

                sleepTimes.set(
                        keyIndex,
                        SemanticTools.getMeasureNoteLength(
                                measureList.get(keyIndex).getSoundList().getSize()
                        )
                );

                int occurrences = Collections.frequency(sleepTimes, 0);
                // pause after every note for the current times has been played
                if (occurrences == 0) {
                    int sleepDuration = getMinPositiveNum(sleepTimes);

                    // pause for note
                    mipsSupport.genLoadImm(
                            mipsSupport.getArg0Reg(),
                            sleepDuration + SemanticTools.SLEEP_MOD
                    );
                    mipsSupport.genSyscall(32);

                    for (int j = 0; j < measureList.size(); j++) {
                        sleepTimes.set(j, sleepTimes.get(j)-sleepDuration);
                    }
                }
            }

        }

        this.blockGenerating = false;
        return null;
    }

    /**
     * special case minimum to get only min positive of a list
     * @param list the list in question
     * @return
     */
    private int getMinPositiveNum(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (Integer i: list) {
            if (i.intValue() >= 0) {
                min = Math.min(i, min);
            }
        }
        return min;
    }

    @Override
    public Object visit(PhraseExpr node) {
        // prep instrument parse
        String instr = ((ConstStringExpr)node.getInstrument())
                .getConstant().toLowerCase();

        mipsSupport.genLoadImm(
                mipsSupport.getArg2Reg(),
                SemanticTools.getInstrumentVal(instr)
        );

        // prep volume
        mipsSupport.genLoadImm(
                "$a3",
                ((ConstIntExpr)node.getVolume()).getIntConstant()
        );

        super.visit(node);

        return null;
    }

    @Override
    public Object visit(Measure node) {
        mipsSupport.genLoadImm(
                mipsSupport.getArg1Reg(),
                SemanticTools.getMeasureNoteLength(node.getSoundList().getSize())
        );
        if (blockGenerating) { // generating overlaying measures
            int i = 0;
            for (ASTNode astNode : node.getSoundList()) {
                if (i == this.currNoteIndex) {
                    astNode.accept(this);
                    if (astNode instanceof Note &&
                            SemanticTools.NOTES.get(
                                    ((Note) astNode).getName().toLowerCase()
                                            + ((Note) astNode).getModifier()) != -1) {
                        mipsSupport.genSyscall(31);
                    }
                }
                i++;
            }
        } else { // regular generation
            node.getSoundList().iterator().forEachRemaining(s -> {
                s.accept(this);
                if (s instanceof Note &&
                        SemanticTools.NOTES.get(
                                ((Note)s).getName().toLowerCase()
                                        + ((Note) s).getModifier()) != -1) {
                    mipsSupport.genSyscall(31);
                }
                // sleep syscall
                mipsSupport.genLoadImm(
                        mipsSupport.getArg0Reg(),
                        SemanticTools.getMeasureNoteLength(
                                node.getSoundList().getSize()) + SemanticTools.SLEEP_MOD
                );

                mipsSupport.genSyscall(32);
            });

        }
        return null;
    }

    @Override
    public Object visit(Chord node) {
        if (!(node.getSoundList().getSize() == 0)) {
            node.getSoundList().iterator().forEachRemaining(s -> {
                s.accept(this);
                mipsSupport.genSyscall(31);
            });
        }
        return null;
    }

    @Override
    public Object visit(SoundList node) {
        Sound sound;
        for (Iterator it = node.iterator(); it.hasNext(); ) {
            sound = ((Sound) it.next());
            sound.accept(this);
        }
        return null;
    }

    @Override
    public Object visit(Note node) {
        // skip if rest note
        if (!(SemanticTools.NOTES.get(node.getName().toLowerCase()
                + node.getModifier()) == -1)) {

            mipsSupport.genLoadImm(
                    mipsSupport.getArg0Reg(),
                    SemanticTools.NOTES.get(
                            node.getName().toLowerCase() + node.getModifier()
                    ) + node.getOctave()*12);

            // overlayed notes require their phrases attributes
            if (blockGenerating) {
                mipsSupport.genLoadImm(
                        mipsSupport.getArg2Reg(),
                        SemanticTools.getInstrumentVal(node.getInstrument())
                );
                mipsSupport.genLoadImm(
                        "$a3",
                        node.getVolume()
                );

            }
        }
        return null;
    }
}
