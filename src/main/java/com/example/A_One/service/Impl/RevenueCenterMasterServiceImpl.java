package com.example.A_One.service.Impl;

import com.example.A_One.dto.RevenueCenterMasterDto;
import com.example.A_One.entity.RevenueCenterMaster;
import com.example.A_One.exception.ResourceNotFoundException;
import com.example.A_One.mapper.RevenueCenterMasterMapper;
import com.example.A_One.repository.RevenueCenterMasterDAO;
import com.example.A_One.service.RevenueCenterMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RevenueCenterMasterServiceImpl implements RevenueCenterMasterService {

    @Autowired
    private RevenueCenterMasterDAO revenueCenterMasterDAO;

    @Override
    public RevenueCenterMasterDto createRevenueCenterMaster(RevenueCenterMasterDto revenueCenterMasterDto){

        // validate head office object
        validateRevenueCenterName(revenueCenterMasterDto);

        // check duplicate entry
        if (revenueCenterMasterDAO.existsByRevenueCenterName(revenueCenterMasterDto.getRevenueCenterName())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + revenueCenterMasterDto.getRevenueCenterName());
        }

        RevenueCenterMaster revenueCenterMaster = RevenueCenterMasterMapper.mapToRevenueCenterMaster(revenueCenterMasterDto);
        RevenueCenterMaster saveRevenueCenterMaster = revenueCenterMasterDAO.save(revenueCenterMaster);
        return RevenueCenterMasterMapper.mapToRevenueCenterMasterDto(saveRevenueCenterMaster);

    }

    public void validateRevenueCenterName(RevenueCenterMasterDto revenueCenterMasterDto){

        if (revenueCenterMasterDto.getRevenueCenterName() == null || revenueCenterMasterDto.getRevenueCenterName().isEmpty()){
            throw new IllegalArgumentException("Revenue center name is not found with this name:" + revenueCenterMasterDto);
        }
    }

    @Override
    public RevenueCenterMasterDto getRevenueCenterMaster(String revenueCenterName){
        RevenueCenterMaster revenueCenterMaster = revenueCenterMasterDAO.findByRevenueCenterName(revenueCenterName).orElseThrow(()->

                new ResourceNotFoundException("Revenue center name is not found with this name:" + revenueCenterName));

        return RevenueCenterMasterMapper.mapToRevenueCenterMasterDto(revenueCenterMaster);
    }

    @Override
    public List<RevenueCenterMasterDto> getAllRevenueCenterMasters(){
        List<RevenueCenterMaster> revenueCenterMaster = revenueCenterMasterDAO.findAll();
        return revenueCenterMaster.stream().map(RevenueCenterMasterMapper::mapToRevenueCenterMasterDto).toList();
    }

    @Override
    public RevenueCenterMasterDto updateRevenueCenterMaster(String revenueCenterName, RevenueCenterMasterDto updatedRevenueCenterMaster){
        RevenueCenterMaster revenueCenterMaster = revenueCenterMasterDAO.findByRevenueCenterName(revenueCenterName).orElseThrow(()->

                new ResourceNotFoundException("Revenue center name not found with this name:" + revenueCenterName));

        revenueCenterMaster.setRevenueCenterName(updatedRevenueCenterMaster.getRevenueCenterName());

        RevenueCenterMaster revenueCenterMasterObj = revenueCenterMasterDAO.save(revenueCenterMaster);
        return RevenueCenterMasterMapper.mapToRevenueCenterMasterDto(revenueCenterMasterObj);
    }

    @Override
    public void deleteByRevenueCenterMaster(Long id){
        RevenueCenterMaster revenueCenterMaster = revenueCenterMasterDAO.findById(id).orElseThrow(()->

                new ResourceNotFoundException("Revenue center name is not found with this id:" + id));
        revenueCenterMasterDAO.deleteById(id);
    }
}