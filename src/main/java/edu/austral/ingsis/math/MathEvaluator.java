package edu.austral.ingsis.math;

import java.util.Stack;

public class MathEvaluator {

    public static double evaluate(String expression) {
        // Simplified version for demonstration. A full implementation would require more comprehensive parsing.
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operations = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                double num = 0;
                while (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                    i++;
                    if (i < expression.length()) {
                        c = expression.charAt(i);
                    } else {
                        break;
                    }
                }
                i--;
                numbers.push(num);
            } else if (c == '(') {
                // Find the corresponding closing parenthesis and evaluate the expression within
                int j = i, parenthesisCount = 0;
                for (; j < expression.length(); j++) {
                    if (expression.charAt(j) == '(') parenthesisCount++;
                    if (expression.charAt(j) == ')') parenthesisCount--;
                    if (parenthesisCount == 0) break;
                }
                double innerValue = evaluate(expression.substring(i + 1, j));
                numbers.push(innerValue);
                i = j;
            } else if (isOperator(c)) {
                while (!operations.isEmpty() && precedence(operations.peek()) >= precedence(c)) {
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
                throw new IllegalArgumentException("Invalid expression");
            }
            double secondOperand = numbers.pop();
            double firstOperand = numbers.pop();
            char op = operations.pop();
            double result = applyOp(firstOperand, secondOperand, op);
            numbers.push(result);
        }

        return numbers.pop();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
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