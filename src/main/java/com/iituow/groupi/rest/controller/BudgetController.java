package com.iituow.groupi.rest.controller;

import com.iituow.groupi.rest.request.BudgetRequest;
import com.iituow.groupi.rest.response.base.BaseResponse;
import com.iituow.groupi.service.BudgetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/budget")
public class BudgetController {
    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping(path = "/update", produces = "application/json")
    public ResponseEntity<BaseResponse> updateBudget(@RequestBody BudgetRequest payload) {
        return ResponseEntity.ok(this.budgetService.updateBudget(payload));
    }
}
