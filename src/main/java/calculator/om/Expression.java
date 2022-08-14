package calculator.om;

import calculator.om.ExpressionVisitor;
import calculator.om.StringExpressionVisitor;

public abstract class Expression {

    public abstract <T> T accept(ExpressionVisitor<T> visitor);

    @Override
    public String toString() {
        return this.accept(new StringExpressionVisitor());
    }
}
