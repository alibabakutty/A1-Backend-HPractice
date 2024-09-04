package com.example.A_One.service.Impl;

import com.example.A_One.dto.ProjectNameMasterDto;
import com.example.A_One.entity.ProjectNameMaster;
import com.example.A_One.exception.ResourceNotFoundException;
import com.example.A_One.mapper.ProjectNameMasterMapper;
import com.example.A_One.repository.ProjectNameMasterDAO;
import com.example.A_One.service.ProjectNameMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProjectNameMasterServiceImpl implements ProjectNameMasterService {

    @Autowired
    private ProjectNameMasterDAO projectNameMasterDAO;

    @Override
    public ProjectNameMasterDto createProjectNameMaster(ProjectNameMasterDto projectNameMasterDto){
        // validate project name
        validateProjectName(projectNameMasterDto);

        // check for duplicate entry for project name
        if (projectNameMasterDAO.existsByProjectName(projectNameMasterDto.getProjectName())){
            throw new IllegalArgumentException("Duplicate entry for unique field:" + projectNameMasterDto.getProjectName());
        }

        ProjectNameMaster projectNameMaster = ProjectNameMasterMapper.mapToProjectNameMaster(projectNameMasterDto);
        ProjectNameMaster saveProjectNameMaster = projectNameMasterDAO.save(projectNameMaster);
        return ProjectNameMasterMapper.mapToProjectNameMasterDto(saveProjectNameMaster);

    }

    public void validateProjectName(ProjectNameMasterDto projectNameMasterDto){
        if (projectNameMasterDto.getProjectName() == null || projectNameMasterDto.getProjectCategoryName().isEmpty()){
            throw new IllegalArgumentException("Project name is unique cannot be empty!");
        }
    }

    @Override
    public ProjectNameMasterDto getProjectName(String projectName){
        ProjectNameMaster projectNameMaster = projectNameMasterDAO.findByProjectName(projectName).orElseThrow(()->

                new ResourceNotFoundException("Project name is not found with this name:" + projectName));
        return ProjectNameMasterMapper.mapToProjectNameMasterDto(projectNameMaster);
    }

    @Override
    public List<ProjectNameMasterDto> getAllProjectNameMaster(){
        List<ProjectNameMaster> projectNameMaster = projectNameMasterDAO.findAll();
        return projectNameMaster.stream().map(ProjectNameMasterMapper::mapToProjectNameMasterDto).toList();
    }

    @Override
    public ProjectNameMasterDto updateProjectNameMaster(String projectName, ProjectNameMasterDto updateProjectName){
        ProjectNameMaster projectNameMaster = projectNameMasterDAO.findByProjectName(projectName).orElseThrow(() ->

                new ResourceNotFoundException("Project name is not found with this name:" + projectName));
        projectNameMaster.setProjectName(updateProjectName.getProjectName());
        projectNameMaster.setProjectCategoryName(updateProjectName.getProjectCategoryName());
        ProjectNameMaster projectNameMasterObj = projectNameMasterDAO.save(projectNameMaster);
        return ProjectNameMasterMapper.mapToProjectNameMasterDto(projectNameMasterObj);

    }

    @Override
    public void deleteByProjectNameMasterId(Long id){
        ProjectNameMaster projectNameMaster = projectNameMasterDAO.findById(id).orElseThrow(() ->

                new ResourceNotFoundException("Project name is not found with this id:" + id));
        // Log information before deletion
        System.out.println("Deleting Project Name Master: " + projectNameMaster.getProjectName() + " with ID: " + id);
        projectNameMasterDAO.deleteById(id);
    }
}