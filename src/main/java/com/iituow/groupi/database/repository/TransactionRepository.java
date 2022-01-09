package com.iituow.groupi.database.repository;

import com.iituow.groupi.database.model.DaoTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<DaoTransaction, Integer> {
}
