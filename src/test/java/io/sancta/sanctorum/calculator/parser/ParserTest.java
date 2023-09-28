package io.sancta.sanctorum.calculator.parser;

import io.sancta.sanctorum.calculator.lexer.Lexer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    void check(String text) {
        try {
            Parser parser = new Parser(Lexer.run(text));

            assertEquals(text, parser.parse().toString());
        } catch (ParserException ex) {
            assertNull(ex);
        }
    }

    @Test
    void integer() {
        check("215");
    }

    @Test
    void doubleValue() {
        check("18.45");
    }

    @Test
    void intPlusInt() {
        check("12 + 5");
    }

    @Test
    void leftBrackets() {
        check("(2 + 3) * 5.7");
    }

    @Test
    void leftMultiply() {
        check("2 * 5.7 + 3");
    }


    @Test
    void rightBrackets() {
        check("2 * (5.7 + 3)");
    }

    @Test
    void doubleBrackets() {
        check("2 * (2.5 + 9) / (5.7 - 8)");
    }

    @Test
    void doubleBrackets2() throws ParserException {
        Parser parser = new Parser(Lexer.run("2 * ((2.5 + 9)) / (((5.7 - 8)))"));

        assertEquals("2 * (2.5 + 9) / (5.7 - 8)", parser.parse().toString());
    }

    @Test
    void X() {
        check("x * x + 85");
    }

    @Test
    void Fun() {
        check("sin(x) + log(x + 5, 3.4)");
    }

    @Test
    void Pi() {
        check("pi()");
    }

    @Test
    void If() {
        check("if(2 * 2 = 5, 3 + 7, 4 * 8)");
    }

    @Test
    void If2() {
        check("if(5 > 2 + 2)");
    }

}