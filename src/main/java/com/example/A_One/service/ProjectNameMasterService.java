package com.example.A_One.service;

import com.example.A_One.dto.ProjectNameMasterDto;

import java.util.List;

public interface ProjectNameMasterService {
    ProjectNameMasterDto createProjectNameMaster(ProjectNameMasterDto projectNameMasterDto);

    ProjectNameMasterDto getProjectName(String projectName);

    List<ProjectNameMasterDto> getAllProjectNameMaster();

    ProjectNameMasterDto updateProjectNameMaster(String projectName, ProjectNameMasterDto updateProjectName);

    void deleteByProjectNameMasterId(Long id);
}
