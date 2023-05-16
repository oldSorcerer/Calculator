package calculator.dom.processing;

import calculator.dom.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CalculateExpressionVisitor implements ExpressionVisitor<Double> {

    private double x;

    @Override
    public Double visit(BinaryExpression binary) {
        if (binary.isEmpty())
            return null;
        return binary.getOperator().calculate(binary.getLeft().accept(this), binary.getRight().accept(this));
    }

    @Override
    public Double visit(BooleanExpression booleanExpression) {
        if (booleanExpression.isEmpty())
            return null;
        return booleanExpression
                .getOperator()
                .calculate(booleanExpression.getLeft().accept(this), booleanExpression.getRight().accept(this)) ? 1.0 : 0;

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
