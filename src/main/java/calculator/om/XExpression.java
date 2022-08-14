package calculator.om;

import calculator.om.Expression;
import calculator.om.ExpressionVisitor;

public class XExpression extends Expression {

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
