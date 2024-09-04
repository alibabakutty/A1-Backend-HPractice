package com.example.A_One.service;

import com.example.A_One.dto.CostCategoryMasterDto;

import java.util.List;

public interface CostCategoryMasterService {
    CostCategoryMasterDto createCostCategoryMaster(CostCategoryMasterDto costCategoryMasterDto);

    CostCategoryMasterDto getCostCategoryMaster(String costCategoryName);

    List<CostCategoryMasterDto> getAllCostCategoryMaster();

    CostCategoryMasterDto updateCostCategoryMaster(String costCategoryName, CostCategoryMasterDto updateCostCategoryMaster);

    void deleteByCostCategoryMaster(Long id);
}
