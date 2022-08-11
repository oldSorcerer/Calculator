package calculator.dom.expression;

import calculator.dom.expressionvisitor.ExpressionVisitor;
import calculator.dom.expressionvisitor.StringExpressionVisitor;

public abstract class Expression {

    public abstract <O> O accept(ExpressionVisitor<O> visitor);

    @Override
    public String toString(){
        return this.accept(new StringExpressionVisitor());
    }
}
