/**
 * File: ParserTest.java
 * @author djskrien
 * @author Victoria Chistolini
 * @author Edward (osan) Zhou
 * @author Alex Rinker
 * @author Vivek Sah
 * Class: CS461
 * Project: 2
 * Date: Feb 21, 2017
 */

package bantam.parser;

import bantam.mast.*;

import java_cup.runtime.Symbol;
import bantam.lexer.Lexer;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import bantam.util.ErrorHandler;

import java.io.StringReader;

import static org.junit.Assert.*;


public class ParserTest
{
    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @BeforeClass
    public static void begin() {
        /* add here any initialization code for all test methods. For example,
         you might want to initialize some fields here. */
    }

    /** tests the case of a score with no members */
    @Test
    public void emptyScoreTest() throws Exception {
        Parser parser = new Parser(new Lexer(new StringReader("score \"Chromatic\" {}")));
        Symbol result = parser.parse();
        assertEquals(0, parser.getErrorHandler().getErrorList().size());
        assertNotNull(result);
        Score score = ((Program) result.value).getScore();
        assertEquals("\"Chromatic\"", score.getName());
        assertEquals(0, score.getMemberList().getSize());
    }

    /**
     * tests the case of a missing right brace at end of a class def
     * using an ExpectedException Rule
     */
    @Test
    public void unmatchedLeftBraceTest1() throws Exception {
        Parser parser = new Parser(new Lexer(new StringReader("score \"Chromatic\" {")));
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Bantam parser found errors.");
        parser.parse();
    }


    /**
     * A field test
     */
    @Test
    public void FieldTest() throws Exception {
        legalCodetest("$x = instr \"Piano\" <abcd>;");
        illegalCodetest("$x = instr 3 <abd;");
        illegalCodetest("x = instr 3 <abd>;");
    }

    /**
     * A legal loop-statement
     */
    @Test
    public void LoopTest() throws Exception {
        legalCodetest("loop 3 {<abcd>;} ");
        illegalCodetest("loop loop 3 {<abcd>;} ");
        illegalCodetest("loop 3 {<abcd>} ");
    }

    /**
     * A call statement
     */
    @Test
    public void CallTest() throws Exception {
        legalCodetest("$x;");
        illegalCodetest("$x");
    }

    /**
     * A block statement
     */
    @Test
    public void BlockTest() throws Exception {
        legalCodetest("[<abcd>,<cdef>];"); //play two phrases together
        legalCodetest("[<abcd><cdef>];"); // phrase spanning two measures
        illegalCodetest("[<abcd>,<cdef>]");
        illegalCodetest("[<abcd<cdef>];");
    }

    /**
     * A legal phrase stmt and phrase expr
     */
    @Test
    public void PhraseTest() throws Exception {
        legalCodetest("<abcd>;");
        legalCodetest("<a+b-c-d->;"); //chromatics
        legalCodetest("instr \"Piano\" oct -1 vol 11 <abcd>;");
        legalCodetest("oct -1 vol 11 <abcd>;");
        legalCodetest("vol 11 oct +1 <abcd>;");
        legalCodetest("vol 11 instr \"Harpsichord\" <a+|-3><abcd>;");
        illegalCodetest("instr oct -1 vol 11 <abcd<;");
    }

    /**
     * A legal chord test
     * @throws Exception
     */
    @Test
    public void ChordTest() throws Exception {
        legalCodetest("<(abcd)bcd>;");
        legalCodetest("<(abcd)(a+b+c+d+)(a)d>;");
        illegalCodetest("<(abcd(a+b+c+d+)(a)d>;");

    }

    /**
     * A generic legality test, the input string should be a representation of
     * a legal bantam java file
     * @params legalCode a String of legal Bantam Java code.
     */
    private void legalCodetest(String legalCode) throws Exception {
        Parser parser = new Parser(
                            new Lexer(new StringReader("score \"Chromatic\" {"+ legalCode +"}")));
        boolean thrown = false;

        try {
            parser.parse();
        } catch (RuntimeException e) {
            thrown = true;
            assertEquals("Bantam parser found errors.", e.getMessage());
            for (ErrorHandler.Error err : parser.getErrorHandler().getErrorList()) {
                System.out.println(err);
            }
        }
        assertFalse(thrown);
    }

    /**
     * A generic illegality test, the input string should be a representation of
     * an illegal bantam java file
     * @params illegalCode a String of illegal Bantam Java code.
     */
    private void illegalCodetest(String illegalCode) throws Exception {
        Parser parser = new Parser(
                            new Lexer(new StringReader("score \"Chromatic\" {"+ illegalCode +"}")));
        boolean thrown = false;
        try {
            parser.parse();
        } catch (RuntimeException e) {
            thrown = true;
            assertEquals("Bantam parser found errors.", e.getMessage());
            for (ErrorHandler.Error err : parser.getErrorHandler().getErrorList()) {
                System.out.println(err);
            }
        }
        assertTrue(thrown);
    }

}