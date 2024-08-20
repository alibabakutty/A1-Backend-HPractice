package com.example.A_One.repository;

import com.example.A_One.entity.DepartmentMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentMasterDAO extends JpaRepository<DepartmentMaster,Long> {
    boolean existsByDepartmentName(String departmentName);
    Optional<DepartmentMaster> findByDepartmentName(String departmentName);
}