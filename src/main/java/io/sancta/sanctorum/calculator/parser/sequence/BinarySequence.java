package io.sancta.sanctorum.calculator.parser.sequence;

import io.sancta.sanctorum.calculator.dom.BinaryExpression;
import io.sancta.sanctorum.calculator.dom.BinaryOperator;
import io.sancta.sanctorum.calculator.dom.Expression;
import io.sancta.sanctorum.calculator.parser.alternative.RootAlternative;
import io.sancta.sanctorum.calculator.parser.terminal.Terminal;
import io.sancta.sanctorum.calculator.lexer.Lexeme;
import io.sancta.sanctorum.calculator.lexer.LexemeType;

public class BinarySequence extends Sequence {

    public BinarySequence(RootAlternative root) { // {a} + {{b} + {c}}
        getMembers().add(new RootAlternative(true, root));
        getMembers().add(new Terminal(LexemeType.Operator));
        getMembers().add(root);
    }

    @Override
    protected Object collect(Object[] results) {
        BinaryExpression result = new BinaryExpression();
        result.setLeft((Expression) results[0]);
        result.setOperator(BinaryOperator.fromChar(((Lexeme) results[1]).getText().charAt(0)));
        result.setRight((Expression) results[2]);

        if (result.getRight().getClass().equals(BinaryExpression.class)) {
            BinaryExpression rightBinary = (BinaryExpression) result.getRight();

            if (result.getOperator().getPriority() > rightBinary.getOperator().getPriority() // a * b + c
                    || (result.getOperator().getPriority() == rightBinary.getOperator().getPriority() // a - b + c
                    && !result.getOperator().isCommutative())) {
                BinaryExpression left = new BinaryExpression();
                left.setLeft(result.getLeft());
                left.setOperator(result.getOperator());
                left.setRight(rightBinary.getLeft());
                result.setOperator(rightBinary.getOperator());
                result.setLeft(left);
                result.setRight(rightBinary.getRight());
            }
        }
        return result;
    }
}
