package edu.austral.ingsis.math;

import edu.austral.ingsis.math.binary.BinaryOperation;
import edu.austral.ingsis.math.binary.BinaryOperators;
import edu.austral.ingsis.math.unary.AbsoluteValue;
import edu.austral.ingsis.math.unary.SquareRoot;
import edu.austral.ingsis.math.unary.UnaryOperation;
import edu.austral.ingsis.math.unary.UnaryOperators;

public class Formatter {
    public static String format(Constant constant) {
        double value = (double) constant.getValue();
        if (value == (long) value) {
            return String.format("%d", (long) value);
        } else {
            return String.format("%s", value);
        }
    }

    public static String format(Function function) {
        if (function instanceof Constant) {
            return format((Constant) function);
        } else if (function instanceof BinaryOperation) {
            return format((BinaryOperation) function);
        } else if (function instanceof UnaryOperation) {
            return format((UnaryOperation) function);
        } else if (function instanceof Variable) {
            return ((Variable) function).getName(); // Directly return the variable's name
        } else {
            // Fallback or error handling
            return function.print();
        }
    }

    public static String format(UnaryOperation unaryOperation) {
        String operatorSymbol = "";
        if (unaryOperation instanceof AbsoluteValue) {
            operatorSymbol = UnaryOperators.ABSOLUTE.getSymbol();
            String operandFormatted = format(unaryOperation.getOperator());
            // Ensure the absolute value symbols are correctly placed around the operand
            return operatorSymbol + operandFormatted + operatorSymbol;
        } else if (unaryOperation instanceof SquareRoot) {
            operatorSymbol = UnaryOperators.SQUARE_ROOT.getSymbol();
            String operandFormatted = format(unaryOperation.getOperator());
            return operatorSymbol + "(" + operandFormatted + ")";
        }
        // Fallback for other unary operations not explicitly handled
        String operandFormatted = format(unaryOperation.getOperator());
        return "(" + operatorSymbol + operandFormatted + ")";
    }

    public static String format(BinaryOperation binaryOperation) {
        BinaryOperators operator = binaryOperation.getOperator();
        String leftFormatted = format(binaryOperation.getLeftOperand());
        String rightFormatted = format(binaryOperation.getRightOperand());

        // Handle complex expressions with parentheses
        if (binaryOperation.getLeftOperand() instanceof BinaryOperation) {
            leftFormatted = "(" + leftFormatted + ")";
        }
        if (binaryOperation.getRightOperand() instanceof BinaryOperation || binaryOperation.getRightOperand() instanceof UnaryOperation) {
            rightFormatted = "(" + rightFormatted + ")";
        }

        return leftFormatted + " " + operator.getSymbol() + " " + rightFormatted;
    }
}