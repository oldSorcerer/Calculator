package io.sancta.sanctorum.calculator.dom;

import io.sancta.sanctorum.calculator.dom.processing.StringExpressionVisitor;

public abstract class Expression {

    public abstract <T> T accept(ExpressionVisitor<T> visitor);

    @Override
    public String toString() {
        return this.accept(new StringExpressionVisitor());
    }

    public boolean isEmpty(){
        return false;
    }
}