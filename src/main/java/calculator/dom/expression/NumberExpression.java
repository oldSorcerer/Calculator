package calculator.dom.expression;

import calculator.dom.expressionvisitor.ExpressionVisitor;
import lombok.Getter;

@Getter
public class NumberExpression extends Expression {

    private final Number value;

    public NumberExpression(Number value) {
        if (value == null)
            throw new IllegalArgumentException("Number cannot be Null!");
        this.value = value;
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
