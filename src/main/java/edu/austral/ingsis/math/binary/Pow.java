package edu.austral.ingsis.math.binary;

import edu.austral.ingsis.math.Function;

import java.util.Map;

public class Pow extends BinaryOperation {

    public Pow(Function left, Function right) {
        super(left, right);
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        double baseValue = left.evaluate(variables);
        double exponentValue = right.evaluate(variables);
        return Math.pow(baseValue, exponentValue);
    }

    @Override
    public String print() {
        String basePrint = left instanceof BinaryOperation ? "(" + left.print() + ")" : left.print();
        String exponentPrint = right instanceof BinaryOperation ? "(" + right.print() + ")" : right.print();
        return basePrint + " ^ " + exponentPrint;
    }
}