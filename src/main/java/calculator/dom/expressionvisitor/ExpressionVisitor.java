package calculator.dom.expressionvisitor;

import calculator.dom.expression.BinaryExpression;
import calculator.dom.expression.FunctionExpression;
import calculator.dom.expression.NumberExpression;
import calculator.dom.expression.XExpression;

public interface ExpressionVisitor<O> {

    O visit(BinaryExpression e);
    O visit(NumberExpression e);
    O visit(XExpression e);
    O visit(FunctionExpression e);

}
