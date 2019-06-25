package calculator.dom;

public abstract class Expression {

    public abstract <O> O accept(ExpressionVisitor<O> visitor);

    @Override
    public String toString(){
        return this.accept(new StringExpressionVisitor());
    }

}
