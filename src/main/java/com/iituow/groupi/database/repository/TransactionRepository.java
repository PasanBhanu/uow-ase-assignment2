package com.iituow.groupi.database.repository;

import com.iituow.groupi.database.model.DaoTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<DaoTransaction, Integer> {
    List<DaoTransaction> findByCategoryId(Integer categoryId);

    long countByCategoryId(Integer categoryId);

}
