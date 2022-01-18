package com.iituow.groupi.database.repository;

import com.iituow.groupi.database.model.DaoTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionRepository extends JpaRepository<DaoTransaction, Integer> {
    List<DaoTransaction> findByCategoryId(Integer categoryId);

    long countByCategoryId(Integer categoryId);

    @Query(value = "SELECT SUM(AMOUNT) AS TOTAL FROM TRANSACTIONS WHERE TYPE = 1 AND CATEGORY_ID = ?1", nativeQuery = true)
    BigDecimal getTotalExpenseByCategoryId(Integer categoryId);

    @Query(value = "SELECT SUM(AMOUNT) AS TOTAL FROM TRANSACTIONS WHERE TYPE = 2 AND CATEGORY_ID = ?1", nativeQuery = true)
    BigDecimal getTotalIncomeByCategoryId(Integer categoryId);

    @Query(value = "SELECT SUM(AMOUNT) AS TOTAL FROM TRANSACTIONS WHERE TYPE = 1", nativeQuery = true)
    BigDecimal getTotalExpense();

    @Query(value = "SELECT SUM(AMOUNT) AS TOTAL FROM TRANSACTIONS WHERE TYPE = 2", nativeQuery = true)
    BigDecimal getTotalIncome();
}
