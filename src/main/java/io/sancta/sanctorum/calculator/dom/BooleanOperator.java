package io.sancta.sanctorum.calculator.dom;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.function.BiPredicate;

@AllArgsConstructor
public enum BooleanOperator {

    Greater     (false, '>', (x, y) -> x > y),
    Less        (false, '<', (x, y) -> x < y),
    MoreEquals  (false, '≥', (x, y) -> x >= y),
    LessEquals  (false, '≤', (x, y) -> x <= y),
    Equals      (true,  '=', Objects::equals),
    NotEquals   (true,  '≠', (x, y) -> !Objects.equals(x, y));

    @Getter
    private final boolean commutative;
    private final char symbol;
    private final BiPredicate<Double, Double> calc;

    public static BooleanOperator fromChar(char symbol) {
        return switch (symbol) {
            case '>' -> Greater;
            case '<' -> Less;
            case '≥' -> MoreEquals;
            case '≤' -> LessEquals;
            case '=' -> Equals;
            case '≠' -> NotEquals;
            default -> null;
        };
    }

    public boolean calculate(Double x, Double y) {
        return calc.test(x, y);
    }

    @Override
    public String toString() {
        return Character.toString(this.symbol);
    }
}