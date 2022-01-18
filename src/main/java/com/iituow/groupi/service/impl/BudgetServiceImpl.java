package com.iituow.groupi.service.impl;

import com.iituow.groupi.database.model.DaoCategory;
import com.iituow.groupi.database.repository.CategoryRepository;
import com.iituow.groupi.database.repository.TransactionRepository;
import com.iituow.groupi.rest.exception.DatabaseValidationException;
import com.iituow.groupi.rest.request.BudgetRequest;
import com.iituow.groupi.rest.response.BudgetResponse;
import com.iituow.groupi.rest.response.base.BaseResponse;
import com.iituow.groupi.service.BudgetService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class BudgetServiceImpl implements BudgetService {
    private final CategoryRepository categoryRepository;
    private final TransactionRepository transactionRepository;

    public BudgetServiceImpl(CategoryRepository categoryRepository, TransactionRepository transactionRepository) {
        this.categoryRepository = categoryRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public BudgetResponse getOverview() {
        BigDecimal totalIncome = this.transactionRepository.getTotalIncome();
        BigDecimal totalExpense = this.transactionRepository.getTotalExpense();
        BigDecimal totalBudget = this.categoryRepository.getTotalBudget();

        BudgetResponse response = new BudgetResponse();
        response.setBudget(totalBudget != null ? totalBudget : new BigDecimal(0));
        response.setTotalIncome(totalIncome != null ? totalIncome : new BigDecimal(0));
        response.setTotalExpense(totalExpense != null ? totalExpense : new BigDecimal(0));
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Budget details successfully retrieved");

        return response;
    }

    @Override
    public BudgetResponse getBudget(Integer id) {
        Optional<DaoCategory> categoryOpt = this.categoryRepository.findById(id);
        if (categoryOpt.isPresent()) {
            // Get Total Income
            BigDecimal income = this.transactionRepository.getTotalIncomeByCategoryId(id);

            // Get Total Expense
            BigDecimal expense = this.transactionRepository.getTotalExpenseByCategoryId(id);

            BudgetResponse response = new BudgetResponse();
            response.setBudget(new BigDecimal(categoryOpt.get().getBudget()));
            response.setTotalIncome(income != null ? income : new BigDecimal(0));
            response.setTotalExpense(expense != null ? expense : new BigDecimal(0));
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Budget details successfully retrieved");

            return response;
        }

        throw new DatabaseValidationException(401, HttpStatus.NOT_FOUND, "Category not found!");
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
