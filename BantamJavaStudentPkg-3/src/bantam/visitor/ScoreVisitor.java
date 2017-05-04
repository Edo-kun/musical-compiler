/**
 * File: ScoreVisitor.java
 * This file was written in memory of our former
 * group member Victoria Chistolini who sadly did not
 * survive project 2.5. R.I.P.
 * @author Edward (osan) Zhou
 * @author Alex Rinker
 * @author Vivek Sah
 * Class: CS461
 * Project: 6
 * Date: April 30 2017
 */

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

    /** check the score for validity */
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
