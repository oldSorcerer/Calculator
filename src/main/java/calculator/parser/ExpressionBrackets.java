package calculator.parser;

import calculator.dom.Expression;
import calculator.dom.ExpressionVisitor;

class ExpressionBrackets extends Expression {

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
