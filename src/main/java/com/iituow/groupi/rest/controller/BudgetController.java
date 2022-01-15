package com.iituow.groupi.rest.controller;

import com.iituow.groupi.rest.request.BudgetRequest;
import com.iituow.groupi.rest.response.BudgetResponse;
import com.iituow.groupi.rest.response.base.BaseResponse;
import com.iituow.groupi.service.BudgetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/budget")
public class BudgetController {
    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping(path = "/get/{id}", produces = "application/json")
    public ResponseEntity<BudgetResponse> getTransaction(@PathVariable Integer id) {
        return ResponseEntity.ok(this.budgetService.getBudget(id));
    }

    @PostMapping(path = "/update", produces = "application/json")
    public ResponseEntity<BaseResponse> updateBudget(@RequestBody BudgetRequest payload) {
        return ResponseEntity.ok(this.budgetService.updateBudget(payload));
    }
}
