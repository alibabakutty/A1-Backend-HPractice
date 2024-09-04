package com.example.A_One.repository;

import com.example.A_One.entity.SundryCreditorMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SundryCreditorMasterDAO extends JpaRepository<SundryCreditorMaster,Long> {
    boolean existsBySundryCreditorName(String sundryCreditorName);
    Optional<SundryCreditorMaster> findBySundryCreditorName(String sundryCreditorName);
}