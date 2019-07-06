package calculator.dom;

public class CalculateExpressionVisitor implements ExpressionVisitor <Double>{

    public CalculateExpressionVisitor(double x) {
        this.x = x;
    }

    @Override
    public Double visit(BinaryExpression e) {

        if (e.getLeft() == null || e.getOperator() == null || e.getRight() == null)
            return null;
        return e.getOperator().calculate( e.getLeft().accept(this), e.getRight().accept(this) ) ;
    }

    @Override
    public Double visit(NumberExpression e) {
        return e.getValue().doubleValue();
    }

    private double x;

    @Override
    public Double visit(XExpression e) {
        return x;
    }

    public double getX() {
        return x;
    }
}
