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

import bantam.mast.ASTNode;
import bantam.mast.Member;
import bantam.mast.Stmt;
import bantam.visitor.MusicVisitor;


/**
 * The <tt>Field</tt> class represents a field (instance variable) declaration
 * appearing in a score declaration.  It contains a variable
 * name and an initialized stmt.
 *
 * @see ASTNode
 */
public class Field extends Member {
    /**
     * The name of the field
     */
    protected String name;

    /**
     * The initialization stmt
     */
    protected Stmt init;

    /**
     * Field constructor
     *
     * @param lineNum source line number corresponding to this AST node
     * @param name    the name of the field (instance variable)
     * @param init    the initialization stmt
     */
    public Field(int lineNum, String name, Stmt init) {
        super(lineNum);
        this.name = name;
        this.init = init;
    }

    /**
     * Get the name of the field
     *
     * @return field name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the initialization stmt of the field
     *
     * @return initialization stmt
     */
    public Stmt getInit() {
        return init;
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
