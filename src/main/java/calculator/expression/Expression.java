package calculator.expression;

import calculator.expression.visitor.ExpressionVisitor;
import calculator.expression.visitor.StringExpressionVisitor;

public abstract class Expression {

    public abstract <T> T accept(ExpressionVisitor<T> visitor);

    @Override
    public String toString() {
        return this.accept(new StringExpressionVisitor());
    }
}
