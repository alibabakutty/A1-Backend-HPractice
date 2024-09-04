package com.example.A_One.service;

import com.example.A_One.dto.BatchColorMasterDto;

import java.util.List;

public interface BatchColorMasterService {
    BatchColorMasterDto createBatchColorMaster(BatchColorMasterDto batchColorMasterDto);

    BatchColorMasterDto getBatchColorName(String batchColorName);

    List<BatchColorMasterDto> getAllBatchColorMaster();

    BatchColorMasterDto updateBatchColorMaster(String batchColorName, BatchColorMasterDto updateBatchColorMaster);

    void deleteByBatchColorNameId(Long id);
}
