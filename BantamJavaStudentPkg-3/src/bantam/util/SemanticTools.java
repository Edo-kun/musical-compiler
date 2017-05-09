/**
 * File: SemanticTools.java
 * This file was written in memory of our former
 * group member Victoria Chistolini who sadly did not
 * survive project 2.5. R.I.P.
 * @author Edward (osan) Zhou
 * @author Alex Rinker
 * @author Vivek Sah
 * Class: CS461
 * Project: 6
 * Date: April 30 2017
 */

package bantam.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * This class holds utility methods for use with the
 * semantic analyzer and Code generator
 * . These methods are meant to simplify
 * common tasks throughout our visitors
 */
public class SemanticTools {
    /** list of midi instruments index*/
    public static final List<String> instruments = Stream.of(
            "piano", "chromatic_percussion", "organ", "guitar", "bass", "strings",
            "ensemble", "brass", "reed", "pipe", "synth_lead", "synth_pad",
            "synth_effects", "ethnic", "percussion", "sound_effects"
            ).collect(Collectors.toList());

    /** the type for a field variable*/
    public static final String VAR = "field_variable";

    /** the type for a string const expr */
    public static final String STRING = "string";

    /** the type for an int const expr */
    public static final String INT = "int";

    /** the type for a phrase expr */
    public static final String PHRASE = "phrase";

    /** subtracts time to the wait duration to provide smoother note transition */
    public static final int SLEEP_MOD = 0;

    /** maximum octave modifier */
    public static final int MAX_OCT = 4;

    /** minimum octave modifer */
    public static final int MIN_OCT = -4;

    /** default ticks per measure */
    public static int TPM = 4000;

    /** map of a note string to its corresponding midi value */
    public static final Map<String, Integer> NOTES;
    static {
        Map<String, Integer> map = new HashMap<>();
        int midi = 56;
        for (char letter : "ab".toCharArray()) {
            map.put(String.valueOf(letter) + "-", midi);
            midi++;
            map.put(String.valueOf(letter), midi);
            midi++;
            map.put(String.valueOf(letter) + "+", midi);
        }
        midi--;
        map.put("c-", midi);
        midi++;
        map.put("c", midi);
        midi++;
        map.put("c+", midi);

        for (char letter : "de".toCharArray()) {
            map.put(String.valueOf(letter) + "-", midi);
            midi++;
            map.put(String.valueOf(letter), midi);
            midi++;
            map.put(String.valueOf(letter) + "+", midi);
        }
        midi--;
        map.put("f-", midi);
        midi++;
        map.put("f", midi);
        midi++;
        map.put("f+", midi);
        map.put("g-", midi);
        midi++;
        map.put("g", midi);
        midi++;
        map.put("g+", midi);
        map.put(":", -1);
        NOTES = Collections.unmodifiableMap(map);
    }

    /**
     * Returns true if the input string is a valid instrument
     * @param w the input in question
     * @return boolean
     */
    public static boolean isValidInstrument(String w) {
        String word = w.substring(1, w.length()-1);
        for ( String p : instruments) {
            for (int i = 0; i < 8; i++) {
                if (i == 0 && p.equalsIgnoreCase(word)) {
                    return true;
                } else {
                    if ((p + i).equalsIgnoreCase(word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Get instr int 0-127 based on string
     * @param str the instrument
     * @return
     */
    public static int getInstrumentVal(String str) {
        // strip ""
        String instr;
        if (str.charAt(0) == '"') {
            instr = str.substring(1, str.length() - 1);
        } else {
            instr = str;
        }
        String baseInstr;
        int instrMod;
        if (Character.isDigit(instr.charAt(instr.length()-1))) {
            baseInstr = instr.substring(0, instr.length()-1);
            instrMod = Integer.parseInt(instr.substring(instr.length()-1));
        } else {
            baseInstr = instr;
            instrMod = 0;
        }

        return (SemanticTools.instruments.indexOf(baseInstr) * 8) + instrMod;
    }

    /**
     * Get the sleep duration for each note
     * return -1 if empty
     * @param size length of the measure
     * @return
     */
    public static int getMeasureNoteLength(int size) {
        if (size == 0) {
            return  -1;
        }
        return SemanticTools.TPM / size;
    }


    /**
     * Generates a string from the input file
     * @param filename the file to be read
     * @return the contents of the file in String form
     */
    public static String generateStringFromTestfile(String filename) {
        filename = "testfiles/" + filename;
        String file = "";
        try {
            // \\Z represents the end of a file
            file = new Scanner(new File(filename)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            System.out.println("File '" + filename + "' was unable to be read");
        }
        return file;
    }
}
