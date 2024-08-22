package com.example.A_One.repository;

import com.example.A_One.entity.HeadOfficeMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HeadOfficeMasterDAO extends JpaRepository<HeadOfficeMaster,Long> {
    boolean existsByHeadOfficeName(String headOfficeName);
    Optional<HeadOfficeMaster> findByHeadOfficeName(String headOfficeName);
}