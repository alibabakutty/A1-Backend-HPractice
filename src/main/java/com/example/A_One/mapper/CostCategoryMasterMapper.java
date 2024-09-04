package com.example.A_One.mapper;

import com.example.A_One.dto.CostCategoryMasterDto;
import com.example.A_One.entity.CostCategoryMaster;

public class CostCategoryMasterMapper {

    public static CostCategoryMasterDto mapToCostCategoryMasterDto(CostCategoryMaster costCategoryMaster){
        return new CostCategoryMasterDto(
                costCategoryMaster.getId(),
                costCategoryMaster.getCostCategoryName()
        );
    }

    public static CostCategoryMaster mapToCostCategoryMaster(CostCategoryMasterDto costCategoryMasterDto){
        return new CostCategoryMaster(
                costCategoryMasterDto.getId(),
                costCategoryMasterDto.getCostCategoryName()
        );
    }
}