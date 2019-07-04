package calculator.parser;

import calculator.dom.Expression;
import calculator.lexer.*;

import java.util.*;

public class Parser {

    private List<Lex> lexes;

    public Parser (List<Lex> lexes) throws ParserException{
        if (lexes == null)
            throw new IllegalArgumentException("Lexes cannot be Null!");

        this.lexes = new ArrayList<>();
        LinkedList<Integer> position = new LinkedList<>();

        for (Lex lex : lexes){
            if (lex.getType() == LexType.Error)
                position.add(lex.getPosition());
                //throw new ParserException(String.format("Неверный символ в выражении %s!", lex.getText()), lex.getPosition());
            if (lex.getType() != LexType.Space)
                this.lexes.add(lex);
        }

    }

    public int recognized; // колличество распознаных лексем!

    public int size (){
        return lexes.size();
    }

    public Lex get(int number){
        return lexes.get(number);
    }

    public Expression parse (){
        Alternative root = new RootAlternative(false);

        return  ((Expression)root.apply(this)).accept(new ExpressionRebuildVisitor());
    }
}
