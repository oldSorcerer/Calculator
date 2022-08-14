package calculator.parser;

import calculator.dom.Expression;
import calculator.lexer.*;
import calculator.parser.alternative.Alternative;
import calculator.parser.alternative.RootAlternative;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class Parser {

    @Getter
    @Setter
    public int recognized; // колличество распознаных лексем! !!!почему паблик поле!

    private final List<Lex> lexes;

    public Parser(List<Lex> lexes) throws ParserException {
        if (lexes == null)
            throw new IllegalArgumentException("Lexes cannot be Null!");

        this.lexes = new ArrayList<>();
        LinkedList<Integer> position = new LinkedList<>();

        for (Lex lex : lexes) {
            if (lex.getType() == LexType.Error)
                position.add(lex.getPosition());
            if (lex.getType() != LexType.Space)
                this.lexes.add(lex);
        }
        if (!position.isEmpty()) {
            int[] pos2 = new int[position.size()];
            int i = 0;
            for (Integer x : position)
                pos2[i++] = x;
            throw new ParserException("Неверный символ в выражении!", pos2); // перевести
        }
    }

    public int size() {
        return lexes.size();
    }

    public Lex get(int number) {
        return lexes.get(number);
    }

    public Expression parse() throws ParserException {
        Alternative root = new RootAlternative(false);
        Expression result = (Expression) root.apply(this);

        if (result == null) {
            throw new ParserException("Failed to parse", new int[0]);
        }

        if (recognized < size()) {
            throw new ParserException("Failed to parse whole",
                    new int[]{lexes.get(recognized).getPosition()});
        }

        return result.accept(new ExpressionRebuildVisitor());
    }
}
