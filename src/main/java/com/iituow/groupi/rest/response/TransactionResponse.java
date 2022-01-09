package com.iituow.groupi.rest.response;

import com.iituow.groupi.service.model.Transaction;
import com.iituow.groupi.rest.response.base.BaseResponse;
import lombok.Data;

@Data
public class TransactionResponse extends BaseResponse {
    private Transaction transaction;
}
