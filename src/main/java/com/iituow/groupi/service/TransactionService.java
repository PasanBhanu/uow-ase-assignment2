package com.iituow.groupi.service;

import com.iituow.groupi.service.model.Transaction;
import com.iituow.groupi.util.TransactionType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface TransactionService {
    ArrayList<Transaction> getAllTransactions();

    Transaction getTransaction(Integer id);

    Transaction createTransaction(Integer categoryId, TransactionType transactionType, String description, Double amount);

    Transaction updateTransaction(Integer id, Integer categoryId, TransactionType transactionType, String description, Double amount);

    void deleteTransaction(Integer id);
}
