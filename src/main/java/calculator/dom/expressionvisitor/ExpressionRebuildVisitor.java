package calculator.dom.expressionvisitor;

import calculator.dom.expression.*;
import calculator.dom.expressionvisitor.ExpressionVisitor;

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
    public Expression visit(FunctionExpression e) {
        for (int i = 0; i < e.getParameters().size(); i++ )
            e.getParameters().set(i, e.getParameters().get(i).accept(this));
        return e;
    }
}
