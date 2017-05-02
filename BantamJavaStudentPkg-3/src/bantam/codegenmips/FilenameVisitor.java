/**
 * File: FilenameVisitor.java
 * @author Edward (osan) Zhou
 * @author Alex Rinker
 * @author Vivek Sah
 * Class: CS461
 * Project: 4A
 * Date: March 30 2017
 */

package bantam.codegenmips;

import bantam.mast.*;
import bantam.util.ClassTreeNode;
import bantam.util.ErrorHandler;
import bantam.util.SemanticTools;

import java.util.Hashtable;
import java.util.Map;

/**
 * This visitor determines the name of the file containing
 * the main class
 */
public class FilenameVisitor extends bantam.visitor.MusicVisitor{

    /** The String representing the filename associated the the program */
    private String filename;

    /**
     * returns the filename containing the Main class
     * provided the given root node of the program
     * @param root
     * @return
     */
    public String getMainFilename(Program root) {
        this.filename = root.getScore().getFilename();

        return this.filename;
    }

}
