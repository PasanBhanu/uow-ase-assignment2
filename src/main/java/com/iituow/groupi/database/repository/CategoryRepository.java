package com.iituow.groupi.database.repository;

import com.iituow.groupi.database.model.DaoCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<DaoCategory, Integer> {
}
