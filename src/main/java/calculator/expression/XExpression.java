package calculator.expression;

import calculator.expression.visitor.ExpressionVisitor;

public class XExpression extends Expression {

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
