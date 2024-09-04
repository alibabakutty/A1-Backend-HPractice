package com.example.A_One.mapper;

import com.example.A_One.dto.ProjectNameMasterDto;
import com.example.A_One.entity.ProjectNameMaster;

public class ProjectNameMasterMapper {

    public static ProjectNameMasterDto mapToProjectNameMasterDto(ProjectNameMaster projectNameMaster){
        return new ProjectNameMasterDto(
                projectNameMaster.getId(),
                projectNameMaster.getProjectName(),
                projectNameMaster.getProjectCategoryName()
        );
    }

    public static ProjectNameMaster mapToProjectNameMaster(ProjectNameMasterDto projectNameMasterDto){
        return new ProjectNameMaster(
                projectNameMasterDto.getId(),
                projectNameMasterDto.getProjectName(),
                projectNameMasterDto.getProjectCategoryName()
        );
    }
}