package calculator.parser.sequence;

import calculator.dom.Expression;
import calculator.dom.FunctionExpression;
import calculator.dom.FunctionType;
import calculator.lexer.Lexeme;
import calculator.lexer.LexemeType;
import calculator.parser.terminal.Terminal;
import calculator.parser.alternative.Alternative;
import calculator.parser.alternative.ParametersAlternative;
import calculator.parser.alternative.RootAlternative;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FunctionSequence extends Sequence {

    public FunctionSequence(RootAlternative root) {
        getMembers().add(new Terminal(LexemeType.NameFunc));
        getMembers().add(new Terminal(LexemeType.OpenBracket));
        Alternative parameters = new Alternative();
        parameters.getAlternatives().add(new ParametersAlternative(root));
        parameters.getAlternatives().add(new EmptySequence());
        getMembers().add(parameters);
        getMembers().add(new Terminal(LexemeType.CloseBracket));
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