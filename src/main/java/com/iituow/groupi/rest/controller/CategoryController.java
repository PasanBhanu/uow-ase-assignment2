package com.iituow.groupi.rest.controller;

import com.iituow.groupi.rest.request.CategoryRequest;
import com.iituow.groupi.rest.response.CategoriesResponse;
import com.iituow.groupi.rest.response.CategoryResponse;
import com.iituow.groupi.rest.response.base.BaseResponse;
import com.iituow.groupi.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/all", produces = "application/json")
    public ResponseEntity<CategoriesResponse> getAllCategories() {
        return ResponseEntity.ok(this.categoryService.getAllCategories());
    }

    @GetMapping(path = "/get/{id}", produces = "application/json")
    public ResponseEntity<CategoryResponse> getTransaction(@PathVariable Integer id) {
        return ResponseEntity.ok(this.categoryService.getCategory(id));
    }

    @PostMapping(path = "/create", produces = "application/json")
    public ResponseEntity<BaseResponse> createTransaction(@RequestBody CategoryRequest payload) {
        return ResponseEntity.ok(this.categoryService.createCategory(payload));
    }

    @PostMapping(path = "/update/{id}", produces = "application/json")
    public ResponseEntity<BaseResponse> updateTransaction(@RequestBody CategoryRequest payload, @PathVariable Integer id) {
        return ResponseEntity.ok(this.categoryService.updateCategory(payload, id));
    }

    @PostMapping(path = "/delete/{id}", produces = "application/json")
    public ResponseEntity<BaseResponse> deleteTransaction(@PathVariable Integer id) {
        return ResponseEntity.ok(this.categoryService.deleteCategory(id));
    }
}
