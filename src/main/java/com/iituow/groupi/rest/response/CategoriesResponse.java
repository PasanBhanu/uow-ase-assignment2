package com.iituow.groupi.rest.response;

import com.iituow.groupi.rest.response.base.BaseResponse;
import com.iituow.groupi.service.model.Category;
import lombok.Data;

import java.util.ArrayList;

@Data
public class CategoriesResponse extends BaseResponse {
    private ArrayList<Category> categories;
}
