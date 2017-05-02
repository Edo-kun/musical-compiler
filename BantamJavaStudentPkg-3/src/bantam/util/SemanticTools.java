/**
 * File: SemanticTools.java
 * This file was written in loving memory of our former
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
 * semantic analyzer. These methods are meant to simplify
 * common tasks throughout our visitors
 */
public class SemanticTools {
    public static final List<String> instruments = Stream.of(
            "piano", "chromatic_percussion", "organ", "guitar", "bass", "strings", "ensemble", "brass",
            "reed", "pipe", "synth_lead", "synth_pad", "synth_effects", "ethnic", "percussion", "sound_effects"
            ).collect(Collectors.toList());
    public static final String VAR = "field_variable";
    public static final String STRING = "string";
    public static final String INT = "int";
    public static final String PHRASE = "phrase";
    public static final int MAX_OCT = 4;
    public static final int MIN_OCT = -4;
    public static final int BPM = 4000;
    public static final Map<String, Integer> NOTES;
    static {
        Map<String, Integer> map = new HashMap<>();
        int midi = 55;
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
