package com.example.A_One.mapper;

import com.example.A_One.dto.BatchSizeMasterDto;
import com.example.A_One.entity.BatchSizeMaster;

public class BatchSizeMasterMapper {
    public static BatchSizeMasterDto mapToBatchSizeMasterDto(BatchSizeMaster batchSizeMaster){
        return new BatchSizeMasterDto(
                batchSizeMaster.getId(),
                batchSizeMaster.getBatchSizeName()
        );
    }

    public static BatchSizeMaster mapToBatchSizeMaster(BatchSizeMasterDto batchSizeMasterDto){
        return new BatchSizeMaster(
                batchSizeMasterDto.getId(),
                batchSizeMasterDto.getBatchSizeName()
        );
    }
}