package calculator.lexer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LexerTest {
    @Test
    void singleInt(){
        List<Lex> lexes = Lexer.run("38");

        assertEquals(1, lexes.size());
        assertEquals("38", lexes.get(0).getText());
        assertEquals(LexType.Digits, lexes.get(0).getType());
    }

    @Test
    void singleFloat(){
        List<Lex> lexes = Lexer.run("18.3");

        assertEquals(3, lexes.size());
        assertEquals("18", lexes.get(0).getText());
        assertEquals(LexType.Digits, lexes.get(0).getType());
        assertEquals(LexType.Dot, lexes.get(1).getType());
        assertEquals("3", lexes.get(2).getText());
        assertEquals(LexType.Digits, lexes.get(2).getType());
    }

    @Test
    void numberError(){
        List<Lex> lexes = Lexer.run("18.3zz33");

        assertEquals(6, lexes.size());
        assertEquals(LexType.Error, lexes.get(3).getType());
        assertEquals(LexType.Error, lexes.get(4).getType());
        assertEquals("33", lexes.get(5).getText());
        assertEquals(LexType.Digits, lexes.get(5).getType());
    }

    @Test
    void space(){
        List<Lex> lexes = Lexer.run("18  + 4");

        assertEquals(5, lexes.size());
        assertEquals("18", lexes.get(0).getText());
        assertEquals(LexType.Digits, lexes.get(0).getType());
        assertEquals(LexType.Space, lexes.get(1).getType());
        assertEquals(LexType.Operator, lexes.get(2).getType());
        assertEquals(LexType.Space, lexes.get(3).getType());
        assertEquals("4", lexes.get(4).getText());
        assertEquals(LexType.Digits, lexes.get(4).getType());
    }

    @Test
    void bracket (){
        List<Lex> lexes = Lexer.run ("15*@(19.8-3.3)");

        assertEquals(12, lexes.size());
        assertEquals("15", lexes.get(0).getText());
        assertEquals(LexType.Digits, lexes.get(0).getType());
        assertEquals(LexType.Operator, lexes.get(1).getType());
        assertEquals(LexType.Error, lexes.get(2).getType());
        assertEquals(LexType.OpenBracket, lexes.get(3).getType());
        assertEquals("19", lexes.get(4).getText());
        assertEquals(LexType.Digits, lexes.get(4).getType());
        assertEquals(LexType.Dot, lexes.get(5).getType());
        assertEquals("8", lexes.get(6).getText());
        assertEquals(LexType.Digits, lexes.get(6).getType());
        assertEquals(LexType.Operator, lexes.get(7).getType());
        assertEquals("3", lexes.get(8).getText());
        assertEquals(LexType.Digits, lexes.get(8).getType());
        assertEquals(LexType.Dot, lexes.get(9).getType());
        assertEquals("3", lexes.get(10).getText());
        assertEquals(LexType.Digits, lexes.get(10).getType());
        assertEquals(LexType.CloseBracket, lexes.get(11).getType());

    }
    @Test
    void X(){
        List<Lex> lexes = Lexer.run ("x * x");

        assertEquals(5, lexes.size());
        assertEquals(LexType.X, lexes.get(0).getType());
        assertEquals(LexType.Space, lexes.get(1).getType());
        assertEquals(LexType.Operator, lexes.get(2).getType());
        assertEquals(LexType.Space, lexes.get(3).getType());
        assertEquals(LexType.X, lexes.get(4).getType());
    }

    @Test
    void Fun(){
        List<Lex> lexes = Lexer.run("sin(x) + cos(x)");

        assertEquals(11,lexes.size());
        assertEquals(LexType.NameFunc, lexes.get(0).getType());
        assertEquals("sin",lexes.get(0).getText());
        assertEquals(LexType.OpenBracket, lexes.get(1).getType());
        assertEquals(LexType.X, lexes.get(2).getType());
        assertEquals(LexType.CloseBracket, lexes.get(3).getType());
        assertEquals(LexType.Space, lexes.get(4).getType());
        assertEquals(LexType.Operator, lexes.get(5).getType());
        assertEquals(LexType.Space, lexes.get(6).getType());
        assertEquals(LexType.NameFunc, lexes.get(7).getType());
        assertEquals("cos",lexes.get(7).getText());
        assertEquals(LexType.OpenBracket, lexes.get(8).getType());
        assertEquals(LexType.X, lexes.get(9).getType());
        assertEquals(LexType.CloseBracket, lexes.get(10).getType());

    }
}