package com.example.A_One.repository;

import com.example.A_One.entity.PreDefinedVoucherType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PreDefinedVoucherTypeDAO extends JpaRepository<PreDefinedVoucherType,Long> {
    boolean existsByVoucherType(String voucherType);
    Optional<PreDefinedVoucherType> findByVoucherType(String voucherType);
}
