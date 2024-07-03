package edu.austral.ingsis.math;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class Variable extends FunctionImpl{

    private final String name;

    public Variable(String name){
        this.name = name;
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        if (!variables.containsKey(name)) {
            throw new RuntimeException("Variable '" + name + "' is not defined");
        }
        return variables.get(name);
    }

    @Override
    public Set<String> getVariables() {
        return Collections.singleton(name);
    }
}
