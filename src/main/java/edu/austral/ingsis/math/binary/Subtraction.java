package edu.austral.ingsis.math.binary;

import edu.austral.ingsis.math.Formatter;
import edu.austral.ingsis.math.Function;

import java.util.Map;

public class Subtraction extends BinaryOperation {
    public Subtraction(Function left, Function right) {
        super(left, right, BinaryOperators.SUBTRACTION);
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        return left.evaluate(variables) - right.evaluate(variables);
    }

    @Override
    public String print() {
        return Formatter.format(this);
    }
}
