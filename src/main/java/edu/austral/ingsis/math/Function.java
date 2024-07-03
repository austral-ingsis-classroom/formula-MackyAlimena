package edu.austral.ingsis.math;

import java.util.Map;
import java.util.Set;

public interface Function {
    double evaluate(Map<String, Double> variables);
    String print();
    Set<String> getVariables();
}