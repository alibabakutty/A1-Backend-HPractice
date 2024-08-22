package com.example.A_One.repository;

import com.example.A_One.entity.RevenueCenterMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RevenueCenterMasterDAO extends JpaRepository<RevenueCenterMaster,Long> {
    boolean existsByRevenueCenterName(String revenueCenterName);
    Optional<RevenueCenterMaster> findByRevenueCenterName(String revenueCenterName);
}