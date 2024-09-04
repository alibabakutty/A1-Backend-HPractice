package com.example.A_One.service;

import com.example.A_One.dto.CostCenterMasterDto;

import java.util.List;

public interface CostCenterMasterService {
    CostCenterMasterDto createCostCenterMaster(CostCenterMasterDto costCenterMasterDto);

    CostCenterMasterDto getCostCenterMaster(String costCenterName);

    List<CostCenterMasterDto> getAllCostCenterMaster();

    CostCenterMasterDto updateCostCenterMaster(String costCenterName, CostCenterMasterDto updatedCostCenterMaster);

    void deleteByCostCenterMaster(Long id);
}
