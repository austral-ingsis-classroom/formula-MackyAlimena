package edu.austral.ingsis.math.binary;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.FunctionImpl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class BinaryOperation extends FunctionImpl {
    protected final Function left;
    protected final Function right;
    protected BinaryOperators operator;

    public BinaryOperation(Function left, Function right, BinaryOperators operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public Set<String> getVariables() {
        Set<String> variables = new HashSet<>();
        variables.addAll(left.getVariables());
        variables.addAll(right.getVariables());
        return variables;
    }

    public Function getLeftOperand() {
        return left;
    }

    public Function getRightOperand() {
        return right;
    }

    public BinaryOperators getOperator() {
        return operator;
    }
}