package edu.austral.ingsis.math.unary;

import edu.austral.ingsis.math.Formatter;
import edu.austral.ingsis.math.Function;

import java.util.Map;

public class AbsoluteValue extends UnaryOperation {
    public AbsoluteValue(Function operand) {
        super(operand);
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        double value = operand.evaluate(variables);
        return Math.abs(value);
    }

    @Override
    public String print() {
        return Formatter.format(this);
    }
}

