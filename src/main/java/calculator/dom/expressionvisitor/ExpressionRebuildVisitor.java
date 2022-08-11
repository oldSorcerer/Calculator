package calculator.dom.expressionvisitor;

import calculator.dom.expression.*;

public class ExpressionRebuildVisitor implements ExpressionVisitor<Expression> {

    @Override
    public Expression visit(BinaryExpression e) {
        e.setLeft(e.getLeft().accept(this));
        e.setRight(e.getRight().accept(this));
        return e;
    }

    @Override
    public Expression visit(NumberExpression e) {
        return e;
    }

    @Override
    public Expression visit(XExpression e) {
        return e;
    }

    @Override
    public Expression visit(FunctionExpression functionExpression) {
        functionExpression.getParameters().replaceAll(expression -> expression.accept(this));
        return functionExpression;
    }
}
