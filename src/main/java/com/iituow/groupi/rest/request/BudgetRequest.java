package com.iituow.groupi.rest.request;

import lombok.Data;

@Data
public class BudgetRequest {
    private Integer categoryId;
    private Double budget;
}
