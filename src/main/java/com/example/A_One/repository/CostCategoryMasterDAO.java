package com.example.A_One.repository;

import com.example.A_One.entity.CostCategoryMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CostCategoryMasterDAO extends JpaRepository<CostCategoryMaster,Long> {
    boolean existsByCostCategoryName(String costCategoryName);
    Optional<CostCategoryMaster> findByCostCategoryName(String costCategoryName);
}