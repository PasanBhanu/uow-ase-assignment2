package com.iituow.groupi.rest.response;

import com.iituow.groupi.rest.response.base.BaseResponse;
import com.iituow.groupi.service.model.Category;
import com.iituow.groupi.service.model.Transaction;
import lombok.Data;

import java.util.ArrayList;

@Data
public class CategoryResponse extends BaseResponse {
    private Category category;
    private ArrayList<Transaction> transactions;
}
