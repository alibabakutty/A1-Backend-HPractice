package com.example.A_One.repository;

import com.example.A_One.entity.RevenueCategoryMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RevenueCategoryMasterDAO extends JpaRepository<RevenueCategoryMaster,Long> {
    boolean existsByRevenueCategoryName(String revenueCategoryName);
    Optional<RevenueCategoryMaster> findByRevenueCategoryName(String revenueCategoryName);
}