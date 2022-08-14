package calculator.om;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinaryExpression extends Expression {

    private Expression left;
    private Expression right;
    private BinaryOperator operator;

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
