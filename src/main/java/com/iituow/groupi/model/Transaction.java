package com.iituow.groupi.model;

import com.iituow.groupi.util.TransactionType;
import lombok.Data;

@Data
public class Transaction {
    private Integer id;
    private TransactionType type;
    private Integer categoryId;
    private String description;
    private Double amount;
}
