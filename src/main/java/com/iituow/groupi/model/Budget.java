package com.iituow.groupi.model;

import lombok.Data;

@Data
public class Budget {
    private Integer id;
    private Integer categoryId;
    private Double amount;
}
