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

package bantam.visitor;

import bantam.mast.*;

import java.util.Iterator;

/**
 * Abstract bantam.MusicVisitor class for traversing the AST
 */
public abstract class MusicVisitor {
    /**
     * Visit an AST node (should never be called)
     *
     * @param node the AST node
     * @return result of the visit
     */
    public Object visit(ASTNode node) {
        throw new RuntimeException("This astNode method should not be called (node is abstract)");
    }

    /**
     * Visit a list node (should never be called)
     *
     * @param node the list node
     * @return result of the visit
     */
    public Object visit(ListNode node) {
        throw new RuntimeException("This listNode method should not be called (node is abstract)");
    }

    /**
     * Visit a program node
     *
     * @param node the program node
     * @return result of the visit
     */
    public Object visit(Program node) {
        node.getScore().accept(this);
        return null;
    }

    /**
     * Visit a score node
     *
     * @param node the class node
     * @return result of the visit
     */
    public Object visit(Score node) {
        node.getMemberList().accept(this);
        return null;
    }

    /**
     * Visit a list node of members
     *
     * @param node the member list node
     * @return result of the visit
     */
    public Object visit(MemberList node) {
        for (ASTNode child : node)
            child.accept(this);
        return null;
    }

    /**
     * Visit a member node (should never be called)
     *
     * @param node the member node
     * @return result of the visit
     */
    public Object visit(Member node) {
        throw new RuntimeException("This member method should not be called (node is abstract)");
    }

    /**
     * Visit a field node
     *
     * @param node the field node
     * @return result of the visit
     */
    public Object visit(Field node) {
        if (node.getInit() != null) {
            node.getInit().accept(this);
        }
        return null;
    }

    /**
     * Visit a list node of statements
     *
     * @param node the statement list node
     * @return result of the visit
     */
    public Object visit(StmtList node) {
        for (Iterator it = node.iterator(); it.hasNext(); )
            ((Stmt) it.next()).accept(this);
        return null;
    }

    /**
     * Visit a statement node (should never be called)
     *
     * @param node the statement node
     * @return result of the visit
     */
    public Object visit(Stmt node) {
        throw new RuntimeException("This stmt method should not be called (node is abstract)");
    }

    /**
     * Visit a loop statement node
     *
     * @param node the loop node
     * @return result of the visit
     */
    public Object visit(LoopStmt node) {
        node.getExpr().accept(this);
        node.getStmtList().accept(this);
        return null;
    }

    /**
     * Visit a phrase expr node
     *
     * @param node the phrase expr node
     * @return result of the visit
     */
    public Object visit(PhraseExpr node) {
        if (node.getInstrument() != null) {
            node.getInstrument().accept(this);
        }
        if (node.getOctaveModifier() != null) {
            node.getOctaveModifier().accept(this);
        }
        if (node.getVolume() != null) {
            node.getVolume().accept(this);
        }
        node.getMeasureList().accept(this);
        return null;
    }

    /**
     * Visit an call statement node
     *
     * @param node the call statement node
     * @return result of the visit
     */
    public Object visit(CallStmt node) {
        node.getExpr().accept(this);
        return null;
    }

    /**
     * Visit a block statement node
     *
     * @param node the blcok statement node
     * @return result of the visit
     */
    public Object visit(BlockStmt node) {
        node.getExprList().accept(this);
        return null;
    }

    /**
     * Visit a list node of measures
     *
     * @param node the measure list node
     * @return result of the visit
     */
    public Object visit(MeasureList node) {
        for (Iterator it = node.iterator(); it.hasNext(); )
            ((Measure) it.next()).accept(this);
        return null;
    }

    /**
     * Visit a list node of sound
     *
     * @param node the sound list node
     * @return result of the visit
     */
    public Object visit(SoundList node) {
        for (Iterator it = node.iterator(); it.hasNext(); )
            ((Sound) it.next()).accept(this);
        return null;
    }

    /**
     * visit a measure node
     * @param node the measure node
     * @return result of the visit
     */
    public Object visit(Measure node) {
        node.getSoundList().accept(this);
        return null;
    }

    public Object visit(Sound node) {
        throw new RuntimeException("This sound method should not be called (node is abstract)");
    }

    /**
     * visit a chord node
     * @param node
     * @return
     */
    public Object visit(Chord node) {
        node.getSoundList().accept(this);
        return null;
    }

    /**
     * visit a note node
     * @param node
     * @return
     */
    public Object visit(Note node) {
        if (node.getOctaveExpr() != null) {
            node.getOctaveExpr().accept(this);
        }
        return null;
    }

    /**
     * Visit a constant expression node (should never be called)
     *
     * @param node the constant expression node
     * @return result of the visit
     */
    public Object visit(ConstExpr node) {
        throw new RuntimeException("This constExpr method should not be called (node is abstract)");
    }


    /**
     * Visit a variable expression node
     *
     * @param node the variable expression node
     * @return result of the visit
     */
    public Object visit(ConstVarExpr node) {
        return null;
    }

    /**
     * Visit an int constant expression node
     *
     * @param node the int constant expression node
     * @return result of the visit
     */
    public Object visit(ConstIntExpr node) {
        return null;
    }

    /**
     * Visit a string constant expression node
     *
     * @param node the string constant expression node
     * @return result of the visit
     */
    public Object visit(ConstStringExpr node) {
        return null;
    }
}
