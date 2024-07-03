package edu.austral.ingsis.math.unary;

import edu.austral.ingsis.math.Constant;
import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.FunctionImpl;

import java.util.Set;

public abstract class UnaryOperation extends FunctionImpl {
    protected final Function operand;

    public UnaryOperation(Function operand) {
        this.operand = operand;
    }

    @Override
    public Set<String> getVariables() {
        return operand.getVariables();
    }

    public Function getOperator() {
        return operand;
    }
}
