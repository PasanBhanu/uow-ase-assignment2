package com.iituow.groupi.database.repository;

import com.iituow.groupi.database.model.DaoTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<DaoTransaction, Integer> {
    List<DaoTransaction> findByCategoryId(Integer categoryId);

    long countByCategoryId(Integer categoryId);

    @Query("SELECT SUM(AMOUNT) AS TOTAL FROM TRANSACTIONS WHERE TYPE = 1 AND CATEGORY_ID = ?1")
    String getTotalExpenseByCategoryId(Integer categoryId);

    @Query("SELECT SUM(AMOUNT) AS TOTAL FROM TRANSACTIONS WHERE TYPE = 2 AND CATEGORY_ID = ?1")
    String getTotalIncomeByCategoryId(Integer categoryId);
}
