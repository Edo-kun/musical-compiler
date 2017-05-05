/**
 * File: TypeVisitor.java
 * @author Edward (the guy) Zhou
 * @author Alex Rinker
 * @author Vivek Sah
 * Class: CS461
 * Project: 6
 * Date: April 30 2017
 */

package bantam.visitor;

import bantam.mast.*;
import bantam.util.ErrorHandler;
import bantam.util.SemanticTools;

/**
 * Make sure types are valid and annotates the ast nodes
 * key things to check
 * (1) score name is a string //done by parser
 * (2) variables are assigned phrase expressions
 * (3) loops are given a positive int to loop
 * (4) octaveExpr modifiers are within range
 * (5) instrument declarations are valid instruments
 * (6) volume is within 1-127
 * (8) block stmts have valid expressions to match
 */
public class TypeVisitor extends MusicVisitor {
    /** the program root node */
    private Program root;
    /** errorhandler to report semantic errors */
    private ErrorHandler errorHandler;
    /** pointer to the current phrase which is being traversed */
    private PhraseExpr currentPhraseExpr;

    public TypeVisitor(Program program, ErrorHandler errorHandler) {
        this.root = program;
        this.errorHandler = errorHandler;
    }

    /** check and annotate ast types */
    public void checkTypes() {
        this.root.accept(this);
    }


    @Override
    public Object visit(Score node) {
        super.visit(node);
        if (node.getTicksPerMeasureExpr() != null) {
            if (node.getTicksPerMeasureExpr().getExprType() != SemanticTools.INT) {
                errorHandler.register(
                        errorHandler.SEMANT_ERROR,
                        root.getScore().getFilename(),
                        node.getLineNum(),
                        "Score TPM must be an int"
                );
            } else {
                if (((ConstIntExpr)node.getTicksPerMeasureExpr()).getIntConstant()
                        + SemanticTools.SLEEP_MOD < 0) {
                    errorHandler.register(
                            errorHandler.SEMANT_ERROR,
                            root.getScore().getFilename(),
                            node.getLineNum(),
                            "TPM too low"
                    );

                }
            }
        }
        return null;
    }

    @Override
    public Object visit(Field node) {
        super.visit(node);
        if (!node.getInit().getExprType().equals(SemanticTools.PHRASE)) {
            errorHandler.register(
                    errorHandler.SEMANT_ERROR,
                    root.getScore().getFilename(),
                    node.getLineNum(),
                    "Field must be assigned valid phrases"
            );
        }
        return null;
    }

    @Override
    public Object visit(LoopStmt node) {
        super.visit(node);
        if (node.getExpr().getExprType() != SemanticTools.INT) {
            errorHandler.register(
                    errorHandler.SEMANT_ERROR,
                    root.getScore().getFilename(),
                    node.getLineNum(),
                    "int required for loop"
            );
        } else {
            if (((ConstIntExpr)node.getExpr()).getIntConstant() < 0) {
                errorHandler.register(
                        errorHandler.SEMANT_ERROR,
                        root.getScore().getFilename(),
                        node.getLineNum(),
                        "positive int required for loop"
                );
            }
        }

        return null;
    }


    /** Make sure:
     * instruments are valid strings
     * octave modifiers are legal
     * volume is not turned up to 11 :3
     * */
    @Override
    public Object visit(PhraseExpr node) {
        node.setExprType(SemanticTools.PHRASE);
        this.currentPhraseExpr = node;
        if (node.getInstrument() != null) {
            node.getInstrument().accept(this);
            if (!node.getInstrument().getExprType().equals(SemanticTools.STRING)) {
                errorHandler.register(
                        errorHandler.SEMANT_ERROR,
                        root.getScore().getFilename(),
                        node.getLineNum(),
                        "Instrument must be a String"
                        );
            } else {
                if (!SemanticTools.isValidInstrument(
                        ((ConstStringExpr) node.getInstrument()).getConstant())
                        ) {
                    errorHandler.register(
                            errorHandler.SEMANT_ERROR,
                            root.getScore().getFilename(),
                            node.getLineNum(),
                            "Instrument must be of types: " + SemanticTools.instruments
                    );
                }
            }
        } else {
            // default value
            node.setInstrument(new ConstStringExpr(node.getLineNum(), "piano"));
        }
        if (node.getOctaveModifier() != null) {
            node.getOctaveModifier().accept(this);
            if (!node.getOctaveModifier().getExprType().equals(SemanticTools.INT)) {
                errorHandler.register(
                        errorHandler.SEMANT_ERROR,
                        root.getScore().getFilename(),
                        node.getLineNum(),
                        "Octave modifiers must be of type " + SemanticTools.INT
                );
            } else {
                int octave = Integer.parseInt(
                        ((ConstIntExpr) node.getOctaveModifier()).getConstant()
                );

                if (octave > SemanticTools.MAX_OCT || octave < SemanticTools.MIN_OCT) {
                    errorHandler.register(
                            errorHandler.SEMANT_ERROR,
                            root.getScore().getFilename(),
                            node.getLineNum(),
                            "Octave modifiers must be within the range "
                                    + SemanticTools.MIN_OCT + " to "
                                    + SemanticTools.MAX_OCT
                    );
                }
            }
        } else {
            // default value
            node.setOctaveModifier(new ConstIntExpr(node.getLineNum(), "0"));
        }
        if (node.getVolume() != null) {
            node.getVolume().accept(this);
            if (!node.getVolume().getExprType().equals(SemanticTools.INT)) {
                errorHandler.register(
                        errorHandler.SEMANT_ERROR,
                        root.getScore().getFilename(),
                        node.getLineNum(),
                        "Volume must be of type " + SemanticTools.INT
                );
            } else {
                int vol = Integer.parseInt(
                        ((ConstIntExpr) node.getVolume()).getConstant()
                );

                if (vol > 127 || vol < 0) {
                    errorHandler.register(
                            errorHandler.SEMANT_ERROR,
                            root.getScore().getFilename(),
                            node.getLineNum(),
                            "Volume must be in range 0-127"
                    );
                }
            }
        } else {
            //default value
            node.setVolume(new ConstIntExpr(node.getLineNum(), "127"));
        }
        node.getMeasureList().accept(this);
        return null;
    }

