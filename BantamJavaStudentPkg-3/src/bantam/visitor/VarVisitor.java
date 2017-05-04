package bantam.visitor;

import bantam.mast.*;
import bantam.util.ErrorHandler;
import bantam.util.SemanticTools;

import java.util.ArrayList;
import java.util.List;

/**
 * Makes sure variables are declared before
 * they are used
 */
public class VarVisitor extends MusicVisitor{
    /** the root of the program */
    private Program root;

    /** error handler to register errors */
    private ErrorHandler errorHandler;

    /** List of declared fields */
    List<String> declaredVars;

    public VarVisitor(Program program, ErrorHandler errorHandler) {
        this.root = program;
        this.errorHandler = errorHandler;
        declaredVars = new ArrayList<>();
    }

    /** check variable declarations */
    public void checkVariables() {
        this.root.accept(this);
    }

    @Override
    public Object visit(Field node) {
        declaredVars.add(node.getName());
        return super.visit(node);
    }

    @Override
    public Object visit(CallStmt node) {
        // if it is a variable call
        super.visit(node);
        if (SemanticTools.VAR.equals(node.getExpr().getExprType())) {
            String name = ((ConstVarExpr)node.getExpr()).getName();
            if (!declaredVars.contains(name)) {
                errorHandler.register(
                        errorHandler.SEMANT_ERROR,
                        root.getScore().getFilename(),
                        node.getLineNum(),
                        "Undeclared field: " + name
                );
            }
        }
        return null;
    }

    @Override
    public Object visit(BlockStmt node) {
        // if it is a variable call
        super.visit(node);
        for (ASTNode expr : node.getExprList()) {
            if (SemanticTools.VAR.equals(((Expr)expr).getExprType())) {
                String name = ((ConstVarExpr)expr).getName();
                if (!declaredVars.contains(name)) {
                    errorHandler.register(
                            errorHandler.SEMANT_ERROR,
                            root.getScore().getFilename(),
                            node.getLineNum(),
                            "Undeclared field: " + name
                    );
                }
            }
        }
        return null;
    }

    @Override
    public Object visit(PhraseExpr node) { return null; }

    @Override
    public Object visit(MeasureList node) { return null; }

    @Override
    public Object visit(Measure node) {
        return null;
    }
}
