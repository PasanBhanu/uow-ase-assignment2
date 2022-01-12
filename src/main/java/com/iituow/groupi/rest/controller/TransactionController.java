package com.iituow.groupi.rest.controller;

import com.iituow.groupi.rest.request.TransactionRequest;
import com.iituow.groupi.rest.response.TransactionResponse;
import com.iituow.groupi.rest.response.TransactionsResponse;
import com.iituow.groupi.rest.response.base.BaseResponse;
import com.iituow.groupi.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping(path = "/all", produces = "application/json")
    public ResponseEntity<TransactionsResponse> getAllTransactions() {
        return ResponseEntity.ok(this.transactionService.getAllTransactions());
    }

    @GetMapping(path = "/get/{id}", produces = "application/json")
    public ResponseEntity<TransactionResponse> getTransaction(@PathVariable Integer id) {
        return ResponseEntity.ok(this.transactionService.getTransaction(id));
    }

    @PostMapping(path = "/create", produces = "application/json")
    public ResponseEntity<BaseResponse> createTransaction(@RequestBody TransactionRequest payload) {
        return ResponseEntity.ok(this.transactionService.createTransaction(payload));
    }

    @PostMapping(path = "/update/{id}", produces = "application/json")
    public ResponseEntity<BaseResponse> updateTransaction(@RequestBody TransactionRequest payload, @PathVariable Integer id) {
        return ResponseEntity.ok(this.transactionService.updateTransaction(payload, id));
    }

    @PostMapping(path = "/delete/{id}", produces = "application/json")
    public ResponseEntity<BaseResponse> deleteTransaction(@PathVariable Integer id) {
        return ResponseEntity.ok(this.transactionService.deleteTransaction(id));
    }
}
