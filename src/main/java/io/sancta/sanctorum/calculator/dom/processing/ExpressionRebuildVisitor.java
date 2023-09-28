package io.sancta.sanctorum.calculator.dom.processing;

import calculator.dom.*;

public class ExpressionRebuildVisitor implements ExpressionVisitor<Expression> {

    @Override
    public Expression visit(BinaryExpression binaryExpression) {
        binaryExpression.setLeft(binaryExpression.getLeft().accept(this));
        binaryExpression.setRight(binaryExpression.getRight().accept(this));
        return binaryExpression;
    }

    @Override
    public Expression visit(BooleanExpression booleanExpression) {
        booleanExpression.setLeft(booleanExpression.getLeft().accept(this));
        booleanExpression.setRight(booleanExpression.getRight().accept(this));
        return booleanExpression;
    }

    @Override
    public Expression visit(NumberExpression numberExpression) {
        return numberExpression;
    }

    @Override
    public Expression visit(XExpression xExpression) {
        return xExpression;
    }

    @Override
    public Expression visit(FunctionExpression function) {
        function.getParameters().replaceAll(expression -> expression.accept(this));
        return function;
    }
}
