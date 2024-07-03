package edu.austral.ingsis.math;

import java.util.Map;

public class Constant extends FunctionImpl {
    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        return value;
    }
}
