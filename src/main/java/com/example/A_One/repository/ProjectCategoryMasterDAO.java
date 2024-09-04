package com.example.A_One.repository;

import com.example.A_One.entity.ProjectCategoryMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectCategoryMasterDAO extends JpaRepository<ProjectCategoryMaster,Long> {
    boolean existsByProjectCategoryName(String projectCategoryName);
    Optional<ProjectCategoryMaster> findByProjectCategoryName(String projectCategoryName);
}