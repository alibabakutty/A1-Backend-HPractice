package com.example.A_One.service.Impl;

import com.example.A_One.dto.BatchSerialNumberMasterDto;
import com.example.A_One.entity.BatchSerialNumberMaster;
import com.example.A_One.exception.ResourceNotFoundException;
import com.example.A_One.mapper.BatchSerialNumberMasterMapper;
import com.example.A_One.repository.BatchSerialNumberMasterDAO;
import com.example.A_One.service.BatchSerialNumberMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BatchSerialNumberMasterServiceImpl implements BatchSerialNumberMasterService {

    @Autowired
    private BatchSerialNumberMasterDAO batchSerialNumberMasterDAO;

    @Override
    public BatchSerialNumberMasterDto createBatchSerialNumberMaster(BatchSerialNumberMasterDto batchSerialNumberMasterDto){
        // validate batch serial number
        validateBatchSerialNumber(batchSerialNumberMasterDto);

        // check duplicate entry for batch serial number
        if (batchSerialNumberMasterDAO.existsByBatchSerialNumber(batchSerialNumberMasterDto.getBatchSerialNumber())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + batchSerialNumberMasterDto.getBatchSerialNumber());
        }

        BatchSerialNumberMaster batchSerialNumberMaster = BatchSerialNumberMasterMapper.mapToBatchSerialNumberMaster(batchSerialNumberMasterDto);
        BatchSerialNumberMaster saveBatchSerialNumberMaster = batchSerialNumberMasterDAO.save(batchSerialNumberMaster);
        return BatchSerialNumberMasterMapper.mapToBatchSerialNumberMasterDto(saveBatchSerialNumberMaster);
    }

    public void validateBatchSerialNumber(BatchSerialNumberMasterDto batchSerialNumberMasterDto){
        if (batchSerialNumberMasterDto.getBatchSerialNumber() == null || batchSerialNumberMasterDto.getBatchSerialNumber().isEmpty()){
            throw new IllegalArgumentException("Batch serial number is unique field cannot be empty!");
        }
    }

    @Override
    public BatchSerialNumberMasterDto getBatchSerialNumber(String batchSerialNumber){
        BatchSerialNumberMaster batchSerialNumberMaster = batchSerialNumberMasterDAO.findByBatchSerialNumber(batchSerialNumber).orElseThrow(()->

                new ResourceNotFoundException("Batch Serial Number is not found with this name:" + batchSerialNumber));

        return BatchSerialNumberMasterMapper.mapToBatchSerialNumberMasterDto(batchSerialNumberMaster);
    }

    @Override
    public List<BatchSerialNumberMasterDto> getAllBatchSerialNumberMaster(){
        List<BatchSerialNumberMaster> batchSerialNumberMaster = batchSerialNumberMasterDAO.findAll();
        return batchSerialNumberMaster.stream().map(BatchSerialNumberMasterMapper::mapToBatchSerialNumberMasterDto).toList();
    }

    @Override
    public BatchSerialNumberMasterDto updateBatchSerialNumberMaster(String batchSerialNumber, BatchSerialNumberMasterDto updatedBatchSerialNumber){
        BatchSerialNumberMaster batchSerialNumberMaster = batchSerialNumberMasterDAO.findByBatchSerialNumber(batchSerialNumber).orElseThrow(() ->

                new ResourceNotFoundException("Batch serial number is not found with this name:" + batchSerialNumber));
        batchSerialNumberMaster.setBatchSerialNumber(updatedBatchSerialNumber.getBatchSerialNumber());
        BatchSerialNumberMaster batchSerialNumberMasterObj = batchSerialNumberMasterDAO.save(batchSerialNumberMaster);
        return BatchSerialNumberMasterMapper.mapToBatchSerialNumberMasterDto(batchSerialNumberMasterObj);
    }

    @Override
    public void deleteByBatchSerialNumberId(Long id){
        BatchSerialNumberMaster batchSerialNumberMaster = batchSerialNumberMasterDAO.findById(id).orElseThrow(()->

                new ResourceNotFoundException("Batch serial number is not found with this id" + id));
        batchSerialNumberMasterDAO.deleteById(id);
    }
}