/**
 * File: LexerTest.java
 * @author Edward (osan) Zhou
 * @author Alex Rinker
 * @author Vivek Sah
 * Class: CS461
 * Project: 5
 * Date: April 26, 2017
 */

package bantam.lexer;

import java_cup.runtime.Symbol;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.StringReader;

import static org.junit.Assert.assertEquals;

/**
 * This class tests all of the Lexer token identifications
 */
public class LexerTest
{
    @BeforeClass
    public static void begin() {
        System.out.println("begin");
    }
    /**
     * Check if the class key word is recognized
     */
    @Test
    public void keywordTokens() throws Exception {
        checkToken(" score ", "SCORE");
        checkToken(" \"Chroma\" ", "STRING_CONST");
        checkToken(" score ", "SCORE");
        checkToken(" instr ", "INSTRUMENT");
        checkToken(" vol ", "VOLUME");
        checkToken(" oct ", "OCTAVE");
        checkToken(" loop ", "LOOP");
    }

    /**
     * Check if the divide symbol is recognized
     */
    @Test
    public void alteringTokens() throws Exception {
        checkToken(" - ", "MINUS");
        checkToken(" + ", "PLUS");
    }

    /**
     * Check if braces and parentheses are recognized
     */
    @Test
    public void braceTokens() throws Exception {
        checkToken(" [ ", "LSQBRACE");
        checkToken(" ] ", "RSQBRACE");
        checkToken("{", "LBRACE");
        checkToken("}", "RBRACE");
        checkToken(" ( ", "LPAREN");
        checkToken(" ) ", "RPAREN");
        checkToken(" < ", "LBREAK");
        checkToken(">", "RBREAK");
    }


    /**
     * Check if the comma symbol is recognized
     */
    @Test
    public void commaToken() throws Exception {
        checkToken(" , ", "COMMA");
    }

    /**
     * Check if the semi colin is recognized
     */
    @Test
    public void semiToken() throws Exception {
        checkToken(" ; ", "SEMI");
    }

    /**
     * Check if the assignment symbol is recognized
     */
    @Test
    public void assignToken() throws Exception {
        checkToken(" = ", "ASSIGN");
    }

    /**
     * Check if an identifier is recognized
     * Thus we determine if the two incorrect identifiers are correctly not
     * recognized: 1 - begin with digit; 2 - begin with underscore
     */
    @Test
    public void idToken() throws Exception {
        checkToken(" $abc ", "ID");
        checkToken(" 9abc ", "ILLEGAL_ID");
        checkToken(" :abc ", "NOTE"); // _ is the note rest
        checkToken(" abc ", "NOTE");
        checkToken(" bc ", "NOTE");
        checkToken(" c ", "NOTE");
        checkToken(" _", "NOTE");
        checkToken(" h", "ILLEGAL_NOTE");
    }

    /**
     * Check if integers are correctly recognized
     */
    @Test
    public void largeIntToken() throws Exception {
        checkToken(" 11 ", "INT_CONST");
        checkToken(" 2147483648 ", "LARGE_INT");
    }

    /**
     * Check if strings are correctly identified.
     */
    @Test
    public void longStringToken() throws Exception {
        String str1 = "\"";
        String str2 = "\"";
        for(int i=0; i<4998; i++) { //4998 due to the two '\' chars which are counted
            str1+= "A";
            str2+= "B";
        }
        str1+="\"";
        str2+="B\"";
        checkToken(str1, "STRING_CONST");
        checkToken(str2, "LARGE_STRING");
    }

    /**
     * Check that comments are properly ignored
     */
    @Test
    public void commentToken() throws Exception {
        checkToken("/* this is a comment \n /* */", "EOF");
    }

    /**
     * Check if empty of file indicator token works correctly
     */
    @Test
    public void EOFToken() throws Exception {
        checkToken("","EOF");
    }

    /**
     * Check if unterminated comments, strings and multi line strings are
     * correctly handled
     */
    @Test
    public void lexErrorToken() throws Exception {
        checkToken("/*  abc", "UNTERMINATED_COMMENT");
        checkToken("\" abc", "UNTERMINATED_STRING");
        checkToken("\"abc\nabc\"", "MULTILINE_STRING");
    }

    /**
     * Check if the an illegal escape is recognized
     */
    @Test
    public void illegalEscapeToken() throws Exception {
        checkToken("\"\\n \"", "STRING_CONST");
        checkToken("\"\\a \"", "ILLEGAL_ESCAPE_CHAR");
    }

    /**
     * Check if an illegal character is recognized
     */
    @Test
    public void illegalToken() throws Exception {
        checkToken("\\ ", "ILLEGAL_CHAR");
    }

    /**
     * Checks equality of String with the expected token from the Lexer
     */
    private void checkToken(String str, String expectedToken) throws Exception{
        Lexer lexer = new Lexer(new StringReader(str));
        Symbol token = lexer.next_token();
        String s = ((Token)token.value).getName();
        assertEquals(expectedToken,s);
    }
}