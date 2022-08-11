package calculator.dom;

import calculator.dom.expression.BinaryExpression;
import calculator.dom.expression.FunctionExpression;
import calculator.dom.expression.NumberExpression;
import calculator.dom.expression.XExpression;
import calculator.dom.expression.visitor.CalculateExpressionVisitor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}