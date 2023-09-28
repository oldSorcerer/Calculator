package io.sancta.sanctorum.calculator.dom;

public class XExpression extends Expression {

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
