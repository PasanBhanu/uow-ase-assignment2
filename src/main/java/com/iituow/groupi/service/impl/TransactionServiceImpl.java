package com.iituow.groupi.service.impl;

import com.iituow.groupi.service.TransactionService;
import com.iituow.groupi.service.model.Transaction;
import com.iituow.groupi.util.TransactionType;

import java.util.ArrayList;

public class TransactionServiceImpl implements TransactionService {
    @Override
    public ArrayList<Transaction> getAllTransactions() {
        return null;
    }

    @Override
    public Transaction getTransaction(Integer id) {
        return null;
    }

    @Override
    public Transaction createTransaction(Integer categoryId, TransactionType transactionType, String description, Double amount) {
        return null;
    }

    @Override
    public Transaction updateTransaction(Integer id, Integer categoryId, TransactionType transactionType, String description, Double amount) {
        return null;
    }

    @Override
    public void deleteTransaction(Integer id) {

    }
}
