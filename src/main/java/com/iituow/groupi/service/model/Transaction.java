package com.iituow.groupi.service.model;

import com.iituow.groupi.database.model.DaoTransaction;
import com.iituow.groupi.util.TransactionType;
import lombok.Data;

@Data
public class Transaction {
    private Integer id;
    private TransactionType type;
    private Integer categoryId;
    private String categoryName;
    private String description;
    private Double amount;

    public Transaction(DaoTransaction dao) {
        this.id = dao.getId();
        this.type = dao.getType() == 1 ? TransactionType.Income : TransactionType.Expense;
        this.categoryId = dao.getCategoryId();
        this.categoryName = dao.getCategory().getTitle();
        this.description = dao.getDescription();
        this.amount = dao.getAmount();
    }
}
