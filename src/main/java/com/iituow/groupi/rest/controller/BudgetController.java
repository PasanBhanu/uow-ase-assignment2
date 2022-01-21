package com.iituow.groupi.rest.controller;

import com.iituow.groupi.rest.request.BudgetRequest;
import com.iituow.groupi.rest.response.BudgetResponse;
import com.iituow.groupi.rest.response.CategoriesResponse;
import com.iituow.groupi.service.BudgetService;
import com.iituow.groupi.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/budget")
public class BudgetController {
    private final BudgetService budgetService;
    private final CategoryService categoryService;

    public BudgetController(BudgetService budgetService, CategoryService categoryService) {
        this.budgetService = budgetService;
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/get", produces = "application/json")
    public String getOverview(Model model) {
        BudgetResponse budgetResponse = this.budgetService.getOverview();
        CategoriesResponse categoriesResponse = this.categoryService.getAllCategories();
        model.addAttribute("categoriesResponse", categoriesResponse.getCategories());
        model.addAttribute("allProgress", budgetResponse);
        return "progress";
    }

    @GetMapping(path = "/get/{id}", produces = "application/json")
    public String getBudget(@PathVariable Integer id, Model model) {
        BudgetResponse budgetResponse = this.budgetService.getBudget(id);
        model.addAttribute("catProgress", budgetResponse);
        return "progress";
    }

    @PostMapping(path = "/update", produces = "application/json")
    public String updateBudget(@ModelAttribute("addbudget") BudgetRequest payload) {
        this.budgetService.updateBudget(payload);
        return "redirect:/categories/all";
    }

//    @GetMapping("/showProgress")
//    public String showProgress(Model model) {
//        TransactionRequest transaction = new TransactionRequest();
//        model.addAttribute("transaction", transaction);
//        return "transaction_list";
//    }


}
