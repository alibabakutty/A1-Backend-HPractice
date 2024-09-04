package com.example.A_One.repository;

import com.example.A_One.entity.BatchSizeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BatchSizeMasterDAO extends JpaRepository<BatchSizeMaster,Long> {
    boolean existsByBatchSizeName(String batchSizeName);
    Optional<BatchSizeMaster> findByBatchSizeName(String batchSizeName);
}