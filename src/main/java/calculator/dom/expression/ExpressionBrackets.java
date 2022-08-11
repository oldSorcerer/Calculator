package calculator.dom.expression;

import calculator.dom.expression.Expression;
import calculator.dom.expressionvisitor.ExpressionVisitor;

public class ExpressionBrackets extends Expression {

    private Expression expression;

    public Expression getExpression() {
        return expression;
    }

    public ExpressionBrackets (Expression expression){
        if(expression == null)
            throw new IllegalArgumentException("Expression = null");
        this.expression = expression;
    }

    @Override
    public <O> O accept(ExpressionVisitor<O> visitor) {
        return expression.accept(visitor);
    }

}
