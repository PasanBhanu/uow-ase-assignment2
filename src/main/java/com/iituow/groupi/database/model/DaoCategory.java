package com.iituow.groupi.database.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CATEGORIES")
public class DaoCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Basic
    @Column(name = "TITLE", length = 255)
    private String title;
}
