package com.iituow.groupi.rest.response;

import com.iituow.groupi.rest.response.base.BaseResponse;
import lombok.Data;

@Data
public class BudgetResponse extends BaseResponse {
    private Double budget;
    private Double totalExpense;
    private Double totalIncome;
}
