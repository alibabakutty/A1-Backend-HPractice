package com.example.A_One.mapper;

import com.example.A_One.dto.BatchCategoryMasterDto;
import com.example.A_One.entity.BatchCategoryMaster;

public class BatchCategoryMasterMapper {

    public static BatchCategoryMasterDto maptoBatchCategoryMasterDto(BatchCategoryMaster batchCategoryMaster){
        return new BatchCategoryMasterDto(
                batchCategoryMaster.getId(),
                batchCategoryMaster.getBatchCategoryName()
        );
    }

    public static BatchCategoryMaster mapToBatchCategoryMaster(BatchCategoryMasterDto batchCategoryMasterDto){
        return new BatchCategoryMaster(
                batchCategoryMasterDto.getId(),
                batchCategoryMasterDto.getBatchCategoryName()
        );
    }
}