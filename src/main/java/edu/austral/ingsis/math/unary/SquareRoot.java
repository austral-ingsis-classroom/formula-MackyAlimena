package edu.austral.ingsis.math.unary;

import edu.austral.ingsis.math.Function;

import java.util.Map;

public class SquareRoot extends UnaryOperation {
    public SquareRoot(Function operand) {
        super(operand);
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        double value = operand.evaluate(variables);
        if (value < 0) {
            throw new RuntimeException("Cannot take square root of negative number");
        }
        return Math.sqrt(value);
    }

    @Override
    public String print() {
        return "√" + operand.print();
    }
}
