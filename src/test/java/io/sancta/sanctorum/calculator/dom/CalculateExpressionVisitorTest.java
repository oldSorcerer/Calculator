package io.sancta.sanctorum.calculator.dom;

import io.sancta.sanctorum.calculator.dom.processing.CalculateExpressionVisitor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CalculateExpressionVisitorTest {

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

        assertEquals((5 - 3) * 10, e.accept(new CalculateExpressionVisitor(0)));
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

        assertEquals(5 * 3 - 10,  e.accept(new CalculateExpressionVisitor(0)));

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
        assertEquals(10 - 5 * 3,  e.accept(new CalculateExpressionVisitor(0)));
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
        assertEquals(10.0 / (5 * 3), e.accept(new CalculateExpressionVisitor(0)));
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
        assertEquals(10 - (5 + 3),  e.accept(new CalculateExpressionVisitor(0)));
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
        double x = 10;
        assertEquals( x - (5 + 3),  e.accept(new CalculateExpressionVisitor(x)));
    }

    @Test
    void Fun(){
        FunctionExpression e = new FunctionExpression();
        e.setType(FunctionType.Log);
        e.getParameters().add(new NumberExpression(125));
        e.getParameters().add(new NumberExpression(5));
        assertEquals(3, e.accept(new CalculateExpressionVisitor(0)).intValue());
    }

    @Test
    void FunAbs() {
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
        assertEquals(2.5/4, e.accept(new CalculateExpressionVisitor(-3)));
    }

    @Test
    void Greater() {
        BooleanExpression b = new BooleanExpression();
        b.setLeft(new NumberExpression(2.2));
        b.setOperator(BooleanOperator.Greater);
        b.setRight(new NumberExpression(5.8));
        assertEquals(0, b.accept(new CalculateExpressionVisitor()));
    }

    @Test
    void Less() {
        BooleanExpression b = new BooleanExpression();
        b.setLeft(new NumberExpression(2.2));
        b.setOperator(BooleanOperator.Less);
        b.setRight(new NumberExpression(5.8));
        assertEquals(1, b.accept(new CalculateExpressionVisitor()));
    }

    @Test
    void MoreEquals() {
        BooleanExpression b = new BooleanExpression();
        b.setLeft(new NumberExpression(2.2));
        b.setOperator(BooleanOperator.MoreEquals);
        b.setRight(new NumberExpression(5.8));
        assertEquals(0, b.accept(new CalculateExpressionVisitor()));
    }

    @Test
    void LessEquals() {
        BooleanExpression b = new BooleanExpression();
        b.setLeft(new NumberExpression(2.2));
        b.setOperator(BooleanOperator.LessEquals);
        b.setRight(new NumberExpression(5.8));
        assertEquals(1, b.accept(new CalculateExpressionVisitor()));
    }

    @Test
    void Equals() {
        BooleanExpression b = new BooleanExpression();
        b.setLeft(new NumberExpression(2.2));
        b.setOperator(BooleanOperator.Equals);
        b.setRight(new NumberExpression(2.2));
        assertEquals(1, b.accept(new CalculateExpressionVisitor()));
    }

    @Test
    void NotEquals() {
        BooleanExpression b = new BooleanExpression();
        b.setLeft(new NumberExpression(2.2));
        b.setOperator(BooleanOperator.NotEquals);
        b.setRight(new NumberExpression(5.8));
        assertEquals(1, b.accept(new CalculateExpressionVisitor()));
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

        assertEquals(32, function.accept(new CalculateExpressionVisitor()));
    }

}