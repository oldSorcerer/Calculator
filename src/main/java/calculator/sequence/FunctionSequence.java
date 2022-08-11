package calculator.sequence;

import calculator.expression.Expression;
import calculator.expression.FunctionExpression;
import calculator.om.FunctionType;
import calculator.lexer.Lex;
import calculator.lexer.LexType;
import calculator.terminal.Terminal;
import calculator.alternative.Alternative;
import calculator.alternative.ParametersAlternative;
import calculator.alternative.RootAlternative;

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
