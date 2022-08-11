package calculator.dom.expression.visitor;

import calculator.dom.expression.*;

import java.util.ArrayList;

public class StringExpressionVisitor implements ExpressionVisitor<String> {
    @Override
    public String visit(BinaryExpression binaryExpression) {

        if (binaryExpression.getLeft() == null || binaryExpression.getOperator() == null || binaryExpression.getRight() == null)
            return "";

        BinaryExpression left = null;
        BinaryExpression right = null;

        if (binaryExpression.getLeft().getClass().equals(BinaryExpression.class)) {
            left = (BinaryExpression) binaryExpression.getLeft();
        }

        if (binaryExpression.getRight().getClass().equals(BinaryExpression.class)) {
            right = (BinaryExpression) binaryExpression.getRight();
        }

        String leftstr = binaryExpression.getLeft().accept(this);
        String rightstr = binaryExpression.getRight().accept(this);

        if (left != null && left.getOperator() != null
                && left.getOperator().getPriority() < binaryExpression.getOperator().getPriority())
            leftstr = "(" + leftstr + ")";

        if (right != null && right.getOperator() != null
                && (right.getOperator().getPriority() < binaryExpression.getOperator().getPriority()
                || (right.getOperator().getPriority() == binaryExpression.getOperator().getPriority()
                && !binaryExpression.getOperator().isCommutative())))
            rightstr = "(" + rightstr + ")";

        return (leftstr + " " + binaryExpression.getOperator() + " " + rightstr);
    }

    @Override
    public String visit(NumberExpression numberExpression) {
        return numberExpression.getValue().toString();
    }

    @Override
    public String visit(XExpression xExpression) {
        return "x";
    }

    @Override
    public String visit(FunctionExpression functionExpression) {
        ArrayList<String> parameters = new ArrayList<>(functionExpression.getParameters().size());

        for (Expression p : functionExpression.getParameters())
            parameters.add(p.accept(this));
        return functionExpression.getType().toString().toLowerCase() + "(" + String.join(", ", parameters) + ")";
    }
}
