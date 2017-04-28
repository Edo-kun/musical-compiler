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
        legalCodetest("$x = instr \"Piano\" |abcd|;");
    }

    /**
     * A legal if-statement
     */
    @Test
    public void ifTest() throws Exception {
        String ifStmt = "int x = 4; if (x>10) return;";
        String ifElseStmt = "int x = 4; if (x <15) x++ ; else return;";
        String ifElseNestedStmt = "int x = 4; if (x <15) x++ ; " +
                "                  else if (d < 5) f = 7; else  return;";
        legalCodetest("void ifMethod(){ "+ ifStmt + " }");
        legalCodetest("void ifMethod(){ "+ ifElseStmt + " }");
        legalCodetest("void ifMethod(){ "+ ifElseNestedStmt + " }");
    }

    /**
     * A boolean expressions test
     */
    @Test
    public void boolExprTest() throws Exception {
        legalCodetest("void sillyMethod(){if (true || false) return;}");
        legalCodetest("void sillyMethod(){if (true && false) return;}");
    }

    /**
     * A test to ensure that the lex error messages provide the
     * user with relevant debugging information
     */
    @Test
    public void lexErrorMessageTest() throws Exception {
        illegalCodetest("\nint 9a = 3; ");
    }




    /**
     * A legal for-loop
     */
    @Test
    public void forTest() throws Exception {
        legalCodetest("void ifMethod(){ for(;;) x=2; }");
        legalCodetest("void ifMethod(){ for(;;x=2) x=2; }");

        legalCodetest("void ifMethod(){ for(;x=2;) x=2; }");

        legalCodetest("void ifMethod(){ for(;x=2;x=3) x=2; }");
        legalCodetest("void ifMethod(){ for(x=2;;) x=2; }");

        legalCodetest("void ifMethod(){ for(x=2;;x=2) x=2; }");

        legalCodetest("void ifMethod(){ for(x=2;x=2;) x=2; }");
        legalCodetest("void ifMethod(){ for(x=2;x< 3;x++) x=2; }");
    }

    /**
     * Legal while statement
     */
    @Test
    public void whileTest() throws Exception {
        legalCodetest("void whileMethod(){ while(x=2 ) x++;  }");
    }

    /**
     * Legal break statement
     */
    @Test
    public void breakTest() throws Exception {
        legalCodetest("void breakMethod(){ break; }");
    }

    /**
     * Legal block statement
     */
    @Test
    public void blockTest() throws Exception {
        legalCodetest("void blockMethod(){ while(a < 3){ a=3;b=4;c=9;} }");
    }

    /**
     * Legal new expression
     */
    @Test
    public void newTest() throws Exception {
        legalCodetest("void newMethod(){ a = new Stuff(); }");
        legalCodetest("void newMethod(){ a = new String[5+6]; }");
    }


    /**
     * Legal cast expression
     */
    @Test
    public void castTest() throws Exception {
        legalCodetest("void newMethod(){ a = (int)( 6+9); }");
        legalCodetest("void newMethod(){ a = (int[])(\"String\"); }");
    }


    /**
     * binary arith expression, with all possible types of expressions
     */
    @Test
    public void binaryArithTest() throws Exception {

        // try minus binary arith test with stringConstExpr and newExpr
        legalCodetest("void newMethod(){ a = \"String\"++ - new array[10]; }");

        // try modulus bin arith with an instanceof expr
        legalCodetest("void newMethod(){ q = thing1 instanceof A % " +
                "                            thing2 instanceof B; }");

        // try addition bin arith with dynamic dispatches
        legalCodetest("void newMethod(){ this.Stuff[x++] + x=5.number(); }");

        // try divide bin arith with
        legalCodetest("void newMethod(){ q = (((thing[]) (junk)) / " +
                "      ((cooolerJunk) (intJunk) )); }");
    }



    /**
     * binary comparison expression, with binary logic
     */
    @Test
    public void binaryCompTest() throws Exception {
        // testing all binary comparisons with the binary logic OR
        legalCodetest("void newCompMethod(){ int a =0; if ( (--a == b) || (b !=c) ) " +
                      "{ b = ( (c < d) || (d <= e) ); f = ((g > h) || (h >= i));} }");
        // testing all binary comparisions with binary logic OR / AND
        legalCodetest("void newCompMethod(){ int a =0; if ( (a == b) || (b !=c) ) " +
                      "{ b = ( (c < d) && (d <= e) ); f = ((g > h) || (h >= i));} }");


    }


    @Test
    public void unaryTest() throws Exception {
        // testing negative unary
        legalCodetest("void unaryMethod(){ a=-b; b=!a; }");
        // unary incr
        legalCodetest("void unaryMethod(){ a=++b; b=a++; c = --d; d = c--; }");


    }

    /**
     * A test to see if dispatching works
     * @throws Exception
     */
    @Test
    public void dispatchTest() throws Exception {
        legalCodetest("void newMethod(){ int x = 4; a = blah.number(); }");
    }

    /**
     * A test to see if missing semicolons are caught
     */
    @Test
    public void missingSEMITest() throws Exception {
        legalCodetest("void sillyMethod() { int a = 4+5; }");
        legalCodetest("void sillyMethod() { return; }");
        legalCodetest("void sillyMethod() { break; }");
        legalCodetest("int i; void sillyMethod() { for(i=0 ; i<3 ; i++) { return; }}");
        illegalCodetest("void sillyMethod() { int a = 4 }");
        illegalCodetest("void sillyMethod() { return }");
        illegalCodetest("void sillyMethod() { break }");
        illegalCodetest("void sillyMethod() { for(int i=0 i<3 i++) { return; }");
    }

    /**
     * A test to see if unmatched parens are caught
     */
    @Test
    public void unmatchedParensTest() throws Exception {
        legalCodetest("void sillyMethod(){}");
        illegalCodetest("void sillyMethod({}");
        illegalCodetest("void sillyMethod){}");
    }

    @Test
    public void stringTest() throws Exception {
        legalCodetest("/**/ S h = \"b\";\n void b() { a = \"r\"; }");
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