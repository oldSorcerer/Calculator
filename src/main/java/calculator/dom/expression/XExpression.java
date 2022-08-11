package calculator.dom.expression;

import calculator.dom.expressionvisitor.ExpressionVisitor;

public class XExpression extends Expression {
    @Override
    public <O> O accept(ExpressionVisitor<O> visitor) {
        return visitor.visit(this);
    }
}
