package io.sancta.sanctorum.calculator.parser.sequence;

import io.sancta.sanctorum.calculator.dom.Expression;
import io.sancta.sanctorum.calculator.dom.FunctionExpression;
import io.sancta.sanctorum.calculator.dom.FunctionType;
import io.sancta.sanctorum.calculator.parser.alternative.Alternative;
import io.sancta.sanctorum.calculator.parser.alternative.ParametersAlternative;
import io.sancta.sanctorum.calculator.parser.alternative.RootAlternative;
import io.sancta.sanctorum.calculator.lexer.Lexeme;
import io.sancta.sanctorum.calculator.lexer.LexemeType;
import io.sancta.sanctorum.calculator.parser.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;

public class FunctionSequence extends Sequence {

    public FunctionSequence(RootAlternative root) {
        getMembers().add(new Terminal(LexemeType.NameFunc)); //0
        getMembers().add(new Terminal(LexemeType.OpenBracket)); // 1 (
        Alternative parameters = new Alternative();
        parameters.getAlternatives().add(new ParametersAlternative(root)); // name(a, b, c)
        parameters.getAlternatives().add(new EmptySequence()); // name()
        getMembers().add(parameters); //2
        getMembers().add(new Terminal(LexemeType.CloseBracket)); //3 )
    }

    @Override
    protected Object collect(Object[] results) {
        FunctionExpression result = new FunctionExpression();

        for (FunctionType fun : FunctionType.values()) {
            if (((Lexeme) results[0]).getText().equals(fun.toString().toLowerCase())) {
                result.setType(fun);
                break;
            }
        }

        if (results[2] instanceof Expression expression)
            result.getParameters().add(expression);
        else if (results[2].getClass().equals(ArrayList.class))
            result.getParameters().addAll((List<Expression>) results[2]);

        return result;
    }
}
