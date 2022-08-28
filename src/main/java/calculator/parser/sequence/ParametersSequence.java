package calculator.parser.sequence;

import calculator.dom.Expression;
import calculator.lexer.LexemeType;
import calculator.parser.terminal.Terminal;
import calculator.parser.alternative.ParametersAlternative;
import calculator.parser.alternative.RootAlternative;

import java.util.LinkedList;

public class ParametersSequence extends Sequence {

    public ParametersSequence(RootAlternative root, ParametersAlternative tail) {
        getMembers().add(root);
        getMembers().add(new Terminal(LexemeType.Comma));
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
