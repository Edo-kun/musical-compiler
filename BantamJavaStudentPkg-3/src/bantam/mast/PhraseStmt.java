/* Bantam Java Compiler and Language Toolset.

   Copyright (C) 2009 by Marc Corliss (corliss@hws.edu) and
                         David Furcy (furcyd@uwosh.edu) and
                         E Christopher Lewis (lewis@vmware.com).
   ALL RIGHTS RESERVED.

   The Bantam Java toolset is distributed under the following
   conditions:

     You may make copies of the toolset for your own use and
     modify those copies.

     All copies of the toolset must retain the author names and
     copyright notice.

     You may not sell the toolset or distribute it in
     conjunction with a commerical product or service without
     the expressed written consent of the authors.

   THIS SOFTWARE IS PROVIDED ``AS IS'' AND WITHOUT ANY EXPRESS
   OR IMPLIED WARRANTIES, INCLUDING, WITHOUT LIMITATION, THE
   IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
   PARTICULAR PURPOSE.
*/

package bantam.mast;

import bantam.visitor.MusicVisitor;

/**
 * The <tt>PhraseStmt</tt> class represents a phrase statement, which
 * contains a list of measures.  It contains instrument/octave/volume
 * through the phrase expr
 * (<tt>MeasureList</tt>).
 *
 * @see ASTNode
 * @see Stmt
 */
public class PhraseStmt extends Stmt {
    /**
     * A phrase expr
     */
    protected PhraseExpr phraseExpr;

    /**
     * PhraseStmt constructor
     *
     * @param lineNum  source line number corresponding to this AST node
     * @param phraseExpr
     */
    public PhraseStmt(int lineNum,
                      PhraseExpr phraseExpr) {
        super(lineNum);
        this.phraseExpr = phraseExpr;
    }

    public PhraseExpr getPhraseExpr() {
        return phraseExpr;
    }

    /**
     * Visitor method
     *
     * @param v bantam.visitor object
     * @return result of visiting this node
     * @see MusicVisitor
     */
    public Object accept(MusicVisitor v) {
        return v.visit(this);
    }
}
