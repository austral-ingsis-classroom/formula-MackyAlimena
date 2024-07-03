package edu.austral.ingsis.math;

import edu.austral.ingsis.math.binary.BinaryOperation;
import edu.austral.ingsis.math.binary.BinaryOperators;
import edu.austral.ingsis.math.unary.UnaryOperation;
import edu.austral.ingsis.math.unary.UnaryOperators;

public class Formatter {
    public static String format(Constant constant) {
        return String.valueOf(constant.getValue());
    }

    public static String format(Function function) {
        return function.print();
    }

    public static String format(UnaryOperation unaryOperation) {
        UnaryOperators operator = UnaryOperators.valueOf(unaryOperation.getOperator().toString());
        return operator.getSymbol() + format(unaryOperation.getOperator());
    }

    public static String format(BinaryOperation binaryOperation) {
        BinaryOperators operator = BinaryOperators.valueOf(binaryOperation.getOperator().toString());
        return "(" + format(binaryOperation.getLeftOperand()) + " " + operator.getSymbol() + " " + format(binaryOperation.getRightOperand()) + ")";
    }
}