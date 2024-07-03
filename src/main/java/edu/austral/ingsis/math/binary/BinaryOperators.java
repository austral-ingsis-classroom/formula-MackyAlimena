package edu.austral.ingsis.math.binary;

public enum BinaryOperators {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    EXPONENTIATION("^");

    private final String symbol;

    BinaryOperators(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
