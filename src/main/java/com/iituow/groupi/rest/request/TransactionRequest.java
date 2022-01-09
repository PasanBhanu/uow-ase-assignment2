package com.iituow.groupi.rest.request;

import com.iituow.groupi.util.TransactionType;
import lombok.Data;

@Data
public class TransactionRequest {
    private TransactionType type;
    private Integer categoryId;
    private String description;
    private Double amount;
}
