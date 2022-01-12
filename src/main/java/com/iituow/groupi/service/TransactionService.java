package com.iituow.groupi.service;

import com.iituow.groupi.rest.request.TransactionRequest;
import com.iituow.groupi.rest.response.TransactionResponse;
import com.iituow.groupi.rest.response.TransactionsResponse;
import com.iituow.groupi.rest.response.base.BaseResponse;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    TransactionsResponse getAllTransactions();

    TransactionResponse getTransaction(Integer id);

    BaseResponse createTransaction(TransactionRequest request);

    BaseResponse updateTransaction(TransactionRequest request, Integer id);

    BaseResponse deleteTransaction(Integer id);
}
