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
 * The <tt>Score</tt> score represents a score declaration,
 * which consists of a filename (<tt>filename</tt>), a class name
 * (<tt>name</tt),
 * and a list of members (<tt>members</tt>) which can be either field
 * or stmt
 * @see bantam.mast.ASTNode
 */
public class Score extends ASTNode {
    /**
     * The filename of the file containing this score
     */
    protected String filename;

    /**
     * The name of this score
     */
    protected String name;

    /**
     * List of the class members
     */
    protected MemberList memberList;

    /**
     * Class_ constructor
     *
     * @param lineNum    source line number corresponding to this AST node
     * @param filename   the filename of the file containing this class
     * @param name       the name of this class
     * @param memberList a list of the class members
     */
    public Score(int lineNum, String filename, String name, MemberList memberList) {
        super(lineNum);
        this.filename = filename;
        this.name = name;
        this.memberList = memberList;
    }

    /**
     * Get the filename of the file containing this score
     *
     * @return file name
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Get the name of this score
     *
     * @return class name
     */
    public String getName() {
        return name;
    }

    /**
     * Get list of members that this score contains
     *
     * @return list of fields
     */
    public MemberList getMemberList() {
        return memberList;
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
