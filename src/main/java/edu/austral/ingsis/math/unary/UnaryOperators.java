package edu.austral.ingsis.math.unary;

public enum UnaryOperators {
    ABSOLUTE("|"),
    SQUARE_ROOT("√");


    private final String symbol;

    UnaryOperators(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
