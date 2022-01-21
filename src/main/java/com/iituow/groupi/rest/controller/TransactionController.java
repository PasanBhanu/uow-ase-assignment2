package com.iituow.groupi.rest.controller;

import com.iituow.groupi.rest.request.TransactionRequest;
import com.iituow.groupi.rest.response.CategoriesResponse;
import com.iituow.groupi.rest.response.TransactionResponse;
import com.iituow.groupi.rest.response.TransactionsResponse;
import com.iituow.groupi.rest.response.base.BaseResponse;
import com.iituow.groupi.service.CategoryService;
import com.iituow.groupi.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final CategoryService categoryService;

    public TransactionController(TransactionService transactionService, CategoryService categoryService) {
        this.transactionService = transactionService;
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/all", produces = "application/json")
    public String getAllTransactions(Model model) {
        TransactionsResponse response = this.transactionService.getAllTransactions();
        model.addAttribute("transactionResponse", response.getTransactions());
        return "transaction_list";
    }

    @GetMapping(path = "/get/{id}", produces = "application/json")
    public ResponseEntity<TransactionResponse> getTransaction(@PathVariable Integer id) {
        return ResponseEntity.ok(this.transactionService.getTransaction(id));
    }

    @PostMapping(path = "/create", produces = "application/json")
    public String createTransaction(@ModelAttribute("transaction") TransactionRequest payload) {
        this.transactionService.createTransaction(payload);
        return "redirect:/transactions/all";
    }

    @PostMapping(path = "/update/{id}", produces = "application/json")
    public String updateTransaction(@ModelAttribute("transaction") TransactionRequest payload, @PathVariable Integer id) {
        this.transactionService.updateTransaction(payload, id);
        return "redirect:/transactions/all";
    }

    @GetMapping(path = "/delete/{id}", produces = "application/json")
    public String deleteTransaction(@PathVariable Integer id, Model model) {
        this.transactionService.deleteTransaction(id);
        return "redirect:/transactions/all";
    }

    @GetMapping("/showTransactionList")
    public String showNewTransactionForm(Model model) {
        TransactionRequest transaction = new TransactionRequest();
        model.addAttribute("transaction", transaction);
        return "transaction_list";
    }

    @GetMapping("/showUpdateTransactionForm/{id}")
    public String showUpdateTransactionForm(@PathVariable Integer id, Model model) {
        TransactionResponse transaction = this.transactionService.getTransaction(id);
        CategoriesResponse categoriesResponse = this.categoryService.getAllCategories();
        model.addAttribute("categoriesResponse", categoriesResponse.getCategories());
        model.addAttribute("transaction", transaction.getTransaction());
        return "add_transaction";
    }
}
