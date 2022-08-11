package calculator.expression.visitor;

import calculator.om.expression.*;
import calculator.expression.BinaryExpression;
import calculator.expression.FunctionExpression;
import calculator.expression.NumberExpression;
import calculator.expression.XExpression;

public interface ExpressionVisitor<T> {

    T visit(BinaryExpression binaryExpression);

    T visit(NumberExpression numberExpression);

    T visit(XExpression xExpression);

    T visit(FunctionExpression functionExpression);
}
