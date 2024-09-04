package com.example.A_One.mapper;

import com.example.A_One.dto.BatchSerialNumberMasterDto;
import com.example.A_One.entity.BatchSerialNumberMaster;

public class BatchSerialNumberMasterMapper {

    public static BatchSerialNumberMasterDto mapToBatchSerialNumberMasterDto(BatchSerialNumberMaster batchSerialNumberMaster){
        return new BatchSerialNumberMasterDto(
                batchSerialNumberMaster.getId(),
                batchSerialNumberMaster.getBatchSerialNumber()
        );
    }

    public static BatchSerialNumberMaster mapToBatchSerialNumberMaster(BatchSerialNumberMasterDto batchSerialNumberMasterDto){
        return new BatchSerialNumberMaster(
                batchSerialNumberMasterDto.getId(),
                batchSerialNumberMasterDto.getBatchSerialNumber()
        );
    }
}