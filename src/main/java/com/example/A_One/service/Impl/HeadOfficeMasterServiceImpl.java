package com.example.A_One.service.Impl;

import com.example.A_One.dto.HeadOfficeMasterDto;
import com.example.A_One.entity.HeadOfficeMaster;
import com.example.A_One.exception.ResourceNotFoundException;
import com.example.A_One.mapper.HeadOfficeMasterMapper;
import com.example.A_One.repository.HeadOfficeMasterDAO;
import com.example.A_One.service.HeadOfficeMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class HeadOfficeMasterServiceImpl implements HeadOfficeMasterService {

    @Autowired
    private HeadOfficeMasterDAO headOfficeMasterDAO;

    @Override
    public HeadOfficeMasterDto createHeadOfficeMaster(HeadOfficeMasterDto headOfficeMasterDto){

        // validate head office object
        validateHeadOfficeName(headOfficeMasterDto);

        // check for duplicate entry
        if (headOfficeMasterDAO.existsByHeadOfficeName(headOfficeMasterDto.getHeadOfficeName())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + headOfficeMasterDto.getHeadOfficeName());
        }

        HeadOfficeMaster headOfficeMaster = HeadOfficeMasterMapper.mapToHeadOffice(headOfficeMasterDto);
        HeadOfficeMaster saveHeadOfficeMaster = headOfficeMasterDAO.save(headOfficeMaster);
        return HeadOfficeMasterMapper.mapToHeadOfficeDto(saveHeadOfficeMaster);
    }

    public void validateHeadOfficeName(HeadOfficeMasterDto headOfficeMasterDto){
        if (headOfficeMasterDto.getHeadOfficeName() == null || headOfficeMasterDto.getHeadOfficeName().isEmpty()){
            throw new IllegalArgumentException("Head Office Name field cannot be empty!");
        }
    }

    @Override
    public HeadOfficeMasterDto getHeadOfficeName(String headOfficeName){
        HeadOfficeMaster headOfficeMaster = headOfficeMasterDAO.findByHeadOfficeName(headOfficeName).orElseThrow(() ->

                new ResourceNotFoundException("Head Office Name is not found with this name:" + headOfficeName));

        return HeadOfficeMasterMapper.mapToHeadOfficeDto(headOfficeMaster);
    }

    @Override
    public List<HeadOfficeMasterDto> getAllHeadOfficeMaster(){
        List<HeadOfficeMaster> headOfficeMaster = headOfficeMasterDAO.findAll();
        return headOfficeMaster.stream().map(HeadOfficeMasterMapper::mapToHeadOfficeDto).toList();
    }

    @Override
    public HeadOfficeMasterDto updateHeadOfficeMaster(String headOfficeName, HeadOfficeMasterDto updatedHeadOfficeMaster){
        HeadOfficeMaster headOfficeMaster = headOfficeMasterDAO.findByHeadOfficeName(headOfficeName).orElseThrow(() ->

                new ResourceNotFoundException("Head Office Name is not found with this name:" + headOfficeName));

        headOfficeMaster.setHeadOfficeName(updatedHeadOfficeMaster.getHeadOfficeName());
        HeadOfficeMaster headOfficeMasterObj = headOfficeMasterDAO.save(headOfficeMaster);
        return HeadOfficeMasterMapper.mapToHeadOfficeDto(headOfficeMasterObj);
    }

    @Override
    public void deleteByHeadOfficeMaster(Long id){
        HeadOfficeMaster headOfficeMaster = headOfficeMasterDAO.findById(id).orElseThrow(() ->

                new ResourceNotFoundException("Head office Name is not found with this name:" + id));
        headOfficeMasterDAO.deleteById(id);
    }
}