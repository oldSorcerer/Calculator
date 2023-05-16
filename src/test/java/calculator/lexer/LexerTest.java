package calculator.lexer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LexerTest {
    @Test
    void singleInt() {
        List<Lexeme> lexes = Lexer.run("38");

        assertEquals(1, lexes.size());
        assertEquals("38", lexes.get(0).getText());
        assertEquals(LexemeType.Digits, lexes.get(0).getType());
    }

    @Test
    void singleFloat() {
        List<Lexeme> lexes = Lexer.run("18.3");

        assertEquals(3, lexes.size());
        assertEquals("18", lexes.get(0).getText());
        assertEquals(LexemeType.Digits, lexes.get(0).getType());
        assertEquals(LexemeType.Dot, lexes.get(1).getType());
        assertEquals("3", lexes.get(2).getText());
        assertEquals(LexemeType.Digits, lexes.get(2).getType());
    }

    @Test
    void numberError() {
        List<Lexeme> lexes = Lexer.run("18.3zz33");

        assertEquals(6, lexes.size());
        assertEquals(LexemeType.Error, lexes.get(3).getType());
        assertEquals(LexemeType.Error, lexes.get(4).getType());
        assertEquals("33", lexes.get(5).getText());
        assertEquals(LexemeType.Digits, lexes.get(5).getType());
    }

    @Test
    void space() {
        List<Lexeme> lexes = Lexer.run("18  + 4");

        assertEquals(5, lexes.size());
        assertEquals("18", lexes.get(0).getText());
        assertEquals(LexemeType.Digits, lexes.get(0).getType());
        assertEquals(LexemeType.Space, lexes.get(1).getType());
        assertEquals(LexemeType.Operator, lexes.get(2).getType());
        assertEquals(LexemeType.Space, lexes.get(3).getType());
        assertEquals("4", lexes.get(4).getText());
        assertEquals(LexemeType.Digits, lexes.get(4).getType());
    }

    @Test
    void bracket() {
        List<Lexeme> lexes = Lexer.run("15*@(19.8-3.3)");

        assertEquals(12, lexes.size());
        assertEquals("15", lexes.get(0).getText());
        assertEquals(LexemeType.Digits, lexes.get(0).getType());
        assertEquals(LexemeType.Operator, lexes.get(1).getType());
        assertEquals(LexemeType.Error, lexes.get(2).getType());
        assertEquals(LexemeType.OpenBracket, lexes.get(3).getType());
        assertEquals("19", lexes.get(4).getText());
        assertEquals(LexemeType.Digits, lexes.get(4).getType());
        assertEquals(LexemeType.Dot, lexes.get(5).getType());
        assertEquals("8", lexes.get(6).getText());
        assertEquals(LexemeType.Digits, lexes.get(6).getType());
        assertEquals(LexemeType.Operator, lexes.get(7).getType());
        assertEquals("3", lexes.get(8).getText());
        assertEquals(LexemeType.Digits, lexes.get(8).getType());
        assertEquals(LexemeType.Dot, lexes.get(9).getType());
        assertEquals("3", lexes.get(10).getText());
        assertEquals(LexemeType.Digits, lexes.get(10).getType());
        assertEquals(LexemeType.CloseBracket, lexes.get(11).getType());

    }

    @Test
    void X() {
        List<Lexeme> lexes = Lexer.run("x * x");

        assertEquals(5, lexes.size());
        assertEquals(LexemeType.X, lexes.get(0).getType());
        assertEquals(LexemeType.Space, lexes.get(1).getType());
        assertEquals(LexemeType.Operator, lexes.get(2).getType());
        assertEquals(LexemeType.Space, lexes.get(3).getType());
        assertEquals(LexemeType.X, lexes.get(4).getType());
    }

    @Test
    void Fun() {
        List<Lexeme> lexes = Lexer.run("sin(x) + cos(x)");

        assertEquals(11, lexes.size());
        assertEquals(LexemeType.NameFunc, lexes.get(0).getType());
        assertEquals("sin", lexes.get(0).getText());
        assertEquals(LexemeType.OpenBracket, lexes.get(1).getType());
        assertEquals(LexemeType.X, lexes.get(2).getType());
        assertEquals(LexemeType.CloseBracket, lexes.get(3).getType());
        assertEquals(LexemeType.Space, lexes.get(4).getType());
        assertEquals(LexemeType.Operator, lexes.get(5).getType());
        assertEquals(LexemeType.Space, lexes.get(6).getType());
        assertEquals(LexemeType.NameFunc, lexes.get(7).getType());
        assertEquals("cos", lexes.get(7).getText());
        assertEquals(LexemeType.OpenBracket, lexes.get(8).getType());
        assertEquals(LexemeType.X, lexes.get(9).getType());
        assertEquals(LexemeType.CloseBracket, lexes.get(10).getType());

    }

    @Test
    void If() {
        List<Lexeme> lexes = Lexer.run("if(2 * 2 = 5, 3 + 7, 4 * 8)");

        assertEquals(26, lexes.size());
        assertEquals(LexemeType.NameFunc, lexes.get(0).getType());
        assertEquals("if", lexes.get(0).getText());
        assertEquals(LexemeType.OpenBracket, lexes.get(1).getType());
        assertEquals(LexemeType.Digits, lexes.get(2).getType());
        assertEquals(LexemeType.Space, lexes.get(3).getType());
        assertEquals(LexemeType.Operator, lexes.get(4).getType());
        assertEquals(LexemeType.Space, lexes.get(5).getType());
        assertEquals(LexemeType.Digits, lexes.get(6).getType());
        assertEquals(LexemeType.Space, lexes.get(7).getType());
        assertEquals(LexemeType.CompareOperator, lexes.get(8).getType());
        assertEquals("=", lexes.get(8).getText());
        assertEquals(LexemeType.Space, lexes.get(9).getType());
        assertEquals(LexemeType.Digits, lexes.get(10).getType());
        assertEquals(LexemeType.Comma, lexes.get(11).getType());


// доделать


        assertEquals(LexemeType.CloseBracket, lexes.get(25).getType());

    }

}