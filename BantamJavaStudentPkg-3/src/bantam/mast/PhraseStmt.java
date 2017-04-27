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

import bantam.mast.MeasureList;
import bantam.visitor.MusicVisitor;

/**
 * The <tt>PhraseStmt</tt> class represents a phrase statement, which
 * contains a list of measures.  It contains instrument/octave/volume
 * info
 * (<tt>MeasureList</tt>).
 *
 * @see ASTNode
 * @see Stmt
 */
public class PhraseStmt extends Stmt {
    /**
     * A list of measures
     */
    protected MeasureList measureList;

    /** attributes of the phrase */
    protected String instrument;
    protected int octaveModifier;
    protected int volume;

    /**
     * PhraseStmt constructor
     *
     * @param lineNum  source line number corresponding to this AST node
     * @param measureList a list of statements
     */
    public PhraseStmt(int lineNum, MeasureList measureList) {
        super(lineNum);
        this.measureList = measureList;
        instrument = "Piano";
        octaveModifier = 0;
        volume = 11;
    }

    /** set phrase attributes */
    public void setInstrument(String instr) {this.instrument = instr;}
    public void setOctaveModifier(int modifier) {this.octaveModifier = modifier;}
    public void setVolume(int vol) {this.volume = vol;}


    /**
     * Get the measure list
     *
     * @return measure list
     */
    public MeasureList getIdList() {
        return measureList;
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
