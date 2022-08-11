package calculator.dom.expression;

import calculator.dom.expressionvisitor.ExpressionVisitor;
import calculator.dom.expressionvisitor.StringExpressionVisitor;

public abstract class Expression {

    public abstract <T> T accept(ExpressionVisitor<T> visitor);

    @Override
    public String toString() {
        return this.accept(new StringExpressionVisitor());
    }
}
