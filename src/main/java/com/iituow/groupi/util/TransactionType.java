package com.iituow.groupi.util;

public enum TransactionType {
    Income (1),
    Expense (2);

    private final Integer label;

    TransactionType(Integer label) {
        this.label = label;
    }

    public Integer label() {
        return label;
    }
}
