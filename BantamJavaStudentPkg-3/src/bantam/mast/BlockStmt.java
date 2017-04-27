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

import bantam.mast.IdList;
import bantam.visitor.MusicVisitor;

/**
 * The <tt>BlockStmt</tt> class represents a block statement, which
 * contains a list of ids.  It contains a id list
 * (<tt>idList</tt>).
 *
 * @see ASTNode
 * @see Stmt
 */
public class BlockStmt extends Stmt {
    /**
     * A list of statements
     */
    protected IdList idList;

    /**
     * BlockStmt constructor
     *
     * @param lineNum  source line number corresponding to this AST node
     * @param idList a list of statements
     */
    public BlockStmt(int lineNum, IdList idList) {
        super(lineNum);
        this.idList = idList;
    }

    /**
     * Get the statement list
     *
     * @return statement list
     */
    public IdList getIdList() {
        return idList;
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
