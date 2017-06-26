Bad4tunes Musical Java Compiler Project
-based off the bantam java compiler template
src contents: 
  bad4tunes uses JLex and Java Cup. 

  bantam - contains the bad4tunes compiler for the base language (uses JLex/Java Cup):
           build.xml - an ant XML for compiling the source
	   Main.java - the main program for the compiler
	   lexer - a package containing the lexer:
	           lexer.jlex - lexer specification 
		   Token.java - token passed from lexer to parser
	   parser - a package containing the parser:
	            parser.cup - parser specification
		    TokenIds.java - generated class containing token ids
	   semant - a package containing the semantic analyzer
                    SemanticAnalyzer.java - semantic analyzer
           codegenmips - a package containing the code generator
		     	 CodeGenerator.java - MIPS code generator 
		         MipsSupport.java - a support file that provides 
                           architectural support for the Mips ISA
           ast - a package containing the AST classes
                 *.java - each class in this directory represents a node in the
		 MAST
           util - a package containing some utilties
	          SymbolTable.java - a class representing a scoped symbol table
		    (maps Strings to Objects, which may represent type, location, etc.)
		  Location.java - a class representing a variable location
		    in memory or a register
                  ErrorHandler.java - a class for handling error reporting and exiting
		  ClassTreeNode.java - class for generating node the class hierarchy tree
           visitor - a package containing visitor classes
	             Visitor.java - abstract visitor class that other visitors extend

tests contents:
  *.bft - Several bad4tunes programs for testing out the compiler

To build the source code for the compiler, run the ant build for the lexer 
and parser. 

Have fun!!!
