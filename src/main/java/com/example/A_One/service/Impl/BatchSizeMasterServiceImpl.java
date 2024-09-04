package com.example.A_One.service.Impl;

import com.example.A_One.dto.BatchSizeMasterDto;
import com.example.A_One.entity.BatchSizeMaster;
import com.example.A_One.exception.ResourceNotFoundException;
import com.example.A_One.mapper.BatchSizeMasterMapper;
import com.example.A_One.repository.BatchSizeMasterDAO;
import com.example.A_One.service.BatchSizeMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BatchSizeMasterServiceImpl implements BatchSizeMasterService {

    @Autowired
    private BatchSizeMasterDAO batchSizeMasterDAO;

    @Override
    public BatchSizeMasterDto createBatchSizeMaster(BatchSizeMasterDto batchSizeMasterDto){
        // validate batch size name
        validateBatchSizeName(batchSizeMasterDto);

        // check for duplicate entry for batch size name
        if (batchSizeMasterDAO.existsByBatchSizeName(batchSizeMasterDto.getBatchSizeName())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + batchSizeMasterDto.getBatchSizeName());
        }

        BatchSizeMaster batchSizeMaster = BatchSizeMasterMapper.mapToBatchSizeMaster(batchSizeMasterDto);
        BatchSizeMaster saveBatchSizeMaster = batchSizeMasterDAO.save(batchSizeMaster);
        return BatchSizeMasterMapper.mapToBatchSizeMasterDto(saveBatchSizeMaster);
    }

    public void validateBatchSizeName(BatchSizeMasterDto batchSizeMasterDto){
        if (batchSizeMasterDto.getBatchSizeName() == null || batchSizeMasterDto.getBatchSizeName().isEmpty()){
            throw new IllegalArgumentException("Batch size name is unique field cannot be empty!");
        }
    }

    @Override
    public BatchSizeMasterDto getBatchSizeName(String batchSizeName){
        BatchSizeMaster batchSizeMaster = batchSizeMasterDAO.findByBatchSizeName(batchSizeName).orElseThrow(() ->

                new ResourceNotFoundException("Batch size name is not found with this name:" + batchSizeName));
        return BatchSizeMasterMapper.mapToBatchSizeMasterDto(batchSizeMaster);
    }

    @Override
    public List<BatchSizeMasterDto> getAllBatchSizeMaster(){
        List<BatchSizeMaster> batchSizeMaster = batchSizeMasterDAO.findAll();
        return batchSizeMaster.stream().map(BatchSizeMasterMapper::mapToBatchSizeMasterDto).toList();
    }

    @Override
    public BatchSizeMasterDto updateBatchSizeMaster(String batchSizeName, BatchSizeMasterDto updateBatchSizeMaster){
        BatchSizeMaster batchSizeMaster = batchSizeMasterDAO.findByBatchSizeName(batchSizeName).orElseThrow(() ->

                new ResourceNotFoundException("Batch size name is not found with this name:" + batchSizeName));
        batchSizeMaster.setBatchSizeName(updateBatchSizeMaster.getBatchSizeName());
        BatchSizeMaster batchSizeMasterObj = batchSizeMasterDAO.save(batchSizeMaster);
        return BatchSizeMasterMapper.mapToBatchSizeMasterDto(batchSizeMasterObj);
    }

    @Override
    public void deleteByBatchSizeMaster(Long id){
        BatchSizeMaster batchSizeMaster = batchSizeMasterDAO.findById(id).orElseThrow(() ->

                new ResourceNotFoundException("Batch size name is not found with this id" + id));
        batchSizeMasterDAO.deleteById(id);
    }
}