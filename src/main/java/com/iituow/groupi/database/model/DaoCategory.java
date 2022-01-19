package com.iituow.groupi.database.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CATEGORIES")
public class DaoCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Basic
    @Column(name = "TITLE", length = 255)
    private String title;

    @Basic
    @Column(name = "BUDGET")
    private Double budget = null;
}
