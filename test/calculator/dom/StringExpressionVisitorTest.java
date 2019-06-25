package calculator.dom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringExpressionVisitorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void integer() {
        NumberExpression ne = new NumberExpression(5);
        assertEquals("5", ne.toString(), "Expression String");
    }

    @Test
    void intPlusInt(){
        BinaryExpression e = new BinaryExpression();
        e.setLeft(new NumberExpression(2));
        e.setOperator(BinaryOperator.Mul);
        e.setRight(new NumberExpression(3));

        assertEquals("2 * 3", e.toString());
    }

    @Test
    void emptyBinary(){
        BinaryExpression e = new BinaryExpression();
        assertEquals("", e.toString());
    }

    @Test
    void minusMul(){
        BinaryExpression e = new BinaryExpression();
        BinaryExpression left = new BinaryExpression();
        e.setLeft(left);
        left.setLeft(new NumberExpression(5));
        left.setOperator(BinaryOperator.Minus);
        left.setRight(new NumberExpression(3));
        e.setOperator(BinaryOperator.Mul);
        e.setRight(new NumberExpression(10));

        assertEquals("(5 - 3) * 10", e.toString());
    }

    @Test
    void mulMinus (){
        BinaryExpression e = new BinaryExpression();
        BinaryExpression left = new BinaryExpression();
        e.setLeft(left);
        left.setLeft(new NumberExpression(5));
        left.setOperator(BinaryOperator.Mul);
        left.setRight(new NumberExpression(3));
        e.setOperator(BinaryOperator.Minus);
        e.setRight(new NumberExpression(10));

        assertEquals("5 * 3 - 10", e.toString());

    }

    @Test
    void commutativeMinusMul (){
        BinaryExpression e = new BinaryExpression();
        BinaryExpression right = new BinaryExpression();
        e.setRight(right);
        right.setLeft(new NumberExpression(5));
        right.setOperator(BinaryOperator.Mul);
        right.setRight(new NumberExpression(3));
        e.setOperator(BinaryOperator.Minus);
        e.setLeft(new NumberExpression(10));
        assertEquals("10 - 5 * 3", e.toString());
    }

    @Test
    void commutativeDivMul (){
        BinaryExpression e = new BinaryExpression();
        BinaryExpression right = new BinaryExpression();
        e.setRight(right);
        right.setLeft(new NumberExpression(5));
        right.setOperator(BinaryOperator.Mul);
        right.setRight(new NumberExpression(3));
        e.setOperator(BinaryOperator.Div);
        e.setLeft(new NumberExpression(10));
        assertEquals("10 / (5 * 3)", e.toString());
    }

    @Test
    void commutativeMinusPlus (){
        BinaryExpression e = new BinaryExpression();
        BinaryExpression right = new BinaryExpression();
        e.setRight(right);
        right.setLeft(new NumberExpression(5));
        right.setOperator(BinaryOperator.Plus);
        right.setRight(new NumberExpression(3));
        e.setOperator(BinaryOperator.Minus);
        e.setLeft(new NumberExpression(10));
        assertEquals("10 - (5 + 3)", e.toString());
    }


}