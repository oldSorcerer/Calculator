package io.sancta.sanctorum.calculator.dom;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinaryExpression extends Expression {

    private Expression left;
    private Expression right;
    private BinaryOperator operator;

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean isEmpty() {
        return left == null || right == null || operator == null;
    }
}