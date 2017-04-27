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
 * The expr version of a phrase stmt
 */
public class PhraseExpr extends Expr {

    /**
     * A list of measures
     */
    protected MeasureList measureList;

    /** attributes of the phrase */
    protected ConstExpr instrument;
    protected ConstExpr octaveModifier;
    protected ConstExpr volume;

    /**
     * PhraseStmt constructor
     *
     * @param lineNum  source line number corresponding to this AST node
     * @param measureList a list of statements
     */
    public PhraseExpr(int lineNum, ConstExpr instrument, ConstExpr octaveModifier, ConstExpr volume, MeasureList measureList) {
        super(lineNum);
        this.instrument = instrument;
        this.octaveModifier = octaveModifier;
        this.volume = volume;
        this.measureList = measureList;
    }

    /** set phrase attributes */
    public void setInstrument(ConstExpr instr) {this.instrument = instr;}
    public void setOctaveModifier(ConstExpr modifier) {this.octaveModifier = modifier;}
    public void setVolume(ConstExpr vol) {this.volume = vol;}

    /** get phrase attribute expressions */
    public ConstExpr getInstrument() {
        return instrument;
    }

    public ConstExpr getOctaveModifier() {
        return octaveModifier;
    }

    public ConstExpr getVolume() {
        return volume;
    }

    /**
     * Get the measure list
     *
     * @return measure list
     */
    public MeasureList getMeasureList() {
        return measureList;
    }

    /**
     * Visitor method
     *
     * @param v bantam.visitor object
     * @return result of visiting this node
     * @see MusicVisitor
     */
    public Object accept(MusicVisitor v) {return v.visit(this);}
}
