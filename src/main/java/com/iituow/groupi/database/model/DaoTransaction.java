package com.iituow.groupi.database.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TRANSACTIONS")
public class DaoTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Basic
    @Column(name = "TYPE")
    private Integer type;

    @Basic
    @Column(name = "CATEGORY_ID")
    private Integer categoryId;

    @Basic
    @Column(name = "DESCRIPTION", length = 255)
    private String description;

    @Basic
    @Column(name = "AMOUNT")
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private DaoCategory category;
}
