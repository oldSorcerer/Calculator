package calculator.dom;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum BinaryOperator {

    Plus(0, true, '+', Double::sum),
    Minus(0, false, '-', (x,y)->x-y),
    Mul(1, true, '*', (x,y)->x*y),
    Div(1, false, '/', (x,y)->x/y);

    @Getter
    private final int priority;
    @Getter
    private final boolean commutative;
    private final char symbol;
    private final java.util.function.BinaryOperator<Double> calc;

    public static BinaryOperator fromChar(char symbol){
        return switch (symbol) {
            case '+' -> Plus;
            case '-' -> Minus;
            case '*' -> Mul;
            case '/' -> Div;
            default -> null;
        };
    }

    public Double calculate ( Double x, Double y){
        return calc.apply(x,y);
    }

    @Override
    public String toString(){
        return Character.toString(this.symbol);
    }
}
