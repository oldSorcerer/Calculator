package calculator.parser;

import calculator.dom.Expression;
import calculator.dom.ExpressionVisitor;

public class ExpressionBrackets extends Expression {

    private final Expression expression;

    public Expression getExpression() {
        return expression;
    }

    public ExpressionBrackets (Expression expression){
        if(expression == null)
            throw new IllegalArgumentException("Expression = null");
        this.expression = expression;
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return expression.accept(visitor);
    }

}
