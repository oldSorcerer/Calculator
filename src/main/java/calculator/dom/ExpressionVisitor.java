package calculator.dom;

public interface ExpressionVisitor<O> {

    O visit(BinaryExpression e);
    O visit(NumberExpression e);
    O visit(XExpression e);
    O visit(FunctionExpression e);

}
