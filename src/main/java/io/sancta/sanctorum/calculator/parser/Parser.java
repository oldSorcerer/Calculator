package io.sancta.sanctorum.calculator.parser;

import io.sancta.sanctorum.calculator.dom.Expression;
import io.sancta.sanctorum.calculator.dom.processing.ExpressionRebuildVisitor;
import io.sancta.sanctorum.calculator.parser.alternative.Alternative;
import io.sancta.sanctorum.calculator.parser.alternative.RootAlternative;
import io.sancta.sanctorum.calculator.lexer.Lexeme;
import io.sancta.sanctorum.calculator.lexer.LexemeType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Parser {

    @Getter
    @Setter
    private int recognized; // колличество распознаных лексем!

    @Getter
    private final List<Lexeme> lexemes;

    public Parser(List<Lexeme> lexemes) throws ParserException {
        if (lexemes == null) throw new IllegalArgumentException("Lexes cannot be Null!");

        this.lexemes = new ArrayList<>();
        LinkedList<Integer> position = new LinkedList<>();

        for (Lexeme lex : lexemes) {
            if (lex.getType().equals(LexemeType.Error))  position.add(lex.getPosition());
            if (!lex.getType().equals(LexemeType.Space)) this.lexemes.add(lex);
        }
        if (!position.isEmpty()) {
            int[] pos2 = new int[position.size()];
            int i = 0;
            for (Integer x : position)
                pos2[i++] = x;
            throw new ParserException("Invalid character in expression!", pos2);
        }
    }

    public Expression parse() throws ParserException {
        Alternative root = new RootAlternative(false);
        Expression result = (Expression) root.apply(this);

        if (result == null) {
            throw new ParserException("Failed to parse", new int[0]);
        }

        if (recognized < lexemes.size()) {
            throw new ParserException("Failed to parse whole",
                    new int[]{lexemes.get(recognized).getPosition()});
        }

        return result.accept(new ExpressionRebuildVisitor());
    }
}
