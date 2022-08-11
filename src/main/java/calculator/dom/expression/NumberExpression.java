package calculator.dom.expression;

import calculator.dom.expressionvisitor.ExpressionVisitor;

public class NumberExpression extends Expression {

    private Number value;

    public NumberExpression(Number value) {
        if (value == null)
            throw new IllegalArgumentException("Number cannot be Null!");
        this.value = value;
    }

    @Override
    public <O> O accept(ExpressionVisitor<O> visitor) {
        return visitor.visit(this);
    }

    public Number getValue() {
        return value;
    }
}
