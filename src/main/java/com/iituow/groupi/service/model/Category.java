package com.iituow.groupi.service.model;

import com.iituow.groupi.database.model.DaoCategory;
import lombok.Data;

@Data
public class Category {
    private Integer id;
    private String title;
    private Double budget;

    public Category (DaoCategory dao){
        this.id = dao.getId();
        this.title = dao.getTitle();
        this.budget = dao.getBudget();
    }
}