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
 * The <tt>Note</tt> class represents a Note, which
 * contains a sound
 *
 * @see ASTNode
 * @see Sound
 */
public class Note extends Sound {

    /** Note attributes */
    protected String name;
    protected String modifier;
    protected Expr octaveExpr;

    /** specific play attributes */
    protected int octave;
    /** for block playing */
    protected String instrument;
    protected int volume;

    /**
     * Note constructor
     *
     * @param lineNum  source line number corresponding to this AST node
     * @param name A-G
     * @param modifier + or -
     */
    public Note(int lineNum, String name, String modifier) {
        super(lineNum, new SoundList(lineNum));
        this.name = name;

        if (modifier != null) {
            this.modifier = modifier;
        } else {
            this.modifier = "";
        }
    }

    public Note(int lineNum, String name, String modifier, Expr expr) {
        super(lineNum, new SoundList(lineNum));
        this.name = name;
        this.octaveExpr = expr;

        if (modifier != null) {
            this.modifier = modifier;
        } else {
            this.modifier = "";
        }
    }

    /**
     * get name A-G
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOctave(int octave) {
        this.octave = octave;
    }

    public int getOctave() { return this.octave; }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public Expr getOctaveExpr(){
        return this.octaveExpr;
    }

    /** get modifier */
    public String getModifier() {
        return modifier;
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
