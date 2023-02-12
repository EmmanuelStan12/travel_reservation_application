package utils;

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
}
