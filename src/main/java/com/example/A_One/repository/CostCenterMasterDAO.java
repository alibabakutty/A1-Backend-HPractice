package com.example.A_One.repository;

import com.example.A_One.entity.CostCenterMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CostCenterMasterDAO extends JpaRepository<CostCenterMaster,Long> {
    boolean existsByCostCenterName(String costCenterName);
    Optional<CostCenterMaster> findByCostCenterName(String costCenterName);
}