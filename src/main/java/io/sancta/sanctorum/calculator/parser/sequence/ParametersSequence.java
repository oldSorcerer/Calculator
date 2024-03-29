package io.sancta.sanctorum.calculator.parser.sequence;

import io.sancta.sanctorum.calculator.dom.Expression;
import io.sancta.sanctorum.calculator.parser.alternative.Alternative;
import io.sancta.sanctorum.calculator.parser.alternative.ParametersAlternative;
import io.sancta.sanctorum.calculator.parser.alternative.RootAlternative;
import io.sancta.sanctorum.calculator.parser.terminal.Terminal;
import io.sancta.sanctorum.calculator.lexer.LexemeType;

import java.util.ArrayList;
import java.util.List;

public class ParametersSequence extends Sequence {

    public ParametersSequence(RootAlternative root, ParametersAlternative tail) {
        Alternative parameters = new Alternative();
        parameters.getAlternatives().add(new BooleanSequence(root)); // if(a > b)
        parameters.getAlternatives().add(root);
        getMembers().add(parameters);
        getMembers().add(new Terminal(LexemeType.Comma));
        getMembers().add(tail);
    }

    @Override
    protected Object collect(Object[] results) {
//
//        LinkedList<Expression> result = new LinkedList<>(); // из за хвоста
//        result.add((Expression) results[0]);
//
//        if (results[2] instanceof Expression expression)
//            result.add(expression);
//        else if (results[2].getClass().equals(LinkedList.class))
//            result.addAll((LinkedList<Expression>) results[2]);
//        return result;

        if (results[2] instanceof Expression expression) {

            List<Expression> list = new ArrayList<>();
            list.add((Expression) results[0]);
            list.add(expression);
            return list;
//            return new ArrayList<>(Arrays.asList((Expression) results[0], expression));

//            return Arrays.asList((Expression) results[0], expression);
        } else if (results[2].getClass().equals(ArrayList.class)) {
            List<Expression> list = (List<Expression>) results[2];
            list.add(0, (Expression) results[0]);
            return list;
        }
        return null;
    }
}
