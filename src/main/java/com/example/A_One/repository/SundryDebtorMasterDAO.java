package com.example.A_One.repository;

import com.example.A_One.entity.SundryDebtorMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SundryDebtorMasterDAO extends JpaRepository<SundryDebtorMaster,Long> {
    boolean existsBySundryDebtorName(String sundryDebtorName);
    Optional<SundryDebtorMaster> findBySundryDebtorName(String sundryDebtorName);
}