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

/**
 * File: SemanticAnalyzer.java
 * This file was written in loving memory of our former
 * group member Victoria Chistolini who sadly did not
 * survive project 2.5. R.I.P.
 * @author Edward (osan) Zhou
 * @author Alex Rinker
 * @author Vivek Sah
 * Class: CS461
 * Project: 3
 * Date: March 9 2017
 */

package bantam.semant;

import bantam.mast.*;
import bantam.util.*;
import bantam.visitor.*;

/** The <tt>SemanticAnalyzer</tt> class performs semantic analysis.
  * In particular this class is able to perform (via the <tt>analyze()</tt>
  * method) the following tests and analyses: (1)
  * legal member declaration, (2) there is a correct score,
  * and (3) each expression is correctly typed and used.
  *
  * */
public class SemanticAnalyzer {
    /** Root of the AST */
    private Program program;
    
    /** Object for error handling */
    private ErrorHandler errorHandler = new ErrorHandler();
    
    /** Boolean indicating whether debugging is enabled */
    private boolean debug = false;

    /** Maximum number of inherited and non-inherited fields that can be defined for any one class */
    private final int MAX_NUM_FIELDS = 1500;

    /** SemanticAnalyzer constructor
      * @param program root of the AST
      * @param debug boolean indicating whether debugging is enabled
      * */
    public SemanticAnalyzer(Program program, boolean debug) {
	this.program = program;
	this.debug = debug;
    }
    
    /** Analyze the AST checking for semantic errors and annotating the nodes
      * @return root of the tree (needed for code generation)
      *
      * */
    public Program analyze() {
	    // 1 - check the score
        checkScore(); // in preparation for future expansions

        // 2 - check types and populate ast node fields
        checkTypes();

        // 3 - check variables for declarations
        checkVariables();

        // comment out
        //throw new RuntimeException("Semantic analyzer unimplemented");

        // uncomment out
        this.errorHandler.checkErrors();
        return this.program;
    }

    /**
     * @return the ErrorHandler for this Parser
     */
    public ErrorHandler getErrorHandler() { return errorHandler; }


    private void checkScore() {
        ScoreVisitor scoreVisitor = new ScoreVisitor(program, errorHandler);
        scoreVisitor.checkScore();
    }

    /**
     * Make sure variables are used correctly
     */
    private void checkVariables() {
        VarVisitor varVisitor = new VarVisitor(program, errorHandler);
        varVisitor.checkVariables();
    }

    private void checkTypes() {
        TypeVisitor typeVisitor = new TypeVisitor(program, errorHandler);
        typeVisitor.checkTypes();
    }

//    /** Add built in classes to the class tree
//      * */
//    private void updateBuiltins() {
//	// create AST node for object
//	Class_ astNode =
//	    new Class_(-1, "<built-in class>", "Object", null,
//		       (MemberList)(new MemberList(-1))
//		       .addElement(new Method(-1, "Object", "clone",
//					      new FormalList(-1),
//					      (StmtList)(new StmtList(-1))
//					      .addElement(new ReturnStmt(-1, new VarExpr(-1, null, "null")))))
//		       .addElement(new Method(-1, "boolean", "equals",
//					      (FormalList)(new FormalList(-1))
//					      .addElement(new Formal(-1, "Object", "o")),
//					      (StmtList)(new StmtList(-1))
//					      .addElement(new ReturnStmt(-1, new ConstBooleanExpr(-1, "false")))))
//		       .addElement(new Method(-1, "String", "toString",
//					      new FormalList(-1),
//					      (StmtList)(new StmtList(-1))
//					      .addElement(new ReturnStmt(-1, new VarExpr(-1, null, "null"))))));
//	// create a class tree node for object, save in variable root
//	root = new ClassTreeNode(astNode, /*built-in?*/true, /*extendable?*/true, classMap);
//	// add object class tree node to the mapping
//	classMap.put("Object", root);
//
//	// note: String, TextIO, and Sys all have fields that are not shown below.  Because
//	// these classes cannot be extended and fields are protected, they cannot be accessed by
//	// other classes, so they do not have to be included in the AST.
//
}
