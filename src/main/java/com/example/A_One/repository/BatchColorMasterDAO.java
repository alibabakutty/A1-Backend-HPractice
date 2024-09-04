package com.example.A_One.repository;

import com.example.A_One.entity.BatchColorMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BatchColorMasterDAO extends JpaRepository<BatchColorMaster,Long> {
    boolean existsByBatchColorName(String batchColorName);
    Optional<BatchColorMaster> findByBatchColorName(String batchColorName);
}