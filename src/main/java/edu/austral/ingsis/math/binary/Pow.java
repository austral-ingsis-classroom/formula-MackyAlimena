package edu.austral.ingsis.math.binary;

import edu.austral.ingsis.math.Formatter;
import edu.austral.ingsis.math.Function;

import java.util.Map;

public class Pow extends BinaryOperation {

    public Pow(Function left, Function right) {
        super(left, right, BinaryOperators.EXPONENTIATION);
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        double baseValue = left.evaluate(variables);
        double exponentValue = right.evaluate(variables);
        return Math.pow(baseValue, exponentValue);
    }

    @Override
    public String print() {
        return Formatter.format(this);
    }
}