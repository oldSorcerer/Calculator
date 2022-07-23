package calculator.parser;

import calculator.dom.BinaryExpression;
import calculator.dom.BinaryOperator;
import calculator.dom.Expression;
import calculator.lexer.Lex;
import calculator.lexer.LexType;

public class BinarySequence extends Sequence {

    public BinarySequence (RootAlternative root){
        getMembers().add(new RootAlternative(true, root));
        getMembers().add(new Terminal(LexType.Operator));
        getMembers().add(root);
    }

    @Override
    protected Object collect(Object[] results) {
        BinaryExpression result = new BinaryExpression();
        result.setLeft((Expression) results[0]);
        result.setOperator(BinaryOperator.fromChar(((Lex)results[1]).getText().charAt(0)));
        result.setRight((Expression) results[2]);
        if (result.getRight().getClass().equals(BinaryExpression.class)){
            BinaryExpression right_binary = (BinaryExpression)result.getRight();

            if (result.getOperator().getPriority() > right_binary.getOperator().getPriority()
            || (result.getOperator().getPriority() == right_binary.getOperator().getPriority()
                    && !result.getOperator().getCommutative())) {
                BinaryExpression left = new BinaryExpression();
                left.setLeft(result.getLeft());
                left.setOperator(result.getOperator());
                left.setRight(right_binary.getLeft());
                result.setOperator(right_binary.getOperator());
                result.setLeft(left);
                result.setRight(right_binary.getRight());
            }
        }

        return result;
    }
}
