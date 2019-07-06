package calculator.dom;

public class XExpression extends Expression {
    @Override
    public <O> O accept(ExpressionVisitor<O> visitor) {
        return visitor.visit(this);
    }
}
