package com.iituow.groupi.database.repository;

import com.iituow.groupi.database.model.DaoCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface CategoryRepository extends JpaRepository<DaoCategory, Integer> {
    @Query(value = "SELECT SUM(BUDGET) AS TOTAL FROM CATEGORIES", nativeQuery = true)
    BigDecimal getTotalBudget();
}
