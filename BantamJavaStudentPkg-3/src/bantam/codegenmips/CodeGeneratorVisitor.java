/**
 * File: CodeGeneratorVisitor.java
 * @author Edward (osan) Zhou
 * @author Alex Rinker
 * @author Vivek Sah
 * Class: CS461
 * Project: 4B
 * Date: April 5 2017
 */

package bantam.codegenmips;

import bantam.ast.*;
import bantam.util.SymbolTable;
import bantam.visitor.MusicVisitor;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Visitor for creating the .text code of mips
 */
public class CodeGeneratorVisitor extends MusicVisitor{
    /** support class for generating code in mips */
    private MipsSupport mipsSupport;

    /** Print stream for printing to a file */
    private PrintStream out;

    /** root of the class tree */
    private Program root;

    /** the current class being traversed */
    private Class_ currClass;

    /** Map containing the labels associated with each class */
    private Map<String, String> classNames;

    /** Map which connects String constants to their label */
    private Map<String, String> stringLabels;

    /** the current offset being used for the fields */
    private int currOffset;

    /** a flag representing whether or not we are generating inits this runthrough */
    private boolean generatingInits;

    /** a map associating each class to a Symbol Table */
    private Map<String, SymbolTable> classSymbolTables;

    /** a String representing the exit label for the current loop being traversed */
    private String loopExit;

    /** a counter representing the number of parameters currently denoted */
    private int numParams;

    /** builtin classes */
    private String[] builtins = {"Object", "String", "TextIO", "Sys"};

    /** current method end label */
    private String currentMethodEnd;

    private final String NULL = "null";

    /**
     * constructor method
     * @param root the root node of the program
     * @param mipsSupport the mipsSupport helper class
     * @param classNames a map of classnames and labels
     * @param stringLabels
     */
    public CodeGeneratorVisitor(
            Program root,
            MipsSupport mipsSupport,
            PrintStream out,
            Map<String, String> classNames,
            Map<String, String> stringLabels) {
        this.mipsSupport = mipsSupport;
        this.out = out;
        this.root = root;
        this.classNames = classNames;
        this.stringLabels = stringLabels;
        this.currOffset = -12;
        this.classSymbolTables = new HashMap<>();
    }

}
