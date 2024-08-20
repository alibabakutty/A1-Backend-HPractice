package com.example.A_One.repository;

import com.example.A_One.entity.CurrencyMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyMasterDAO extends JpaRepository<CurrencyMaster,Long> {
    boolean existsByForexCurrencySymbol(String forexCurrencySymbol);
    Optional<CurrencyMaster> findByForexCurrencySymbol(String forexCurrencySymbol);
}