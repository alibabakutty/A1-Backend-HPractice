package com.example.A_One.repository;

import com.example.A_One.entity.LocationMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationMasterDAO extends JpaRepository<LocationMaster,Long> {
    boolean existsByGodownName(String godownName);
    Optional<LocationMaster> findByGodownName(String godownName);
}