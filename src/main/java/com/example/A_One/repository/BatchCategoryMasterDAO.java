package com.example.A_One.repository;

import com.example.A_One.entity.BatchCategoryMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BatchCategoryMasterDAO extends JpaRepository<BatchCategoryMaster,Long> {
    boolean existsByBatchCategoryName(String batchCategoryName);
    Optional<BatchCategoryMaster> findByBatchCategoryName(String batchCategoryName);
}