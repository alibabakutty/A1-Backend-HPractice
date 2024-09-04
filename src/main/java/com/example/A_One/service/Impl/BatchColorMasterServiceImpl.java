package com.example.A_One.service.Impl;

import com.example.A_One.dto.BatchColorMasterDto;
import com.example.A_One.entity.BatchColorMaster;
import com.example.A_One.exception.ResourceNotFoundException;
import com.example.A_One.mapper.BatchColorMasterMapper;
import com.example.A_One.repository.BatchColorMasterDAO;
import com.example.A_One.service.BatchColorMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BatchColorMasterServiceImpl implements BatchColorMasterService {

    @Autowired
    private BatchColorMasterDAO batchColorMasterDAO;

    @Override
    public BatchColorMasterDto createBatchColorMaster(BatchColorMasterDto batchColorMasterDto){
        // validate batch color name
        validateBatchColorName(batchColorMasterDto);

        // check duplicate entry for batch color name
        if (batchColorMasterDAO.existsByBatchColorName(batchColorMasterDto.getBatchColorName())){
            throw new DuplicateKeyException("Duplicate entry for unique field!");
        }

        BatchColorMaster batchColorMaster = BatchColorMasterMapper.mapToBatchColorMaster(batchColorMasterDto);
        BatchColorMaster saveBatchColorMaster = batchColorMasterDAO.save(batchColorMaster);
        return BatchColorMasterMapper.mapToBatchColorMasterDto(saveBatchColorMaster);
    }

    public void validateBatchColorName(BatchColorMasterDto batchColorMasterDto){
        if (batchColorMasterDto.getBatchColorName() == null || batchColorMasterDto.getBatchColorName().isEmpty()){
            throw new IllegalArgumentException("Batch color name is unique field cannot be empty!");
        }
    }

    @Override
    public BatchColorMasterDto getBatchColorName(String batchColorName){
        BatchColorMaster batchColorMaster = batchColorMasterDAO.findByBatchColorName(batchColorName).orElseThrow(()->

                new ResourceNotFoundException("Batch color name is not found with this name:" + batchColorName));
        return BatchColorMasterMapper.mapToBatchColorMasterDto(batchColorMaster);
    }

    @Override
    public List<BatchColorMasterDto> getAllBatchColorMaster(){
        List<BatchColorMaster> batchColorMaster = batchColorMasterDAO.findAll();
        return batchColorMaster.stream().map(BatchColorMasterMapper::mapToBatchColorMasterDto).toList();
    }

    @Override
    public BatchColorMasterDto updateBatchColorMaster(String batchColorName, BatchColorMasterDto updateBatchColorMaster){
        BatchColorMaster batchColorMaster = batchColorMasterDAO.findByBatchColorName(batchColorName).orElseThrow(() ->

                new ResourceNotFoundException("Batch color master name is not found with this name:" + batchColorName));

        batchColorMaster.setBatchColorName(updateBatchColorMaster.getBatchColorName());
        BatchColorMaster batchColorMasterObj = batchColorMasterDAO.save(batchColorMaster);
        return BatchColorMasterMapper.mapToBatchColorMasterDto(batchColorMasterObj);
    }

    @Override
    public void deleteByBatchColorNameId(Long id){
        BatchColorMaster batchCategoryMaster = batchColorMasterDAO.findById(id).orElseThrow(() ->

                new ResourceNotFoundException("Batch color name is not found with this id:" + id));
        batchColorMasterDAO.deleteById(id);
    }
}