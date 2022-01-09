package com.iituow.groupi.rest.response;

import com.iituow.groupi.service.model.Transaction;
import com.iituow.groupi.rest.response.base.BaseResponse;
import lombok.Data;

import java.util.ArrayList;

@Data
public class TransactionsResponse extends BaseResponse {
    private ArrayList<Transaction> transactions;
}
