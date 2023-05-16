package calculator.dom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StringExpressionVisitorTest {

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

    @Test
    void X(){
        BinaryExpression e = new BinaryExpression();
        BinaryExpression right = new BinaryExpression();
        e.setRight(right);
        right.setLeft(new NumberExpression(5));
        right.setOperator(BinaryOperator.Plus);
        right.setRight(new NumberExpression(3));
        e.setOperator(BinaryOperator.Minus);
        e.setLeft(new XExpression());
        assertEquals("x - (5 + 3)", e.toString());
    }

    @Test
    void Fun(){
        FunctionExpression e = new FunctionExpression();
        e.setType(FunctionType.Log);
        e.getParameters().add(new NumberExpression(25));
        e.getParameters().add(new NumberExpression(5));
        assertEquals("log(25, 5)", e.toString());
    }

    @Test
    void FunAbs(){
        BinaryExpression e = new BinaryExpression();
        e.setLeft(new NumberExpression(2.5));
        e.setOperator(BinaryOperator.Div);
        BinaryExpression right = new BinaryExpression();
        right.setOperator(BinaryOperator.Plus);
        right.setRight(new NumberExpression(1));
        FunctionExpression f = new FunctionExpression();
        f.setType(FunctionType.Abs);
        f.getParameters().add(new XExpression());
        right.setLeft(f);
        e.setRight(right);
        assertEquals("2.5 / (abs(x) + 1)", e.toString());
    }

    @Test
    void Pi() {
        FunctionExpression e = new FunctionExpression();
        e.setType(FunctionType.Pi);
        assertEquals("pi()", e.toString());
    }

    @Test
    void E() {
        FunctionExpression e = new FunctionExpression();
        e.setType(FunctionType.E);
        assertEquals("e()", e.toString());
    }

    @Test
    void Greater() {
        BooleanExpression b = new BooleanExpression();
        b.setLeft(new NumberExpression(2.2));
        b.setOperator(BooleanOperator.Greater);
        b.setRight(new NumberExpression(5.8));
        assertEquals("2.2 > 5.8", b.toString());
    }

    @Test
    void Less() {
        BooleanExpression b = new BooleanExpression();
        b.setLeft(new NumberExpression(2.2));
        b.setOperator(BooleanOperator.Less);
        b.setRight(new NumberExpression(5.8));
        assertEquals("2.2 < 5.8", b.toString());
    }

    @Test
    void MoreEquals() {
        BooleanExpression b = new BooleanExpression();
        b.setLeft(new NumberExpression(2.2));
        b.setOperator(BooleanOperator.MoreEquals);
        b.setRight(new NumberExpression(5.8));
        assertEquals("2.2 ≥ 5.8", b.toString());
    }

    @Test
    void LessEquals() {
        BooleanExpression b = new BooleanExpression();
        b.setLeft(new NumberExpression(2.2));
        b.setOperator(BooleanOperator.LessEquals);
        b.setRight(new NumberExpression(5.8));
        assertEquals("2.2 ≤ 5.8", b.toString());
    }

    @Test
    void Equals() {
        BooleanExpression b = new BooleanExpression();
        b.setLeft(new NumberExpression(2.2));
        b.setOperator(BooleanOperator.Equals);
        b.setRight(new NumberExpression(2.2));
        assertEquals("2.2 = 2.2", b.toString());
    }

    @Test
    void NotEquals() {
        BooleanExpression b = new BooleanExpression();
        b.setLeft(new NumberExpression(2.2));
        b.setOperator(BooleanOperator.NotEquals);
        b.setRight(new NumberExpression(5.8));
        assertEquals("2.2 ≠ 5.8", b.toString());
    }

    @Test
    void If(){
        FunctionExpression function = new FunctionExpression();
        function.setType(FunctionType.If);

        BinaryExpression binaryPartOne = new BinaryExpression();
        binaryPartOne.setLeft(new NumberExpression(2));
        binaryPartOne.setOperator(BinaryOperator.Mul);
        binaryPartOne.setRight(new NumberExpression(2));

        BooleanExpression booleanExpression = new BooleanExpression();
        booleanExpression.setLeft(binaryPartOne);
        booleanExpression.setOperator(BooleanOperator.Equals);
        booleanExpression.setRight(new NumberExpression(5));

        BinaryExpression binaryPartTwo = new BinaryExpression();
        binaryPartTwo.setLeft(new NumberExpression(3));
        binaryPartTwo.setOperator(BinaryOperator.Plus);
        binaryPartTwo.setRight(new NumberExpression(7));

        BinaryExpression binaryPartThree = new BinaryExpression();
        binaryPartThree.setLeft(new NumberExpression(4));
        binaryPartThree.setOperator(BinaryOperator.Mul);
        binaryPartThree.setRight(new NumberExpression(8));

        function.getParameters().addAll(Arrays.asList(
                booleanExpression,
                binaryPartTwo,
                binaryPartThree));

        assertEquals("if(2 * 2 = 5, 3 + 7, 4 * 8)", function.toString());
    }

}