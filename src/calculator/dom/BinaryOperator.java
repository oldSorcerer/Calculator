package calculator.dom;

public enum BinaryOperator {
    Plus(0, true, '+', (x,y)->x+y ),
    Minus(0, false, '-', (x,y)->x-y),
    Mul(1, true, '*', (x,y)->x*y),
    Div(1, false, '/', (x,y)->x/y);

    private int priority;
    private boolean commutative;
    private char symbol;
    private java.util.function.BinaryOperator<Double> calc;

    BinaryOperator(int priority, boolean commutative, char symbol, java.util.function.BinaryOperator<Double> calc) {
        this.priority = priority;
        this.commutative = commutative;
        this.symbol = symbol;
        this.calc = calc;
    }

    public int getPriority(){
        return priority;
    }

    public boolean getCommutative(){
        return commutative;
    }

    @Override
    public String toString(){
        return Character.toString(this.symbol);
    }

    public static BinaryOperator fromChar(char symbol){
        switch (symbol){
            case '+': return Plus;
            case '-': return Minus;
            case '*': return Mul;
            case '/': return Div;
            default: return null;
        }
    }

    public Double calculate ( Double x, Double y){
        return calc.apply(x,y);
    }
}
