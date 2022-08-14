package calculator.dom;

public interface ExpressionVisitor<T> {

    T visit(BinaryExpression e);

    T visit(NumberExpression e);

    T visit(XExpression e);

    T visit(FunctionExpression e);

}
