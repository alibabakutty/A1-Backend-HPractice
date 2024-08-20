package com.example.A_One.service.Impl;

import com.example.A_One.dto.DepartmentMasterDto;
import com.example.A_One.entity.DepartmentMaster;
import com.example.A_One.exception.ResourceNotFoundException;
import com.example.A_One.mapper.DepartmentMasterMapper;
import com.example.A_One.repository.DepartmentMasterDAO;
import com.example.A_One.service.DepartmentMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentMasterServiceImpl implements DepartmentMasterService {

    @Autowired
    private DepartmentMasterDAO departmentMasterDAO;

    @Override
    public DepartmentMasterDto createDepartmentMaster(DepartmentMasterDto departmentMasterDto){

        //validate currency symbol object
        validateDepartmentMaster(departmentMasterDto);

        //check for duplicate entry
        if (departmentMasterDAO.existsByDepartmentName(departmentMasterDto.getDepartmentName())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + departmentMasterDto.getDepartmentName());
        }

        DepartmentMaster departmentMaster = DepartmentMasterMapper.mapToDepartmentMaster(departmentMasterDto);
        DepartmentMaster saveDepartmentMaster = departmentMasterDAO.save(departmentMaster);
        return DepartmentMasterMapper.mapToDepartmentMasterDto(saveDepartmentMaster);
    }

    private void validateDepartmentMaster(DepartmentMasterDto departmentMasterDto){
        if (departmentMasterDto.getDepartmentName() == null || departmentMasterDto.getDepartmentName().isEmpty()){
            throw new IllegalArgumentException("Department field cannot be empty!");
        }
    }

    @Override
    public DepartmentMasterDto getDepartmentName(String departmentName){
        DepartmentMaster departmentMaster = departmentMasterDAO.findByDepartmentName(departmentName).orElseThrow(()->

                new ResourceNotFoundException("Department name is not found with this name:" + departmentName));

        return DepartmentMasterMapper.mapToDepartmentMasterDto(departmentMaster);
    }

    @Override
    public List<DepartmentMasterDto> getAllDepartmentMaster(){
        List<DepartmentMaster> departmentMaster = departmentMasterDAO.findAll();
        return departmentMaster.stream().map(DepartmentMasterMapper::mapToDepartmentMasterDto).toList();
    }
    @Override
    public void deleteByDepartmentMaster(Long id){
        DepartmentMaster departmentMaster = departmentMasterDAO.findById(id).orElseThrow(()->

                new ResourceNotFoundException("Department name is not found with this name:" + id));
        departmentMasterDAO.deleteById(id);
    }
}