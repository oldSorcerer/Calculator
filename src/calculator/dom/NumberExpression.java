package calculator.dom;

public class NumberExpression extends Expression {

    public NumberExpression(Number value) {
        if (value == null)
            throw new IllegalArgumentException("Number cannot be Null!");
        this.value = value;
    }

    @Override
    public <O> O accept(ExpressionVisitor<O> visitor) {
        return visitor.visit(this);
    }
    private Number value;

    public Number getValue() {
        return value;
    }
}
