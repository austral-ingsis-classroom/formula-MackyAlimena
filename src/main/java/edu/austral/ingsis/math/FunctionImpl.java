package edu.austral.ingsis.math;

import java.util.Map;

public abstract class FunctionImpl implements Function {
    @Override
    public String print() {
        return this.getClass().getSimpleName();
    }

}
