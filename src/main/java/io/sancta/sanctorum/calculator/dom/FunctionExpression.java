package io.sancta.sanctorum.calculator.dom;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FunctionExpression extends Expression {

    @Setter
    private FunctionType type;
    private final List<Expression> parameters = new ArrayList<>();

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
