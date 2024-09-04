package com.example.A_One.repository;

import com.example.A_One.entity.BatchSerialNumberMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BatchSerialNumberMasterDAO extends JpaRepository<BatchSerialNumberMaster,Long> {
    boolean existsByBatchSerialNumber(String batchSerialNumber);
    Optional<BatchSerialNumberMaster> findByBatchSerialNumber(String batchSerialNumber);
}