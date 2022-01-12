package com.iituow.groupi.service.impl;

import com.iituow.groupi.database.model.DaoTransaction;
import com.iituow.groupi.database.repository.TransactionRepository;
import com.iituow.groupi.rest.exception.DatabaseValidationException;
import com.iituow.groupi.rest.request.TransactionRequest;
import com.iituow.groupi.rest.response.TransactionResponse;
import com.iituow.groupi.rest.response.TransactionsResponse;
import com.iituow.groupi.rest.response.base.BaseResponse;
import com.iituow.groupi.service.TransactionService;
import com.iituow.groupi.service.model.Transaction;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public TransactionsResponse getAllTransactions() {
        // Get All Transactions
        List<DaoTransaction> transactions = this.transactionRepository.findAll();

        TransactionsResponse response = new TransactionsResponse();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Transactions retrieved successfully");
        response.setTransactions(transactions.stream()
                .map(Transaction::new)
                .collect(Collectors.toCollection(ArrayList::new)));

        return response;
    }

    @Override
    public TransactionResponse getTransaction(Integer id) {
        Optional<DaoTransaction> transactionOpt = this.transactionRepository.findById(id);
        if (transactionOpt.isPresent()) {
            TransactionResponse response = new TransactionResponse();
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Transaction retrieved successfully");
            response.setTransaction(transactionOpt.map(Transaction::new).get());
        }

        throw new DatabaseValidationException(401, HttpStatus.NOT_FOUND, "Transaction not found!");
    }

    @Override
    public BaseResponse createTransaction(TransactionRequest payload) {
        DaoTransaction transaction = new DaoTransaction();
        transaction.setType(payload.getType().label());
        transaction.setCategoryId(payload.getCategoryId());
        transaction.setDescription(payload.getDescription());
        transaction.setAmount(payload.getAmount());
        this.transactionRepository.save(transaction);

        BaseResponse response = new BaseResponse();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Transaction created successfully");
        return response;
    }

    @Override
    public BaseResponse updateTransaction(TransactionRequest payload, Integer id) {
        Optional<DaoTransaction> transactionOpt = this.transactionRepository.findById(id);
        if (transactionOpt.isPresent()) {
            DaoTransaction transaction = transactionOpt.get();
            transaction.setCategoryId(payload.getCategoryId());
            transaction.setDescription(payload.getDescription());
            transaction.setAmount(payload.getAmount());
            this.transactionRepository.save(transaction);

            BaseResponse response = new BaseResponse();
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Transaction created successfully");
            return response;
        }

        throw new DatabaseValidationException(401, HttpStatus.NOT_FOUND, "Transaction not found!");
    }

    @Override
    public BaseResponse deleteTransaction(Integer id) {
        Optional<DaoTransaction> transactionOpt = this.transactionRepository.findById(id);
        transactionOpt.ifPresent(this.transactionRepository::delete);

        throw new DatabaseValidationException(401, HttpStatus.NOT_FOUND, "Transaction not found!");
    }
}
