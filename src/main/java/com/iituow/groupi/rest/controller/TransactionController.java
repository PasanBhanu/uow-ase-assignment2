package com.iituow.groupi.rest.controller;

import com.iituow.groupi.rest.request.TransactionRequest;
import com.iituow.groupi.rest.response.TransactionResponse;
import com.iituow.groupi.rest.response.TransactionsResponse;
import com.iituow.groupi.rest.response.base.BaseResponse;
import com.iituow.groupi.service.TransactionService;
import org.springframework.http.HttpStatus;
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
        TransactionsResponse response = new TransactionsResponse();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Transactions retrieved successfully");
        response.setTransactions(this.transactionService.getAllTransactions());
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/get/{id}", produces = "application/json")
    public ResponseEntity<TransactionResponse> getTransaction(@PathVariable Integer id) {
        TransactionResponse response = new TransactionResponse();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Transaction retrieved successfully");
        response.setTransaction(this.transactionService.getTransaction(id));
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/create", produces = "application/json")
    public ResponseEntity<TransactionResponse> createTransaction(@RequestBody TransactionRequest payload) {
        TransactionResponse response = new TransactionResponse();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Transaction created successfully");
        response.setTransaction(this.transactionService.createTransaction(payload.getCategoryId(), payload.getType(), payload.getDescription(), payload.getAmount()));
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/update/{id}", produces = "application/json")
    public ResponseEntity<TransactionResponse> updateTransaction(@RequestBody TransactionRequest payload, @PathVariable Integer id) {
        TransactionResponse response = new TransactionResponse();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Transaction updated successfully");
        response.setTransaction(this.transactionService.updateTransaction(id, payload.getCategoryId(), payload.getType(), payload.getDescription(), payload.getAmount()));
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/delete/{id}", produces = "application/json")
    public ResponseEntity<BaseResponse> deleteTransaction(@PathVariable Integer id) {
        this.transactionService.deleteTransaction(id);
        BaseResponse response = new BaseResponse();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Transaction deleted successfully");
        return ResponseEntity.ok(response);
    }
}
