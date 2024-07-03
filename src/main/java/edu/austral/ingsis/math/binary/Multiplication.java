package edu.austral.ingsis.math.binary;

import edu.austral.ingsis.math.Formatter;
import edu.austral.ingsis.math.Function;

import java.util.Map;

public class Multiplication extends BinaryOperation {
    public Multiplication(Function left, Function right) {
        super(left, right, BinaryOperators.MULTIPLICATION);
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        return left.evaluate(variables) * right.evaluate(variables);
    }

    @Override
    public String print() {
        return Formatter.format(this);
    }
}
