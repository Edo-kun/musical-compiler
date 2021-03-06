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
 * File: MipsCodeGenerator.java
 * @author Edward (osan) Zhou
 * @author Alex Rinker
 * @author Vivek Sah
 * Class: CS461
 * Project: 4A
 * Date: March 30 2017
 */

package bantam.codegenmips;

import bantam.mast.PhraseExpr;
import bantam.mast.Program;

import java.io.PrintStream;

import java.util.*;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * The <tt>MipsCodeGenerator</tt> class generates mips assembly code
 * targeted for the MARS simulator
 * <p/>
 */
public class MipsCodeGenerator {
    private Program root;
    /** Print stream for output assembly file */
    private PrintStream out;

    /** Assembly support object (using Mips assembly support) */
    private MipsSupport assemblySupport;

    /** Map containing the variable to its phrase */
    private Map<String, PhraseExpr> scoreVariables;

    /**
     * Boolean indicating whether garbage collection is enabled
     */
    private boolean gc = false;

    /**
     * Boolean indicating whether optimization is enabled
     */
    private boolean opt = false;

    /**
     * Boolean indicating whether debugging is enabled
     */
    private boolean debug = false;

    /**
     * MipsCodeGenerator constructor
     *
     * @param root    root of the class hierarchy tree
     * @param outFile filename of the assembly output file
     * @param gc      boolean indicating whether garbage collection is enabled
     * @param opt     boolean indicating whether optimization is enabled
     * @param debug   boolean indicating whether debugging is enabled
     */
    public MipsCodeGenerator(Program root, String outFile,
                             boolean gc, boolean opt, boolean debug) {
        this.root = root;
        this.gc = gc;
        this.opt = opt;
        this.debug = debug;

        try {
            out = new PrintStream(new FileOutputStream(outFile));
            assemblySupport = new MipsSupport(out);
        } catch (IOException e) {
            // if don't have permission to write to file then report an error and exit
            System.err.println("Error: don't have permission to write to file '" + outFile + "'");
            System.exit(1);
        }
    }

    /**
     * Generate assembly file
     * <p/>
     * In particular, will need to do the following:
     * 1 - start the data section
     * 2 - generate data for the garbage collector
     * 3 - start the text section
     * 4 - generate user-defined phrases
     * See the lab manual for the details of each of these steps.
     */
    public void generate() {
        // comment out
        //throw new RuntimeException("MIPS code generator unimplemented");

        //Generate the File Header
        generateHeader();

        //1 - Start the data section
        out.println("\t.data");
        assemblySupport.genGlobal("gc_flag");

        //2 - Generate data for the garbage collector
        generateGCData();

        //3 - Start the Text section
        out.println();
        out.println("\t.text");

        //4 - generate music
        generateMusic();
    }

    //Below are the Helper Functions for the generate() method

    /**
     * This function generates a file header for the MIPS assembly file
     * containing information about the authors, date, and compiled .btm file
     */
    private void generateHeader() {
        assemblySupport.genComment("Authors: Vivek Sah, Alex Rinker, Ed Zhou");
        Calendar cal = Calendar.getInstance();
        String month = cal.getDisplayName(
                Calendar.MONTH, Calendar.LONG, Locale.getDefault()
        );
        int year = cal.get(Calendar.YEAR);
        assemblySupport.genComment("Date: " + month + " " + year);

        FilenameVisitor fVisitor = new FilenameVisitor();

        assemblySupport.genComment(
                "Compiled From Sources: " + fVisitor.getMainFilename(root)
        );
        out.println();
    }

    /**
     * This function generates data for the Garbage collector to use in the
     * MIPS assembly file.
     * Currently this method only sets the gc_flag to 0
     */
    private void generateGCData() {
        assemblySupport.genLabel("gc_flag");
        assemblySupport.genWord("0");
    }

    private void generateMusic() {
        CodeGeneratorVisitor codeGeneratorVisitor = new CodeGeneratorVisitor(root, assemblySupport);
        codeGeneratorVisitor.generate();
    }





}
