package calculator.dom.expression;

import calculator.dom.expressionvisitor.ExpressionVisitor;

public class XExpression extends Expression {

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
