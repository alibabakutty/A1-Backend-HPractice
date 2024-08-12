package com.example.A_One.repository;

import com.example.A_One.entity.VoucherTypeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoucherTypeMaterDAO extends JpaRepository<VoucherTypeMaster,Long> {
    boolean existsByVoucherTypeName(String voucherTypeName);
    Optional<VoucherTypeMaster> findByVoucherTypeName(String voucherTypeName);
}
