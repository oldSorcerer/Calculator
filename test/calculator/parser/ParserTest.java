package calculator.parser;

import calculator.lexer.Lexer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    void check(String text)
    {
        try {
            Parser p = new Parser(Lexer.run(text));

            assertEquals(text, p.parse().toString());
        }
        catch (ParserException ex){
            assertEquals(null, ex);
        }
    }

    @Test
    void integer() {
        check("215");
    }

    @Test
    void doubleValue(){
        check("18.45");
    }

    @Test
    void intPlusInt(){
        check("12 + 5");
    }

    @Test
    void leftBrackets()
    {
        check("(2 + 3) * 5.7");
    }

    @Test
    void leftMultiply()
    {
        check("2 * 5.7 + 3");
    }


    @Test
    void rightBrackets()
    {
        check("2 * (5.7 + 3)");
    }

    @Test
    void doubleBrackets()
    {
        check("2 * (2.5 + 9) / (5.7 - 8)");
    }
    @Test
    void doubleBrackets2() throws ParserException
    {
        Parser p = new Parser(Lexer.run("2 * ((2.5 + 9)) / (((5.7 - 8)))"));

        assertEquals("2 * (2.5 + 9) / (5.7 - 8)", p.parse().toString());
    }

    @Test
    void X(){
        check("x * x + 85");
    }

    @Test
    void Fun(){
        check("sin(x) + log(x + 5, 3.4)");
    }

    @Test
    void Pi()
    {
        check("pi()");
    }
}