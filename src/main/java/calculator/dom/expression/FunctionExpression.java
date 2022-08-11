package calculator.dom.expression;

import calculator.dom.expressionvisitor.ExpressionVisitor;
import calculator.dom.FunctionType;

import java.util.ArrayList;
import java.util.List;

public class FunctionExpression extends Expression {
    @Override
    public <O> O accept(ExpressionVisitor<O> visitor) {
        return visitor.visit(this);
    }

    private FunctionType type;

    public FunctionType getType() {
        return type;
    }

    public void setType(FunctionType type) {
        this.type = type;
    }

    private List<Expression> parameters = new ArrayList<>();

    public List<Expression> getParameters() {
        return parameters;
    }
}
