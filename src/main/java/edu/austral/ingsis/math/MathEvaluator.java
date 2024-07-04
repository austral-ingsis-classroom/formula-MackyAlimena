package edu.austral.ingsis.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class MathEvaluator {
    final Map<String, Double> variables = new HashMap<>();
    private final Stack<Double> numbers = new Stack<>();

    public void addVariable(String name, Double value) {
        variables.put(name, value);
    }

    public void setVariable(String name, Double value) {
        variables.put(name, value);
    }

    public static double evaluate(String expression, Map<String, Double> variables) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid expression: Expression is empty");
        }

        Stack<Double> numbers = new Stack<>();
        Stack<Character> operations = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                StringBuilder numBuilder = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numBuilder.append(expression.charAt(i));
                    i++;
                }
                i--; // Adjust because for loop will increment i
                double num = Double.parseDouble(numBuilder.toString());
                numbers.push(num);
            } else if (c == '(') {
                int j = i, parenthesisCount = 0;
                for (; j < expression.length(); j++) {
                    if (expression.charAt(j) == '(') parenthesisCount++;
                    if (expression.charAt(j) == ')') parenthesisCount--;
                    if (parenthesisCount == 0) break;
                }
                double innerValue = evaluate(expression.substring(i + 1, j), variables);
                numbers.push(innerValue);
                i = j;

            } else if (c == '|') {
                int j = i + 1;
                while (j < expression.length() && expression.charAt(j) != '|') {
                    j++;
                }
                double innerValue = evaluate(expression.substring(i + 1, j), variables);
                numbers.push(Math.abs(innerValue));
                operations.push(c); // Push the '|' character onto the operations stack
                i = j;
            } else if (Character.isLetter(c)) {
                StringBuilder varBuilder = new StringBuilder();
                while (i < expression.length() && Character.isLetter(expression.charAt(i))) {
                    varBuilder.append(expression.charAt(i));
                    i++;
                }
                i--; // Adjust because for loop will increment i
                String varName = varBuilder.toString();
                if (variables.containsKey(varName)) {
                    numbers.push(variables.get(varName));
                } else {
                    throw new IllegalArgumentException("Invalid expression: Unknown variable " + varName);
                }
            } else if (isOperator(c)) {
                while (!operations.isEmpty() && precedence(operations.peek()) >= precedence(c)) {
                    if (numbers.size() < 2) {
                        throw new IllegalArgumentException("Invalid expression: Not enough operands for operation.");
                    }
                    double secondOperand = numbers.pop();
                    double firstOperand = numbers.pop();
                    char op = operations.pop();
                    double result = applyOp(firstOperand, secondOperand, op);
                    numbers.push(result);
                }
                operations.push(c);
            }
        }

        while (!operations.isEmpty()) {
            if (numbers.size() < 2) {
                if (operations.size() == 1) {
                    // Handle the case when there are no more operations to perform
                    return numbers.pop();
                } else {
                    throw new IllegalArgumentException("Invalid expression: Not enough operands for final operations.");
                }
            }
            double secondOperand = numbers.pop();
            double firstOperand = numbers.pop();
            char op = operations.pop();
            double result = applyOp(firstOperand, secondOperand, op);
            numbers.push(result);
        }

        if (numbers.size() == 1) {
            return numbers.pop();
        } else {
            throw new IllegalArgumentException("Invalid expression: Error in processing the expression.");
        }
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == 'd';
    }

    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case 'd':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    private static double applyOp(double a, double b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
            case 'd':
                if (b == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
            case '^':
                return Math.pow(a, b);
            default:
                return 0;
        }
    }
}