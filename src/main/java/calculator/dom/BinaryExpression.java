package calculator.dom;

public class BinaryExpression extends Expression {

    private Expression left;
    private Expression right;
    private BinaryOperator operator;

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public BinaryOperator getOperator() {
        return operator;
    }

    public void setOperator(BinaryOperator operator) {
        this.operator = operator;
    }

    public Expression getLeft() {
        return left;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }


}
