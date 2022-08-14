package calculator.dom;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CalculateExpressionVisitor implements ExpressionVisitor<Double> {

    private final double x;

    @Override
    public Double visit(BinaryExpression expression) {
        if (expression.getLeft() == null || expression.getOperator() == null || expression.getRight() == null) {
            return null;
        }
        return expression.getOperator().calculate(expression.getLeft().accept(this), expression.getRight().accept(this));
    }

    @Override
    public Double visit(NumberExpression expression) {
        return expression.getValue().doubleValue();
    }

    @Override
    public Double visit(XExpression expression) {
        return x;
    }

    @Override
    public Double visit(FunctionExpression expression) {
        double[] x = new double[expression.getParameters().size()];
        for (int i = 0; i < x.length; i++) {
            x[i] = expression.getParameters().get(i).accept(this);
        }
        return expression.getType().calculate(x);
    }
}
