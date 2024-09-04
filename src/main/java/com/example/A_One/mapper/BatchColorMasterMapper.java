package com.example.A_One.mapper;

import com.example.A_One.dto.BatchColorMasterDto;
import com.example.A_One.entity.BatchColorMaster;

public class BatchColorMasterMapper {

    public static BatchColorMasterDto mapToBatchColorMasterDto(BatchColorMaster batchColorMaster){
        return new BatchColorMasterDto(
                batchColorMaster.getId(),
                batchColorMaster.getBatchColorName()
        );
    }

    public static BatchColorMaster mapToBatchColorMaster(BatchColorMasterDto batchColorMasterDto){
        return new BatchColorMaster(
                batchColorMasterDto.getId(),
                batchColorMasterDto.getBatchColorName()
        );
    }
}