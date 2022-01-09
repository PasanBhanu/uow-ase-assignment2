package com.iituow.groupi.service;

import com.iituow.groupi.service.model.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    Category getCategory(Integer id);

    Category createCategory(String title);

    Category updateCategory(Integer id, String title);

    void deleteCategory(Integer id);
}
