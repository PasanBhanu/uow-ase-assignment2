package com.iituow.groupi.rest.response;

import com.iituow.groupi.rest.response.base.BaseResponse;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BudgetResponse extends BaseResponse {
    private BigDecimal budget;
    private BigDecimal totalExpense;
    private BigDecimal totalIncome;
}
