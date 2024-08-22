package com.example.A_One.service.Impl;

import com.example.A_One.dto.BranchOfficeMasterDto;
import com.example.A_One.entity.BranchOfficeMaster;
import com.example.A_One.exception.ResourceNotFoundException;
import com.example.A_One.mapper.BranchOfficeMasterMapper;
import com.example.A_One.repository.BranchOfficeMasterDAO;
import com.example.A_One.service.BranchOfficeMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BranchOfficeMasterServiceImpl implements BranchOfficeMasterService {

    @Autowired
    private BranchOfficeMasterDAO branchOfficeMasterDAO;

    @Override
    public BranchOfficeMasterDto createBranchOfficeMaster(BranchOfficeMasterDto branchOfficeMasterDto){
        // validate head office object
        validateBranchOfficeName(branchOfficeMasterDto);

        // check for duplicate entry
        if (branchOfficeMasterDAO.existsByBranchOfficeName(branchOfficeMasterDto.getBranchOfficeName())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + branchOfficeMasterDto.getBranchOfficeName());
        }

        BranchOfficeMaster branchOfficeMaster = BranchOfficeMasterMapper.mapToBranchOfficeMaster(branchOfficeMasterDto);
        BranchOfficeMaster saveBranchOfficeMaster = branchOfficeMasterDAO.save(branchOfficeMaster);
        return BranchOfficeMasterMapper.mapToBranchOfficeMasterDto(saveBranchOfficeMaster);
    }

    public void validateBranchOfficeName(BranchOfficeMasterDto branchOfficeMasterDto){
        if (branchOfficeMasterDto.getBranchOfficeName() == null || branchOfficeMasterDto.getBranchOfficeName().isEmpty()){
            throw new  IllegalArgumentException("Branch Office Name field cannot be empty!");
        }
    }

    @Override
    public BranchOfficeMasterDto getBranchOfficeMaster(String branchOfficeName){
        BranchOfficeMaster branchOfficeMaster = branchOfficeMasterDAO.findByBranchOfficeName(branchOfficeName).orElseThrow(() ->

                new ResourceNotFoundException("Branch Office Name is not found with this name:" + branchOfficeName));

        return BranchOfficeMasterMapper.mapToBranchOfficeMasterDto(branchOfficeMaster);
    }

    @Override
    public List<BranchOfficeMasterDto> getAllBranchOfficeMaster(){
        List<BranchOfficeMaster> branchOfficeMaster = branchOfficeMasterDAO.findAll();
        return branchOfficeMaster.stream().map(BranchOfficeMasterMapper::mapToBranchOfficeMasterDto).toList();
    }

    @Override
    public BranchOfficeMasterDto updateBranchOfficeMaster(String branchOfficeName, BranchOfficeMasterDto updateBranchOfficeMaster){
        BranchOfficeMaster branchOfficeMaster = branchOfficeMasterDAO.findByBranchOfficeName(branchOfficeName).orElseThrow(() ->

                new ResourceNotFoundException("Branch Office Name is not found with this name:" +branchOfficeName));

        branchOfficeMaster.setBranchOfficeName(updateBranchOfficeMaster.getBranchOfficeName());
        BranchOfficeMaster branchOfficeMasterObj = branchOfficeMasterDAO.save(branchOfficeMaster);
        return BranchOfficeMasterMapper.mapToBranchOfficeMasterDto(branchOfficeMasterObj);
    }

    @Override
    public void deleteByBranchOfficeMaster(Long id){
        BranchOfficeMaster branchOfficeMaster = branchOfficeMasterDAO.findById(id).orElseThrow(() ->

                new ResourceNotFoundException("Branch Office Name is not found with this name:" + id));

        branchOfficeMasterDAO.deleteById(id);
    }
}