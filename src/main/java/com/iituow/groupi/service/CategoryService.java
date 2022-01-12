package com.iituow.groupi.service;

import com.iituow.groupi.rest.request.CategoryRequest;
import com.iituow.groupi.rest.response.CategoriesResponse;
import com.iituow.groupi.rest.response.CategoryResponse;
import com.iituow.groupi.rest.response.base.BaseResponse;

public interface CategoryService {
    CategoriesResponse getAllCategories();

    CategoryResponse getCategory(Integer id);

    BaseResponse createCategory(CategoryRequest payload);

    BaseResponse updateCategory(CategoryRequest payload, Integer id);

    BaseResponse deleteCategory(Integer id);
}
