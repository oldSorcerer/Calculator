package calculator.parser;

import calculator.lexer.Lexer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    void check(String text)
    {
        Parser p = new Parser(Lexer.run(text));

        assertEquals(text, p.parse().toString());
    }

    @Test
    void integer() {
        check("215");
    }

    @Test
    void doubleValue(){
        check("18.45");
    }
}