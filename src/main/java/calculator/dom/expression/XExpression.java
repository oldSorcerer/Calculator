package calculator.dom.expression;

import calculator.dom.expression.visitor.ExpressionVisitor;

public class XExpression extends Expression {

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
