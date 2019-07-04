package calculator.parser;

import calculator.dom.Expression;
import calculator.lexer.Lex;
import calculator.lexer.LexType;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private List<Lex> lexes;

    public Parser (List<Lex> lexes){
        if (lexes == null)
            throw new IllegalArgumentException("Lexes cannot be Null!");

        this.lexes = new ArrayList<>();

        for (Lex lex : lexes){
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

        return  (Expression)root.apply(this);
    }
}
