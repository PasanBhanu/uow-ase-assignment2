package com.iituow.groupi.service;

import com.iituow.groupi.rest.request.BudgetRequest;
import com.iituow.groupi.rest.response.BudgetResponse;
import com.iituow.groupi.rest.response.base.BaseResponse;

public interface BudgetService {
    BudgetResponse getOverview();

    BudgetResponse getBudget(Integer id);

    BaseResponse updateBudget(BudgetRequest payload);
}
