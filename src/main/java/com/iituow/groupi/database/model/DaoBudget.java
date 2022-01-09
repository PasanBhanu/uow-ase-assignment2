package com.iituow.groupi.database.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "BUDGETS")
public class DaoBudget {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Basic
    @Column(name = "CATEGORY_ID")
    private Integer categoryId;

    @Basic
    @Column(name = "AMOUNT")
    private Double amount;
}
