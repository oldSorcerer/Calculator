package calculator.dom.expression;

import calculator.dom.expression.visitor.ExpressionVisitor;
import calculator.dom.expression.visitor.StringExpressionVisitor;

public abstract class Expression {

    public abstract <T> T accept(ExpressionVisitor<T> visitor);

    @Override
    public String toString() {
        return this.accept(new StringExpressionVisitor());
    }
}
