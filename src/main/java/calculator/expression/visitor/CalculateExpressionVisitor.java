package calculator.expression.visitor;

import calculator.om.expression.*;
import calculator.expression.BinaryExpression;
import calculator.expression.FunctionExpression;
import calculator.expression.NumberExpression;
import calculator.expression.XExpression;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CalculateExpressionVisitor implements ExpressionVisitor<Double> {

    private double x;

    @Override
    public Double visit(BinaryExpression binaryExpression) {
        if (binaryExpression.getLeft() == null || binaryExpression.getOperator() == null || binaryExpression.getRight() == null)
            return null;
        return binaryExpression.getOperator().calculate(binaryExpression.getLeft().accept(this), binaryExpression.getRight().accept(this));
    }

    @Override
    public Double visit(NumberExpression numberExpression) {
        return numberExpression.getValue().doubleValue();
    }

    @Override
    public Double visit(XExpression xExpression) {
        return x;
    }

    @Override
    public Double visit(FunctionExpression functionExpression) {
        double[] x = new double[functionExpression.getParameters().size()];
        for (int i = 0; i < x.length; i++)
            x[i] = functionExpression.getParameters().get(i).accept(this);

        return functionExpression.getType().calculate(x);
    }
}
