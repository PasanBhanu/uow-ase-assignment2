package com.iituow.groupi.rest.controller;

import com.iituow.groupi.rest.request.CategoryRequest;
import com.iituow.groupi.rest.request.TransactionRequest;
import com.iituow.groupi.rest.response.CategoriesResponse;
import com.iituow.groupi.rest.response.CategoryResponse;
import com.iituow.groupi.rest.response.base.BaseResponse;
import com.iituow.groupi.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/all", produces = "application/json")
    public String getAllCategories(Model model) {
        CategoriesResponse categoriesResponse = this.categoryService.getAllCategories();
        model.addAttribute("categoriesResponse", categoriesResponse.getCategories());
        return "categories";
    }

    @GetMapping(path = "/get/{id}", produces = "application/json")
    public ResponseEntity<CategoryResponse> getTransaction(@PathVariable Integer id) {
        return ResponseEntity.ok(this.categoryService.getCategory(id));
    }

    @PostMapping(path = "/create")
    public String createTransaction(@ModelAttribute("foo") CategoryRequest payload, Model model) {
        this.categoryService.createCategory(payload);
        return "redirect:/categories/all";
    }

    @PostMapping(path = "/update/{id}", produces = "application/json")
    public ResponseEntity<BaseResponse> updateTransaction(@RequestBody CategoryRequest payload, @PathVariable Integer id) {
        return ResponseEntity.ok(this.categoryService.updateCategory(payload, id));
    }

    @GetMapping(path = "/delete/{id}", produces = "application/json")
    public String deleteTransaction(@PathVariable Integer id, Model model) {
        this.categoryService.deleteCategory(id);
        return "redirect:/categories/all";
    }

    @GetMapping("/showBudget")
    public String showBudget(Model model) {
        CategoriesResponse categoriesResponse = this.categoryService.getAllCategories();
        model.addAttribute("categoriesResponse", categoriesResponse);
        return "budget";
    }

    @GetMapping(path = "/showFormForAdd/{id}", produces = "application/json")
    public String showFormForAdd(@PathVariable Integer id, Model model) {
        CategoryResponse categoryResponse = this.categoryService.getCategory(id);
        model.addAttribute("addbudget", categoryResponse.getCategory());
        return "budget";
    }

    @GetMapping("/showNewTransactionForm")
    public String showNewTransactionForm(Model model) {
        TransactionRequest transaction = new TransactionRequest();
        CategoriesResponse categoriesResponse = this.categoryService.getAllCategories();
        model.addAttribute("categoriesResponse", categoriesResponse.getCategories());
        model.addAttribute("transaction", transaction);
        return "add_transaction";
    }

}
