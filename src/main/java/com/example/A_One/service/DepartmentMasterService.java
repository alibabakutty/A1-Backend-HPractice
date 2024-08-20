package com.example.A_One.service;

import com.example.A_One.dto.DepartmentMasterDto;

import java.util.List;

public interface DepartmentMasterService {
    DepartmentMasterDto createDepartmentMaster(DepartmentMasterDto departmentMasterDto);

    DepartmentMasterDto getDepartmentName(String departmentName);

    List<DepartmentMasterDto> getAllDepartmentMaster();

    void deleteByDepartmentMaster(Long id);
}
