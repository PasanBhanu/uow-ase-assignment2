package com.iituow.groupi.service.impl;

import com.iituow.groupi.database.model.DaoCategory;
import com.iituow.groupi.database.repository.CategoryRepository;
import com.iituow.groupi.rest.exception.DatabaseValidationException;
import com.iituow.groupi.rest.request.BudgetRequest;
import com.iituow.groupi.rest.response.base.BaseResponse;
import com.iituow.groupi.service.BudgetService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BudgetServiceImpl implements BudgetService {
    private final CategoryRepository categoryRepository;

    public BudgetServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public BaseResponse updateBudget(BudgetRequest payload) {
        Optional<DaoCategory> categoryOpt = this.categoryRepository.findById(payload.getCategoryId());
        if (categoryOpt.isPresent()) {
            DaoCategory category = categoryOpt.get();
            category.setBudget(payload.getBudget());
            this.categoryRepository.save(category);

            BaseResponse response = new BaseResponse();
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Budget updated successfully");

            return response;
        }

        throw new DatabaseValidationException(401, HttpStatus.NOT_FOUND, "Category not found!");
    }
}
