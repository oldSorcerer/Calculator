package calculator.parser.sequence;

import calculator.dom.expression.Expression;
import calculator.dom.expression.FunctionExpression;
import calculator.dom.FunctionType;
import calculator.lexer.Lex;
import calculator.lexer.LexType;
import calculator.parser.terminal.Terminal;
import calculator.parser.alternative.Alternative;
import calculator.parser.alternative.ParametersAlternative;
import calculator.parser.alternative.RootAlternative;

import java.util.LinkedList;

public class FunctionSequence extends Sequence {

    public FunctionSequence(RootAlternative root) {
        getMembers().add(new Terminal(LexType.NameFunc));
        getMembers().add(new Terminal(LexType.OpenBracket));
        Alternative parameters = new Alternative();
        parameters.getAlternatives().add(new ParametersAlternative(root));
        parameters.getAlternatives().add(new EmptySequence());
        getMembers().add(parameters);
        getMembers().add(new Terminal(LexType.CloseBracket));
    }

    @Override
    protected Object collect(Object[] results) {

        FunctionExpression result = new FunctionExpression();
        for (FunctionType fun : FunctionType.values())
            if (((Lex) results[0]).getText().equals(fun.toString().toLowerCase())) {
                result.setType(fun);
                break;
            }
        if (results[2] instanceof Expression)
            result.getParameters().add((Expression) results[2]);
        else if (results[2].getClass().equals(LinkedList.class))
            result.getParameters().addAll((LinkedList<Expression>) results[2]);

        return result;
    }
}
