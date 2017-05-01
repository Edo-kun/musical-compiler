package bantam.visitor;

import bantam.mast.Program;
import bantam.util.ErrorHandler;

/**
 * Make sure there is a score to play
 * expandable to multiple scores
 */
public class ScoreVisitor extends MusicVisitor {
    private Program root;
    private ErrorHandler errorHandler;

    public ScoreVisitor(Program program, ErrorHandler errorHandler) {
        this.root = program;
        this.errorHandler = errorHandler;
    }

    public void checkScore() {
        this.root.accept(this);
    }

    @Override
    public Object visit(Program node) {
        if (node.getScore() == null) {
            errorHandler.register(errorHandler.SEMANT_ERROR, "Missing Score");
        }
        return null;
    }
}
