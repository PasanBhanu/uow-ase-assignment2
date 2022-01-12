package com.iituow.groupi.service.impl;

import com.iituow.groupi.database.model.DaoCategory;
import com.iituow.groupi.database.model.DaoTransaction;
import com.iituow.groupi.database.repository.CategoryRepository;
import com.iituow.groupi.database.repository.TransactionRepository;
import com.iituow.groupi.rest.exception.DatabaseValidationException;
import com.iituow.groupi.rest.request.CategoryRequest;
import com.iituow.groupi.rest.response.CategoriesResponse;
import com.iituow.groupi.rest.response.CategoryResponse;
import com.iituow.groupi.rest.response.base.BaseResponse;
import com.iituow.groupi.service.CategoryService;
import com.iituow.groupi.service.model.Category;
import com.iituow.groupi.service.model.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final TransactionRepository transactionRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, TransactionRepository transactionRepository) {
        this.categoryRepository = categoryRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public CategoriesResponse getAllCategories() {
        List<DaoCategory> categories = this.categoryRepository.findAll();

        CategoriesResponse response = new CategoriesResponse();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Categories successfully retrieved");
        response.setCategories(categories.stream()
                .map(Category::new)
                .collect(Collectors.toCollection(ArrayList::new)));

        return response;
    }

    @Override
    public CategoryResponse getCategory(Integer id) {
        Optional<DaoCategory> categoryOpt = this.categoryRepository.findById(id);
        if (categoryOpt.isPresent()) {
            List<DaoTransaction> transactions = this.transactionRepository.findByCategoryId(id);

            CategoryResponse response = new CategoryResponse();
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Category retrieved successfully");
            response.setCategory(categoryOpt.map(Category::new).get());
            response.setTransactions(transactions.stream()
                    .map(Transaction::new)
                    .collect(Collectors.toCollection(ArrayList::new)));

            return response;
        }

        throw new DatabaseValidationException(401, HttpStatus.NOT_FOUND, "Category not found!");
    }

    @Override
    public BaseResponse createCategory(CategoryRequest payload) {
        DaoCategory category = new DaoCategory();
        category.setTitle(payload.getTitle());
        this.categoryRepository.save(category);

        BaseResponse response = new BaseResponse();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Category created successfully");
        return response;
    }

    @Override
    public BaseResponse updateCategory(CategoryRequest payload, Integer id) {
        Optional<DaoCategory> categoryOpt = this.categoryRepository.findById(id);
        if (categoryOpt.isPresent()) {
            DaoCategory category = categoryOpt.get();
            category.setTitle(payload.getTitle());
            this.categoryRepository.save(category);

            BaseResponse response = new BaseResponse();
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Category updated successfully");

            return response;
        }

        throw new DatabaseValidationException(401, HttpStatus.NOT_FOUND, "Category not found!");
    }

    @Override
    public BaseResponse deleteCategory(Integer id) {
        Optional<DaoCategory> categoryOpt = this.categoryRepository.findById(id);
        if (categoryOpt.isPresent()) {
            if (this.transactionRepository.countByCategoryId(id) == 0) {
                this.categoryRepository.delete(categoryOpt.get());

                BaseResponse response = new BaseResponse();
                response.setStatus(HttpStatus.OK.value());
                response.setMessage("Category deleted successfully");
                return response;
            } else {
                throw new DatabaseValidationException(401, HttpStatus.NOT_FOUND, "Category is not empty!");
            }
        }

        throw new DatabaseValidationException(401, HttpStatus.NOT_FOUND, "Category not found!");
    }
}
