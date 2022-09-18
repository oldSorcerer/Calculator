package calculator.parser.sequence;

import calculator.dom.BinaryExpression;
import calculator.dom.BinaryOperator;
import calculator.dom.Expression;
import calculator.lexer.Lexeme;
import calculator.lexer.LexemeType;
import calculator.parser.terminal.Terminal;
import calculator.parser.alternative.RootAlternative;

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
