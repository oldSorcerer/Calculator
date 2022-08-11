package calculator.sequence;

import calculator.expression.Expression;
import calculator.lexer.LexType;
import calculator.terminal.Terminal;
import calculator.alternative.ParametersAlternative;
import calculator.alternative.RootAlternative;

import java.util.LinkedList;

public class ParametersSequence extends Sequence {

    public ParametersSequence(RootAlternative root, ParametersAlternative tail) {
        getMembers().add(root);
        getMembers().add(new Terminal(LexType.Comma));
        getMembers().add(tail);
    }

    @Override
    protected Object collect(Object[] results) {

        LinkedList<Expression> result = new LinkedList<>();

        result.add((Expression) results[0]);
        if (results[2] instanceof Expression)
            result.add((Expression) results[2]);
        else if (results[2].getClass().equals(LinkedList.class))
            result.addAll((LinkedList<Expression>) results[2]);
        return result;
    }
}
