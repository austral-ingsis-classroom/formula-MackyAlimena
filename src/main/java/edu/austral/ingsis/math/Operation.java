package edu.austral.ingsis.math;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Operation extends FunctionImpl {

    private final Function left;
    private final Function right;
    private final String operator;

    public Operation(Function left, Function right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        double leftValue = left.evaluate(variables);
        double rightValue = right.evaluate(variables);

        switch (operator) {
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
                // Assuming square root applies to the right operand
                if (rightValue < 0) {
                    throw new RuntimeException("Cannot take square root of negative number");
                }
                return Math.sqrt(rightValue);
            case "%":
                return leftValue % rightValue;
            case "|":
                // Handling absolute value for both operands
                leftValue = Math.abs(leftValue);
                rightValue = Math.abs(rightValue);
                // No specific operation for two absolute values, returning leftValue as example
                return leftValue;
            default:
                throw new RuntimeException("Invalid operator");
        }
    }

    @Override
    public String print() {
        String leftPrint = formatOperand(left);
        String rightPrint = right!= null? formatOperand(right) : "";

        if (left instanceof Operation && ((Operation) left).getOperator().equals("|")) {
            return leftPrint + (right!= null? " " + operator + " " + rightPrint : "");
        } else if (operator.equals("|")) {
            if (right == null) {
                return "|" + leftPrint + "|";
            } else {
                return "|" + leftPrint + "|" + " " + operator + " " + rightPrint;
            }
        } else if (left instanceof Operation) {
            return "(" + leftPrint + ") " + operator + " " + rightPrint;
        } else if (right instanceof Operation) {
            return leftPrint + " " + operator + " (" + rightPrint + ")";
        } else {
            return leftPrint + " " + operator + " " + rightPrint;
        }
    }

    private Object getOperator() {
        return operator;
    }

    private String formatOperand(Function operand) {
        if (operand == null) {
            return "";
        } else if (operand instanceof Constant) {
            double value = ((Constant) operand).evaluate(Collections.emptyMap());
            if (value == (long) value) {
                return String.format("%d", (long) value);
            } else {
                return String.format("%.1f", value).replaceAll("[.]0$", "");
            }
        } else if (operand instanceof Variable) {
            return ((Variable) operand).getName();
        } else {
            return operand.print();
        }
    }

    @Override
    public Set<String> getVariables() {
        Set<String> variables = new HashSet<>();
        variables.addAll(left.getVariables());
        variables.addAll(right.getVariables());
        return variables;
    }
}

