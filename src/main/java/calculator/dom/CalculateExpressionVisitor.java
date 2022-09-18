package calculator.dom;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CalculateExpressionVisitor implements ExpressionVisitor<Double> {

    private double x;

    @Override
    public Double visit(BinaryExpression binary) {
        if (binary.getLeft() == null || binary.getOperator() == null || binary.getRight() == null)
            return null;
        return binary.getOperator().calculate(binary.getLeft().accept(this), binary.getRight().accept(this));
    }

    @Override
    public Double visit(NumberExpression number) {
        return number.getValue().doubleValue();
    }

    @Override
    public Double visit(XExpression xExpression) {
        return x;
    }

    @Override
    public Double visit(FunctionExpression function) {
        double[] x = new double[function.getParameters().size()];
        for (int i = 0; i < x.length; i++)
            x[i] = function.getParameters().get(i).accept(this);

        return function.getType().calculate(x);
    }
}
