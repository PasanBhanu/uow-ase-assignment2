package com.iituow.groupi.rest.controller;

import com.iituow.groupi.rest.request.BudgetRequest;
import com.iituow.groupi.rest.response.BudgetResponse;
import com.iituow.groupi.rest.response.base.BaseResponse;
import com.iituow.groupi.service.BudgetService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/budget")
public class BudgetController {
    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping(path = "/get", produces = "application/json")
    public ResponseEntity<BudgetResponse> getOverview() {
        return ResponseEntity.ok(this.budgetService.getOverview());
    }

    @GetMapping(path = "/get/{id}", produces = "application/json")
    public ResponseEntity<BudgetResponse> getBudget(@PathVariable Integer id) {
        return ResponseEntity.ok(this.budgetService.getBudget(id));
    }

    @PostMapping(path = "/update", produces = "application/json")
    public String updateBudget(@ModelAttribute("addbudget") BudgetRequest payload) {
        this.budgetService.updateBudget(payload);
        return "redirect:/categories/all";
    }


}
