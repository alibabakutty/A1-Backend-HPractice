package com.example.A_One.mapper;

import com.example.A_One.dto.DepartmentMasterDto;
import com.example.A_One.entity.DepartmentMaster;

public class DepartmentMasterMapper {

    public static DepartmentMasterDto mapToDepartmentMasterDto(DepartmentMaster departmentMaster){
        return new DepartmentMasterDto(
                departmentMaster.getId(),
                departmentMaster.getDepartmentName()
        );
    }

    public static DepartmentMaster mapToDepartmentMaster(DepartmentMasterDto departmentMasterDto){
        return new DepartmentMaster(
                departmentMasterDto.getId(),
                departmentMasterDto.getDepartmentName()
        );
    }
}