package calculator.dom;

public class StringExpressionVisitor implements ExpressionVisitor <String> {
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
}
