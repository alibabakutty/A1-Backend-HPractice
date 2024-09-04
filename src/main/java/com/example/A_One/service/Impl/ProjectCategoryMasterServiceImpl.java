package com.example.A_One.service.Impl;

import com.example.A_One.dto.ProjectCategoryMasterDto;
import com.example.A_One.entity.ProjectCategoryMaster;
import com.example.A_One.exception.ResourceNotFoundException;
import com.example.A_One.mapper.ProjectCategoryMasterMapper;
import com.example.A_One.repository.ProjectCategoryMasterDAO;
import com.example.A_One.service.ProjectCategoryMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProjectCategoryMasterServiceImpl implements ProjectCategoryMasterService {

    @Autowired
    private ProjectCategoryMasterDAO projectCategoryMasterDAO;

    @Override
    public ProjectCategoryMasterDto createProjectCategoryMaster(ProjectCategoryMasterDto projectCategoryMasterDto){
        // validate project category name
        validateProjectCategoryName(projectCategoryMasterDto);

        // check duplicate entry for project category name
        if (projectCategoryMasterDAO.existsByProjectCategoryName(projectCategoryMasterDto.getProjectCategoryName())){
            throw new IllegalArgumentException("Duplicate entry for unique field!" + projectCategoryMasterDto.getProjectCategoryName());
        }

        ProjectCategoryMaster projectCategoryMaster = ProjectCategoryMasterMapper.mapToProjectCategoryMaster(projectCategoryMasterDto);
        ProjectCategoryMaster saveProjectCategoryMaster = projectCategoryMasterDAO.save(projectCategoryMaster);
        return ProjectCategoryMasterMapper.mapToProjectCategoryMasterDto(saveProjectCategoryMaster);
    }

    public void validateProjectCategoryName(ProjectCategoryMasterDto projectCategoryMasterDto){
        if (projectCategoryMasterDto.getProjectCategoryName() == null || projectCategoryMasterDto.getProjectCategoryName().isEmpty()){
            throw new IllegalArgumentException("Project category name is unique field cannot be empty!");
        }
    }

    @Override
    public ProjectCategoryMasterDto getProjectCategoryName(String projectCategoryName){
        ProjectCategoryMaster projectCategoryMaster = projectCategoryMasterDAO.findByProjectCategoryName(projectCategoryName).orElseThrow(() ->

                new ResourceNotFoundException("Project category name is not found with this name:" + projectCategoryName));
        return ProjectCategoryMasterMapper.mapToProjectCategoryMasterDto(projectCategoryMaster);
    }

    @Override
    public List<ProjectCategoryMasterDto> getAllOProjectCategoryMaster(){
        List<ProjectCategoryMaster> projectCategoryMaster = projectCategoryMasterDAO.findAll();
        return projectCategoryMaster.stream().map(ProjectCategoryMasterMapper::mapToProjectCategoryMasterDto).toList();
    }

    @Override
    public ProjectCategoryMasterDto updateProjectCategoryMaster(String projectCategoryName, ProjectCategoryMasterDto updateProjectCategoryMaster){
        ProjectCategoryMaster projectCategoryMaster = projectCategoryMasterDAO.findByProjectCategoryName(projectCategoryName).orElseThrow(()->

                new ResourceNotFoundException("Project category name is not found with this name:" + projectCategoryName));
        projectCategoryMaster.setProjectCategoryName(updateProjectCategoryMaster.getProjectCategoryName());
        ProjectCategoryMaster projectCategoryMasterObj = projectCategoryMasterDAO.save(projectCategoryMaster);
        return ProjectCategoryMasterMapper.mapToProjectCategoryMasterDto(projectCategoryMasterObj);
    }

    @Override
    public void deleteByProjectCategoryMasterId(Long id){
        ProjectCategoryMaster projectCategoryMaster = projectCategoryMasterDAO.findById(id).orElseThrow(() ->

                new ResourceNotFoundException("Project category name is not found with this id:" + id));
        projectCategoryMasterDAO.deleteById(id);

    }
}