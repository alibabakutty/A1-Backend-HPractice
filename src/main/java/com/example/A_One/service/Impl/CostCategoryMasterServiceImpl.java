package com.example.A_One.service.Impl;

import com.example.A_One.dto.CostCategoryMasterDto;
import com.example.A_One.entity.CostCategoryMaster;
import com.example.A_One.exception.ResourceNotFoundException;
import com.example.A_One.mapper.CostCategoryMasterMapper;
import com.example.A_One.repository.CostCategoryMasterDAO;
import com.example.A_One.service.CostCategoryMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CostCategoryMasterServiceImpl implements CostCategoryMasterService {

    @Autowired
    private CostCategoryMasterDAO costCategoryMasterDAO;

    @Override
    public CostCategoryMasterDto createCostCategoryMaster(CostCategoryMasterDto costCategoryMasterDto){
        // validate empty field
        validateCostCategoryName(costCategoryMasterDto);

        // check for duplicate entry
        if (costCategoryMasterDAO.existsByCostCategoryName(costCategoryMasterDto.getCostCategoryName())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + costCategoryMasterDto.getCostCategoryName());
        }

        CostCategoryMaster costCategoryMaster = CostCategoryMasterMapper.mapToCostCategoryMaster(costCategoryMasterDto);
        CostCategoryMaster saveCostCategoryMaster = costCategoryMasterDAO.save(costCategoryMaster);
        return CostCategoryMasterMapper.mapToCostCategoryMasterDto(saveCostCategoryMaster);
    }

    public void validateCostCategoryName(CostCategoryMasterDto costCategoryMasterDto){
        if (costCategoryMasterDto.getCostCategoryName() == null || costCategoryMasterDto.getCostCategoryName().isEmpty()){
            throw new IllegalArgumentException("Cost category name is cannot be empty!");
        }
    }

    @Override
    public CostCategoryMasterDto getCostCategoryMaster(String costCategoryName){
        CostCategoryMaster costCategoryMaster = costCategoryMasterDAO.findByCostCategoryName(costCategoryName).orElseThrow(() ->

                new ResourceNotFoundException("Cost category name is not found with this name" + costCategoryName));

        return CostCategoryMasterMapper.mapToCostCategoryMasterDto(costCategoryMaster);
    }

    @Override
    public List<CostCategoryMasterDto> getAllCostCategoryMaster(){
        List<CostCategoryMaster> costCategoryMaster = costCategoryMasterDAO.findAll();
        return costCategoryMaster.stream().map(CostCategoryMasterMapper::mapToCostCategoryMasterDto).toList();
    }

    @Override
    public CostCategoryMasterDto updateCostCategoryMaster(String costCategoryName, CostCategoryMasterDto updateCostCategoryMaster){
        CostCategoryMaster costCategoryMaster = costCategoryMasterDAO.findByCostCategoryName(costCategoryName).orElseThrow(()->

                new ResourceNotFoundException("Cost category name is not found with this name:" + costCategoryName));

        costCategoryMaster.setCostCategoryName(updateCostCategoryMaster.getCostCategoryName());
        CostCategoryMaster costCategoryMasterObj = costCategoryMasterDAO.save(costCategoryMaster);
        return CostCategoryMasterMapper.mapToCostCategoryMasterDto(costCategoryMasterObj);
    }

    @Override
    public void deleteByCostCategoryMaster(Long id){
        CostCategoryMaster costCategoryMaster = costCategoryMasterDAO.findById(id).orElseThrow(()->

                new ResourceNotFoundException("Cost category id is not found with this id:" + id));
        costCategoryMasterDAO.deleteById(id);
    }
}