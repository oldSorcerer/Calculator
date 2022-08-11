package calculator.dom.expressionvisitor;

import calculator.dom.expression.*;
import calculator.dom.expressionvisitor.ExpressionVisitor;

import java.util.ArrayList;

public class StringExpressionVisitor implements ExpressionVisitor<String> {
    @Override
    public String visit(BinaryExpression e) {

        if (e.getLeft() == null || e.getOperator() == null || e.getRight() == null)
            return "";

        BinaryExpression left = null;
        BinaryExpression right = null;

        if (e.getLeft().getClass().equals(BinaryExpression.class)){
            left = (BinaryExpression)e.getLeft();
        }

        if (e.getRight().getClass().equals(BinaryExpression.class)){
            right = (BinaryExpression)e.getRight();
        }

        String leftstr = e.getLeft().accept(this);
        String rightstr = e.getRight().accept(this);

        if (left != null && left.getOperator() != null
            && left.getOperator().getPriority() < e.getOperator().getPriority())
            leftstr = "(" + leftstr + ")";

        if (right != null  && right.getOperator() != null
            && (right.getOperator().getPriority() < e.getOperator().getPriority()
            || (right.getOperator().getPriority() == e.getOperator().getPriority()
            && !e.getOperator().getCommutative())))
            rightstr = "(" + rightstr + ")";

        return (leftstr + " " + e.getOperator() + " " + rightstr);
    }

    @Override
    public String visit(NumberExpression e) {

        return e.getValue().toString();
    }

    @Override
    public String visit(XExpression e) {
        return "x";
    }

    @Override
    public String visit(FunctionExpression e) {

        ArrayList<String> parameters = new ArrayList<>(e.getParameters().size());

        for (Expression p: e.getParameters())
            parameters.add(p.accept(this));
        return e.getType().toString().toLowerCase() + "(" + String.join(", ", parameters) + ")" ;

    }
}
