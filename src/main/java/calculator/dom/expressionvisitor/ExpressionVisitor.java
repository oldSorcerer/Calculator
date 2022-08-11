package calculator.dom.expressionvisitor;

import calculator.dom.expression.*;

public interface ExpressionVisitor<T> {

    T visit(BinaryExpression binaryExpression);

    T visit(NumberExpression numberExpression);

    T visit(XExpression xExpression);

    T visit(FunctionExpression functionExpression);
}
