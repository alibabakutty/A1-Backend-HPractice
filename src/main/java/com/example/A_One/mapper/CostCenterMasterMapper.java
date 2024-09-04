package com.example.A_One.mapper;

import com.example.A_One.dto.CostCenterMasterDto;
import com.example.A_One.entity.CostCenterMaster;

public class CostCenterMasterMapper {

    public static CostCenterMasterDto mapToCostCenterMasterDto(CostCenterMaster costCenterMaster){
        return new CostCenterMasterDto(
                costCenterMaster.getId(),
                costCenterMaster.getCostCenterName(),
                costCenterMaster.getCostCategoryName()
        );
    }

    public static CostCenterMaster mapToCostCenterMaster(CostCenterMasterDto costCenterMasterDto){
        return new CostCenterMaster(
                costCenterMasterDto.getId(),
                costCenterMasterDto.getCostCenterName(),
                costCenterMasterDto.getCostCategoryName()
        );
    }
}