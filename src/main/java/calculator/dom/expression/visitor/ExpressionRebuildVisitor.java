package calculator.dom.expression.visitor;

import calculator.dom.expression.*;

public class ExpressionRebuildVisitor implements ExpressionVisitor<Expression> {

    @Override
    public Expression visit(BinaryExpression binaryExpression) {
        binaryExpression.setLeft(binaryExpression.getLeft().accept(this));
        binaryExpression.setRight(binaryExpression.getRight().accept(this));
        return binaryExpression;
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
    public Expression visit(FunctionExpression functionExpression) {
        functionExpression.getParameters().replaceAll(expression -> expression.accept(this));
        return functionExpression;
    }
}
