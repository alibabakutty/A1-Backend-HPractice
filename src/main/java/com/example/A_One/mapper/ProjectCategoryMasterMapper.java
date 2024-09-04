package com.example.A_One.mapper;

import com.example.A_One.dto.ProjectCategoryMasterDto;
import com.example.A_One.entity.ProjectCategoryMaster;

public class ProjectCategoryMasterMapper {
    public static ProjectCategoryMasterDto mapToProjectCategoryMasterDto(ProjectCategoryMaster projectCategoryMaster){
        return new ProjectCategoryMasterDto(
                projectCategoryMaster.getId(),
                projectCategoryMaster.getProjectCategoryName()
        );
    }

    public static ProjectCategoryMaster mapToProjectCategoryMaster(ProjectCategoryMasterDto projectCategoryMasterDto){
        return new ProjectCategoryMaster(
                projectCategoryMasterDto.getId(),
                projectCategoryMasterDto.getProjectCategoryName()
        );
    }
}