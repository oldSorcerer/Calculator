package io.sancta.sanctorum.calculator.dom;

import static java.lang.Math.*;

import java.util.function.Function;

public enum FunctionType {
    Sqrt(x -> sqrt(x[0])),
    Log(x -> log(x[0]) / log(x[1])),
    Sin(x -> sin(x[0])),
    Cos(x -> cos(x[0])),
    Exp(x -> exp(x[0])),
    Abs(x -> abs(x[0])),
    Pi(x -> PI),
    E(x -> Math.E),
    If(x -> x[0] != 0 ? x[1] : x[2]);

    private final Function<double[], Double> calc;

    FunctionType(Function<double[], Double> function) {
        calc = function;
    }

    public Double calculate(double[] x) {
        return calc.apply(x);
    }
}