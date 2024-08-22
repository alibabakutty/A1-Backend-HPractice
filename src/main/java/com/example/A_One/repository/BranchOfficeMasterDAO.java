package com.example.A_One.repository;

import com.example.A_One.entity.BranchOfficeMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BranchOfficeMasterDAO extends JpaRepository<BranchOfficeMaster,Long> {
    boolean existsByBranchOfficeName(String branchOfficeName);
    Optional<BranchOfficeMaster> findByBranchOfficeName(String branchOfficeName);
}