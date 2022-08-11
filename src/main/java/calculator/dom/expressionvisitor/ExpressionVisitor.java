package calculator.dom.expressionvisitor;

import calculator.dom.expression.BinaryExpression;
import calculator.dom.expression.FunctionExpression;
import calculator.dom.expression.NumberExpression;
import calculator.dom.expression.XExpression;

public interface ExpressionVisitor<T> {

    T visit(BinaryExpression e);

    T visit(NumberExpression e);

    T visit(XExpression e);

    T visit(FunctionExpression e);

}
