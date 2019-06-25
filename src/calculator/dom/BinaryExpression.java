package calculator.dom;

public class BinaryExpression extends Expression {

    @Override
    public <O> O accept(ExpressionVisitor<O> visitor) {

        return visitor.visit(this);
    }

    private Expression left;
    private Expression right;
    private BinaryOperator operator;

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
