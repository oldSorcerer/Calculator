package calculator.dom.expressionvisitor;

import calculator.dom.expression.BinaryExpression;
import calculator.dom.expression.FunctionExpression;
import calculator.dom.expression.NumberExpression;
import calculator.dom.expression.XExpression;

public class CalculateExpressionVisitor implements ExpressionVisitor<Double> {

    public CalculateExpressionVisitor(double x) {
        this.x = x;
    }

    @Override
    public Double visit(BinaryExpression e) {

        if (e.getLeft() == null || e.getOperator() == null || e.getRight() == null)
            return null;
        return e.getOperator().calculate(e.getLeft().accept(this), e.getRight().accept(this));
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

    @Override
    public Double visit(FunctionExpression e) {
        double x[] = new double[e.getParameters().size()];
        for (int i = 0; i < x.length; i++)
            x[i] = e.getParameters().get(i).accept(this);

        return e.getType().calculate(x);
    }

    public double getX() {
        return x;
    }
}
