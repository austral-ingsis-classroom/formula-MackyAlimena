package edu.austral.ingsis.math.binary;

import edu.austral.ingsis.math.Function;

import java.util.Map;

public class Division extends BinaryOperation {
    public Division(Function left, Function right) {
        super(left, right);
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        double divisor = right.evaluate(variables);
        if (divisor == 0) {
            throw new RuntimeException("Division by zero");
        }
        return left.evaluate(variables) / divisor;
    }

    @Override
    public String print() {
        return left.print() + " ÷ " + right.print();
    }
}