    @Override
    public Object visit(CallStmt node) {
        super.visit(node);
        if (!(node.getExpr()).getExprType().equals(SemanticTools.PHRASE) &&
                !(node.getExpr()).getExprType().equals(SemanticTools.VAR)) {
            errorHandler.register(
                    errorHandler.SEMANT_ERROR,
                    root.getScore().getFilename(),
                    node.getLineNum(),
                    "Expressions in call statements must be a phrase or a field variable"
            );
        }
        return null;
    }

    @Override
    public Object visit(BlockStmt node) {
        super.visit(node);
        for (ASTNode ast : node.getExprList()) {
            if (!((Expr) ast).getExprType().equals(SemanticTools.PHRASE) &&
                !((Expr) ast).getExprType().equals(SemanticTools.VAR)) {
                errorHandler.register(
                        errorHandler.SEMANT_ERROR,
                        root.getScore().getFilename(),
                        node.getLineNum(),
                        "Expressions in block statements must " +
                                "be a phrase or a field variable"
                );
            }
        }
        return null;
    }

    @Override
    public Object visit(Chord node) {
        super.visit(node);
        node.getSoundList().forEach(s -> {
            if (s instanceof Chord) {
                errorHandler.register(
                        errorHandler.SEMANT_ERROR,
                        root.getScore().getFilename(),
                        node.getLineNum(),
                        "Chords can only hold notes"
                );
            } else {
                if (((Note)s).getName().equals(":")) {
                    errorHandler.register(
                            errorHandler.SEMANT_ERROR,
                            root.getScore().getFilename(),
                            node.getLineNum(),
                            "Rests cannot be in chords"
                    );
                }
            }

        });
        return null;
    }

    @Override
    public Object visit(Note node) {
        super.visit(node);
        if (node.getOctaveExpr() != null) {
            if (node.getOctaveExpr().getExprType().equals(SemanticTools.INT)) {
                int octave = Integer.parseInt(
                        ((ConstIntExpr) node.getOctaveExpr()).getConstant()
                );

                if (octave > SemanticTools.MAX_OCT || octave < SemanticTools.MIN_OCT) {
                    errorHandler.register(
                            errorHandler.SEMANT_ERROR,
                            root.getScore().getFilename(),
                            node.getLineNum(),
                            "Octave modifiers must be within the range "
                                    + SemanticTools.MIN_OCT + " to "
                                    + SemanticTools.MAX_OCT
                    );
                } else {
                    node.setOctave(octave);
                }
            } else {
                errorHandler.register(
                        errorHandler.SEMANT_ERROR,
                        root.getScore().getFilename(),
                        node.getLineNum(),
                        "Octave modifiers must be of type " + SemanticTools.INT
                );
            }
        } else {
            // set octave if valid program is valid so far...
            if (this.currentPhraseExpr.getOctaveModifier() != null
                    && errorHandler.getErrorList().size() < 1) {
                node.setOctave(
                        Integer.parseInt(
                                ((ConstIntExpr) currentPhraseExpr.getOctaveModifier())
                                .getConstant()
                        )
                );
            } else {
                node.setOctave(0);
            }
        }

        // set instrument and volume attributes when no errors have occurred
        if (errorHandler.getErrorList().size() == 0) {
            node.setInstrument(
                    ((ConstStringExpr) currentPhraseExpr.getInstrument()).getConstant()
            );

            node.setVolume(
                    ((ConstIntExpr) currentPhraseExpr.getVolume()).getIntConstant()
            );
        }

        return null;
    }

    @Override
    public Object visit(ConstVarExpr node) {
        node.setExprType(SemanticTools.VAR);
        return super.visit(node);
    }

    @Override
    public Object visit(ConstIntExpr node) {
        node.setExprType(SemanticTools.INT);
        return super.visit(node);
    }

    @Override
    public Object visit(ConstStringExpr node) {
        node.setExprType(SemanticTools.STRING);
        return super.visit(node);
    }
}
