package edu.austral.ingsis.math;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Operation extends FunctionImpl{

    private final Function left;
    private final Function right;
    private final String operator;

    public Operation(Function left, Function right, String operator){
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        double leftValue = left.evaluate(variables);
        double rightValue = right.evaluate(variables);

        switch (operator){
            case "+":
                return leftValue + rightValue;
            case "-":
                return leftValue - rightValue;
            case "*":
                return leftValue * rightValue;
            case "/":
                if (rightValue == 0) {
                    throw new RuntimeException("Division by zero");
                }
                return leftValue / rightValue;
            case "^":
                return Math.pow(leftValue, rightValue);
            case "√":
                if (rightValue < 0) {
                    throw new RuntimeException("Cannot take square root of negative number");
                }
                return Math.sqrt(rightValue);
            case "%":
                return leftValue % rightValue;
            default:
                throw new RuntimeException("Invalid operator");
        }
    }

    @Override
    public String print(){
        return "(" + left.print() + " " + operator + " " + right.print() + ")";
    }

    @Override
    public Set<String> getVariables() {
        Set<String> variables = new HashSet<>();
        variables.addAll(left.getVariables());
        variables.addAll(right.getVariables());
        return variables;
    }
}

