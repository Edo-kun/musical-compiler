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
 * (6) volume is within 1-11
 * (8) block stmts have valid expressions to match
 */
public class TypeVisitor extends MusicVisitor {
    private Program root;
    private ErrorHandler errorHandler;
    private PhraseExpr currentPhraseExpr;

    public TypeVisitor(Program program, ErrorHandler errorHandler) {
        this.root = program;
        this.errorHandler = errorHandler;
    }

    public void checkTypes() {
        this.root.accept(this);
    }


    @Override
    public Object visit(Score node) {
        return super.visit(node);
    }

    @Override
    public Object visit(Field node) {
        return super.visit(node);
    }

    @Override
    public Object visit(StmtList node) {
        return super.visit(node);
    }

    @Override
    public Object visit(Stmt node) {
        return super.visit(node);
    }

    @Override
    public Object visit(LoopStmt node) {
        return super.visit(node);
    }

    @Override
    public Object visit(PhraseStmt node) {
        return super.visit(node);
    }

    /** Make sure:
     * instruments are valid strings
     * octave modifiers are legal
     * volume is not turned up to 11 +1
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
                if (!SemanticTools.isValidInstrument(((ConstStringExpr) node.getInstrument()).getConstant())) {
                    errorHandler.register(
                            errorHandler.SEMANT_ERROR,
                            root.getScore().getFilename(),
                            node.getLineNum(),
                            "Instrument must be of types: " + SemanticTools.instruments
                    );
                }
            }
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
                int octave = Integer.parseInt(((ConstIntExpr) node.getOctaveModifier()).getConstant());
                if (octave > SemanticTools.MAX_OCT || octave < SemanticTools.MIN_OCT) {
                    errorHandler.register(
                            errorHandler.SEMANT_ERROR,
                            root.getScore().getFilename(),
                            node.getLineNum(),
                            "Octave modifiers must be within the range " + SemanticTools.MIN_OCT + " to " + SemanticTools.MAX_OCT
                    );
                }
            }
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
                int vol = Integer.parseInt(((ConstIntExpr) node.getVolume()).getConstant());
                if (vol > 127 || vol < 0) {
                    errorHandler.register(
                            errorHandler.SEMANT_ERROR,
                            root.getScore().getFilename(),
                            node.getLineNum(),
                            "Volume must be in range 0-127"
                    );
                }
            }
        }
        node.getMeasureList().accept(this);
        return super.visit(node);
    }

    @Override
    public Object visit(CallStmt node) {
        return super.visit(node);
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
                        "Expressions in block statements must be a phrase or a field variable"
                );
            }
        }
        return null;
    }

    @Override
    public Object visit(Note node) {
        super.visit(node);
        if (node.getOctaveExpr() != null) {
            if (node.getOctaveExpr().getExprType().equals(SemanticTools.INT)) {
                int octave = Integer.parseInt(((ConstIntExpr) node.getOctaveExpr()).getConstant());
                if (octave > SemanticTools.MAX_OCT || octave < SemanticTools.MIN_OCT) {
                    errorHandler.register(
                            errorHandler.SEMANT_ERROR,
                            root.getScore().getFilename(),
                            node.getLineNum(),
                            "Octave modifiers must be within the range " + SemanticTools.MIN_OCT + " to " + SemanticTools.MAX_OCT
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
            if (this.currentPhraseExpr.getOctaveModifier() != null && errorHandler.getErrorList().size() < 1) {
                node.setOctave(Integer.parseInt(((ConstIntExpr) currentPhraseExpr.getOctaveModifier()).getConstant()));
            } else {
                node.setOctave(0);
            }
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
