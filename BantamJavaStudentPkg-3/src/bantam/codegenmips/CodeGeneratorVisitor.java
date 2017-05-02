/**
 * File: CodeGeneratorVisitor.java
 * @author Edward (osan) Zhou
 * @author Alex Rinker
 * @author Vivek Sah
 * Class: CS461
 * Project: 4B
 * Date: April 5 2017
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

    /** the current class being traversed */
    private PhraseExpr currPhraseExpr;

    /** Variable to Phrase expr matching */
    private Map<String, PhraseExpr> variables;

    /** Manage looping expressions */
    private int currOffset;

    /** flag to generate code in an expression */
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
        this.variables = new HashMap<>();
        this.currOffset = 0;
    }

    public void generate() {
        this.root.accept(this);
    }

    @Override
    public Object visit(Field node) {
        this.variables.put(node.getName(), (PhraseExpr) node.getInit());
        return null;
    }

    @Override
    public Object visit(LoopStmt node) {
        String loopLabel = mipsSupport.getLabel();
        String endLabel = mipsSupport.getLabel();

        mipsSupport.genLoadImm(mipsSupport.getS0Reg(), ((ConstIntExpr)node.getExpr()).getIntConstant());
        this.currOffset -= 4;
        mipsSupport.genLabel(loopLabel);

        // manage s0
        mipsSupport.genCondBeq(mipsSupport.getS0Reg(), mipsSupport.getZeroReg(), endLabel);
        mipsSupport.genSub(mipsSupport.getS0Reg(), mipsSupport.getS0Reg(), 1);

        // store s0 in case loop in a loop
        mipsSupport.genStoreWord(mipsSupport.getS0Reg(), currOffset, mipsSupport.getSPReg());

        super.visit(node);

        // load s0 from stack
        mipsSupport.genLoadWord(mipsSupport.getS0Reg(), currOffset, mipsSupport.getSPReg());

        mipsSupport.genUncondBr(loopLabel);
        mipsSupport.genLabel(endLabel);
        this.currOffset += 4;
        return null;
    }

    @Override
    public Object visit(CallStmt node) {
        this.callGenerating = true;
        if (node.getExpr().getExprType().equals(SemanticTools.PHRASE)) {
            node.getExpr().accept(this);
        } else {
            this.variables.get(((ConstVarExpr)node.getExpr()).getName()).accept(this);
        }
        callGenerating = false;
        return null;
    }


    @Override
    public Object visit(BlockStmt node) {
        this.blockGenerating = true;
        List<PhraseExpr> phrases = new ArrayList<>();
        List<Integer> sleepTimes = new ArrayList<>();
        int maxMeasures = 0;

        // collect the phrases
        for (Iterator it = node.getExprList().iterator(); it.hasNext(); ) {
            Expr temp = (Expr) it.next();
            if (temp.getExprType().equals(SemanticTools.VAR)) {
                PhraseExpr e = variables.get(((ConstVarExpr) temp).getName());
                phrases.add(e);
                maxMeasures = Math.max(maxMeasures, e.getMeasureList().getSize());
            } else {
                phrases.add((PhraseExpr) temp);
                maxMeasures = Math.max(maxMeasures, ((PhraseExpr)temp).getMeasureList().getSize());
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

        // loop through every list of measures

        for (List<Measure> measureList : measures ){
            for (Measure measure : measureList) {
                sleepTimes.add(SemanticTools.getMeasureNoteLength(measure.getSoundList().getSize()));
                measure.accept(this);
                System.out.println(sleepTimes);
            }


        }


        this.blockGenerating = false;
        return null;
    }

    @Override
    public Object visit(PhraseExpr node) {
        if (callGenerating) { // if in call stmt

            // prep instrument parse
            String instr = ((ConstStringExpr)node.getInstrument())
                    .getConstant().toLowerCase();
            instr = instr.substring(1, instr.length()-1);
            String baseInstr;
            int instrMod;
            if (Character.isDigit(instr.charAt(instr.length()-1))) {
                baseInstr = instr.substring(0, instr.length()-1);
                instrMod = instr.charAt(instr.length()-1);
            } else {
                baseInstr = instr;
                instrMod = 0;
            }

            mipsSupport.genLoadImm(
                    mipsSupport.getArg2Reg(),
                    (SemanticTools.instruments.indexOf(baseInstr) * 8) + instrMod
            );

            // prep volume
            mipsSupport.genLoadImm(
                    "$a3",
                    ((ConstIntExpr)node.getVolume()).getIntConstant()
            );

            super.visit(node);
        }
        return null;
    }

    @Override
    public Object visit(Measure node) {
        if (blockGenerating) {
            
        } else { // regular generation
            mipsSupport.genLoadImm(
                    mipsSupport.getArg1Reg(),
                    SemanticTools.getMeasureNoteLength(node.getSoundList().getSize())
            );

            node.getSoundList().iterator().forEachRemaining(s -> {
                s.accept(this);
                if (s instanceof Note) {
                    mipsSupport.genSyscall(31);
                }
                mipsSupport.genMove(mipsSupport.getS1Reg(), mipsSupport.getArg0Reg());
                mipsSupport.genLoadImm(mipsSupport.getArg0Reg(), SemanticTools.BPM / node.getSoundList().getSize() - 100);

                mipsSupport.genSyscall(32);
                mipsSupport.genMove(mipsSupport.getArg0Reg(), mipsSupport.getS1Reg());
            });
            return null;
        }
    }

    @Override
    public Object visit(Chord node) {
        node.getSoundList().iterator().forEachRemaining(s -> {
            s.accept(this);
            mipsSupport.genSyscall(31);
        });
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
        mipsSupport.genLoadImm(
                mipsSupport.getArg0Reg(),
                SemanticTools.NOTES.get(node.getName().toLowerCase()) + node.getOctave()*12);
        return null;
    }
}
