package utils;

import java.util.Objects;

public enum Operator {
    EQUAL("Equal", "="), GREATER_THAN("Greater than", ">"),
    LESS_THAN("Less than", "<");
    private String operator;
    private String symbol;

    private Operator(String operator, String symbol) {
        this.operator = operator;
        this.symbol = symbol;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Operator getOperator(String name) {
        if (Objects.equals(EQUAL.getOperator(), name)) {
            return EQUAL;
        }
        if (Objects.equals(GREATER_THAN.getOperator(), name)) {
            return GREATER_THAN;
        }
        if (Objects.equals(LESS_THAN.getOperator(), name)) {
            return GREATER_THAN;
        }
        return null;
    }
}
