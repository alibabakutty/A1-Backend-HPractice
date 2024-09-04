package com.example.A_One.repository;

import com.example.A_One.entity.ProjectNameMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectNameMasterDAO extends JpaRepository<ProjectNameMaster,Long> {
    boolean existsByProjectName(String projectName);
    Optional<ProjectNameMaster> findByProjectName(String projectName);
}