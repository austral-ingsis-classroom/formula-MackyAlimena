package edu.austral.ingsis.math;

import java.util.Map;

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
                return leftValue / rightValue;
            default:
                throw new RuntimeException("Invalid operator");
        }
    }

    @Override
    public String print(){
        return "(" + left.print() + " " + operator + " " + right.print() + ")";
    }
}
