package com.iituow.groupi.database.repository;

import com.iituow.groupi.database.model.DaoBudget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<DaoBudget, Integer> {
}
