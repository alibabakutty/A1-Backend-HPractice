package com.example.A_One.service.Impl;

import com.example.A_One.dto.BatchCategoryMasterDto;
import com.example.A_One.entity.BatchCategoryMaster;
import com.example.A_One.exception.ResourceNotFoundException;
import com.example.A_One.mapper.BatchCategoryMasterMapper;
import com.example.A_One.repository.BatchCategoryMasterDAO;
import com.example.A_One.service.BatchCategoryMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BatchCategoryMasterServiceImpl implements BatchCategoryMasterService {

    @Autowired
    private BatchCategoryMasterDAO batchCategoryMasterDAO;

    @Override
    public BatchCategoryMasterDto createBatchCategoryMaster(BatchCategoryMasterDto batchCategoryMasterDto){
        // validate batch category name
        validateBatchCategoryName(batchCategoryMasterDto);

        // check duplicate entry
        if (batchCategoryMasterDAO.existsByBatchCategoryName(batchCategoryMasterDto.getBatchCategoryName())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + batchCategoryMasterDto.getBatchCategoryName());
        }

        BatchCategoryMaster batchCategoryMaster = BatchCategoryMasterMapper.mapToBatchCategoryMaster(batchCategoryMasterDto);
        BatchCategoryMaster saveBatchCategoryMaster = batchCategoryMasterDAO.save(batchCategoryMaster);
        return BatchCategoryMasterMapper.maptoBatchCategoryMasterDto(saveBatchCategoryMaster);

    }

    public void validateBatchCategoryName(BatchCategoryMasterDto batchCategoryMasterDto){
        if (batchCategoryMasterDto.getBatchCategoryName() == null || batchCategoryMasterDto.getBatchCategoryName().isEmpty()){
            throw new IllegalArgumentException("Batch category name is unique field cannot be empty!");
        }
    }

    @Override
    public BatchCategoryMasterDto getBatchCategoryName(String batchCategoryName){
        BatchCategoryMaster batchCategoryMaster = batchCategoryMasterDAO.findByBatchCategoryName(batchCategoryName).orElseThrow(() ->

                new ResourceNotFoundException("Batch category name is not found with this name:" + batchCategoryName));

        return BatchCategoryMasterMapper.maptoBatchCategoryMasterDto(batchCategoryMaster);
    }

    @Override
    public List<BatchCategoryMasterDto> getAllBatchCategoryMaster(){
        List<BatchCategoryMaster> batchCategoryMaster = batchCategoryMasterDAO.findAll();
        return batchCategoryMaster.stream().map(BatchCategoryMasterMapper::maptoBatchCategoryMasterDto).toList();
    }
    @Override
    public BatchCategoryMasterDto updateBatchCategoryMaster(String batchCategoryName, BatchCategoryMasterDto updateBatchCategoryMaster){
        BatchCategoryMaster batchCategoryMaster = batchCategoryMasterDAO.findByBatchCategoryName(batchCategoryName).orElseThrow(()->

                new ResourceNotFoundException("Batch category name is not found with this name:" + batchCategoryName));

        batchCategoryMaster.setBatchCategoryName(updateBatchCategoryMaster.getBatchCategoryName());
        BatchCategoryMaster batchCategoryMasterObj = batchCategoryMasterDAO.save(batchCategoryMaster);
        return BatchCategoryMasterMapper.maptoBatchCategoryMasterDto(batchCategoryMasterObj);
    }

    @Override
    public void deleteBatchCategoryMaster(Long id){
        BatchCategoryMaster batchCategoryMaster = batchCategoryMasterDAO.findById(id).orElseThrow(()->

                new ResourceNotFoundException("Batch category name is not found with this id:" + id));
        batchCategoryMasterDAO.deleteById(id);
    }
}