package calculator.parser;

import calculator.dom.Expression;
import calculator.lexer.Lex;

import java.util.List;

public class Parser {

    private List<Lex> lexes;

    public Parser (List<Lex> lexes){
        if (lexes == null)
            throw new IllegalArgumentException("Lexes cannot be Null!");
        this.lexes = lexes;
    }

    public int recognized; // колличество распознаных лексем

    public int size (){
        return lexes.size();
    }

    public Lex get(int number){
        return lexes.get(number);
    }

    public Expression parse (){
        Alternative root = new Alternative();
        root.getAlternatives().add(new DoubleSequence());
        root.getAlternatives().add(new IntegerTerminal());

        return  (Expression)root.apply(this);
    }
}
