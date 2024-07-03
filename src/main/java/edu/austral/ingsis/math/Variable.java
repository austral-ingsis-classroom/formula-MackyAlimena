package edu.austral.ingsis.math;

import java.util.Map;

public class Variable extends FunctionImpl{

    private final String name;

    public Variable(String name){
        this.name = name;
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        return variables.get(name);
    }
}
