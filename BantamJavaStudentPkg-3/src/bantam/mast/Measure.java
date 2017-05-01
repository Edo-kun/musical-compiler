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
 * The <tt>Measure</tt> class represents a phrase statement, which
 * contains a list of measures.  It contains instrument/octaveExpr/volume
 * info
 * (<tt>MeasureList</tt>).
 *
 * @see ASTNode
 * @see Stmt
 */
public class Measure extends ASTNode{
    /**
     * A list of sounds
     */
    protected SoundList soundList;

    /**
     * Measure constructor
     *
     * @param lineNum  source line number corresponding to this AST node
     * @param soundList a list of sounds
     */
    public Measure(int lineNum, SoundList soundList) {
        super(lineNum);
        this.soundList = soundList;
    }

    /**
     * Get the sound list
     *
     * @return sound list
     */
    public SoundList getSoundList() {
        return soundList;
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
