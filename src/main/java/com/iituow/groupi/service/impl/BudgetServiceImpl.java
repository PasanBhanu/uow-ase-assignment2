package com.iituow.groupi.service.impl;

import com.iituow.groupi.service.model.Budget;
import com.iituow.groupi.service.BudgetService;
import org.springframework.stereotype.Service;

@Service
public class BudgetServiceImpl implements BudgetService {
    @Override
    public Budget getBudget(Integer id) {
        return null;
    }

    @Override
    public Budget createBudget(Integer categoryId, Double amount) {
        return null;
    }

    @Override
    public Budget updateBudget(Integer id, Double amount) {
        return null;
    }

    @Override
    public void deleteBudget(Integer id) {

    }
}
