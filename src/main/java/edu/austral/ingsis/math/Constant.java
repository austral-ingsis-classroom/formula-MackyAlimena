package edu.austral.ingsis.math;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class Constant extends FunctionImpl {
    private final double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        return value;
    }

    @Override
    public Set<String> getVariables() {
        return Collections.emptySet();
    }

    @Override
    public String print() {
        return String.valueOf(value);
    }
}
