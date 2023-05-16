package calculator.dom;

public interface ExpressionVisitor<T> {

    T visit(BinaryExpression binaryExpression);

    T visit(BooleanExpression booleanExpression);

    T visit(NumberExpression numberExpression);

    T visit(XExpression xExpression);

    T visit(FunctionExpression functionExpression);

}
