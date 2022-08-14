package calculator.dom;

public abstract class Expression {

    public abstract <T> T accept(ExpressionVisitor<T> visitor);

    @Override
    public String toString() {
        return this.accept(new StringExpressionVisitor());
    }
}
