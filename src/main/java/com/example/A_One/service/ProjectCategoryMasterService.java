package com.example.A_One.service;

import com.example.A_One.dto.ProjectCategoryMasterDto;

import java.util.List;

public interface ProjectCategoryMasterService {
    ProjectCategoryMasterDto createProjectCategoryMaster(ProjectCategoryMasterDto projectCategoryMasterDto);

    ProjectCategoryMasterDto getProjectCategoryName(String projectCategoryName);

    List<ProjectCategoryMasterDto> getAllOProjectCategoryMaster();

    ProjectCategoryMasterDto updateProjectCategoryMaster(String projectCategoryName, ProjectCategoryMasterDto updateProjectCategoryMaster);

    void deleteByProjectCategoryMasterId(Long id);
}
