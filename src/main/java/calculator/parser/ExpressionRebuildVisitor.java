package calculator.parser;

import calculator.dom.*;

public class ExpressionRebuildVisitor implements ExpressionVisitor<Expression> {

    @Override
    public Expression visit(BinaryExpression expression) {
        expression.setLeft(expression.getLeft().accept(this));
        expression.setRight(expression.getRight().accept(this));
        return expression;
    }

    @Override
    public Expression visit(NumberExpression expression) {
        return expression;
    }

    @Override
    public Expression visit(XExpression expression) {
        return expression;
    }

    @Override
    public Expression visit(FunctionExpression expression) {
        expression.getParameters().replaceAll(exp -> exp.accept(this));
        return expression;
    }
}
