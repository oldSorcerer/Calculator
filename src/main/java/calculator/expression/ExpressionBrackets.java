package calculator.expression;

import calculator.expression.visitor.ExpressionVisitor;
import lombok.Getter;

@Getter
public class ExpressionBrackets extends Expression {

    private final Expression expression;

    public ExpressionBrackets(Expression expression) {
        if (expression == null)
            throw new IllegalArgumentException("Expression = null");
        this.expression = expression;
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return expression.accept(visitor);
    }
}
