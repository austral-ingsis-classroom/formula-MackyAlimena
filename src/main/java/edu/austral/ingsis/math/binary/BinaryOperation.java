package edu.austral.ingsis.math.binary;

import edu.austral.ingsis.math.Constant;
import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.FunctionImpl;
import edu.austral.ingsis.math.Variable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;

public abstract class BinaryOperation extends FunctionImpl {
    protected final Function left;
    protected final Function right;
    protected BinaryOperator operator;

    public BinaryOperation(Function left, Function right) {
        this.left = left;
        this.right = right;
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

    public BinaryOperator getOperator() {
        return operator;
    }
}

