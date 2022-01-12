package com.iituow.groupi.service;

import com.iituow.groupi.service.model.Budget;

public interface BudgetService {
    Budget getBudget(Integer id);

    Budget createBudget(Integer categoryId, Double amount);

    Budget updateBudget(Integer id, Double amount);

    void deleteBudget(Integer id);
}
