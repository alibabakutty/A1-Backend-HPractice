package com.example.A_One.service.Impl;

import com.example.A_One.dto.PreDefinedVoucherTypeDto;
import com.example.A_One.entity.PreDefinedVoucherType;
import com.example.A_One.exception.ResourceNotFoundException;
import com.example.A_One.mapper.PreDefinedVoucherTypeMapper;
import com.example.A_One.repository.PreDefinedVoucherTypeDAO;
import com.example.A_One.service.PreDefinedVoucherTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PreDefinedVoucherTypeServiceImpl implements PreDefinedVoucherTypeService {

    @Autowired
    private PreDefinedVoucherTypeDAO preDefinedVoucherTypeDAO;

    @Override
    public PreDefinedVoucherTypeDto createPreDefinedVoucherType(PreDefinedVoucherTypeDto preDefinedVoucherTypeDto){

        // validate predefined voucher type name object
        validatePreDefinedVoucherType(preDefinedVoucherTypeDto);

        // check for duplicate entry
        if (preDefinedVoucherTypeDAO.existsByVoucherType(preDefinedVoucherTypeDto.getVoucherType())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + preDefinedVoucherTypeDto.getVoucherType());
        }

        PreDefinedVoucherType preDefinedVoucherType = PreDefinedVoucherTypeMapper.mapToPreDefinedVoucherType(preDefinedVoucherTypeDto);
        PreDefinedVoucherType savePreDefinedVoucherType = preDefinedVoucherTypeDAO.save(preDefinedVoucherType);
        return PreDefinedVoucherTypeMapper.mapToPreDefinedVoucherTypeDto(savePreDefinedVoucherType);
    }

    private void validatePreDefinedVoucherType(PreDefinedVoucherTypeDto preDefinedVoucherTypeDto){
        if (preDefinedVoucherTypeDto.getVoucherType() == null || preDefinedVoucherTypeDto.getVoucherType().isEmpty()){
            throw new IllegalArgumentException("Unique field cannot be empty!");
        }
    }

    @Override
    public PreDefinedVoucherTypeDto getPreDefinedVoucherTypeName(String voucherType){
        PreDefinedVoucherType preDefinedVoucherType = preDefinedVoucherTypeDAO.findByVoucherType(voucherType).orElseThrow(() ->

                new ResourceNotFoundException("Predefined voucher type name is not found with this name:" + voucherType));

        return PreDefinedVoucherTypeMapper.mapToPreDefinedVoucherTypeDto(preDefinedVoucherType);
    }

    @Override
    public List<PreDefinedVoucherTypeDto> getAllPreDefinedVoucherTypes(){
        List<PreDefinedVoucherType> preDefinedVoucherType = preDefinedVoucherTypeDAO.findAll();
        return preDefinedVoucherType.stream().map(PreDefinedVoucherTypeMapper::mapToPreDefinedVoucherTypeDto).toList();
    }

    @Override
    public PreDefinedVoucherTypeDto updatePreDefinedVoucherType(String voucherType, PreDefinedVoucherTypeDto updatedPreDefinedVoucherType){
        PreDefinedVoucherType preDefinedVoucherType = preDefinedVoucherTypeDAO.findByVoucherType(voucherType).orElseThrow(()->

                new ResourceNotFoundException("PreDefined voucher type is not found with this name:" + voucherType));

        preDefinedVoucherType.setId(updatedPreDefinedVoucherType.getId());
        preDefinedVoucherType.setVoucherTypeName(updatedPreDefinedVoucherType.getVoucherTypeName());
        preDefinedVoucherType.setVoucherType(updatedPreDefinedVoucherType.getVoucherType());
        preDefinedVoucherType.setStartingNumber(updatedPreDefinedVoucherType.getStartingNumber());
        preDefinedVoucherType.setWidthOfNumericalPart(updatedPreDefinedVoucherType.getWidthOfNumericalPart());
        preDefinedVoucherType.setPrefillWithZero(updatedPreDefinedVoucherType.getPrefillWithZero());
        preDefinedVoucherType.setRestartNumberingApplicationForm(updatedPreDefinedVoucherType.getRestartNumberingApplicationForm());
        preDefinedVoucherType.setRestartNumberingStartingNumber(updatedPreDefinedVoucherType.getRestartNumberingStartingNumber());
        preDefinedVoucherType.setRestartNumberingPeriodicity(updatedPreDefinedVoucherType.getRestartNumberingPeriodicity());
        preDefinedVoucherType.setPrefixDetailsApplicationForm(updatedPreDefinedVoucherType.getPrefixDetailsApplicationForm());
        preDefinedVoucherType.setPrefixDetailsParticulars(updatedPreDefinedVoucherType.getPrefixDetailsParticulars());
        preDefinedVoucherType.setSuffixDetailsApplicationForm(updatedPreDefinedVoucherType.getSuffixDetailsApplicationForm());
        preDefinedVoucherType.setSuffixDetailsParticulars(updatedPreDefinedVoucherType.getSuffixDetailsParticulars());

        PreDefinedVoucherType preDefinedVoucherTypeObj = preDefinedVoucherTypeDAO.save(preDefinedVoucherType);
        return PreDefinedVoucherTypeMapper.mapToPreDefinedVoucherTypeDto(preDefinedVoucherTypeObj);
    }

    @Override
    public void deleteByPreDefinedVoucherType(Long id){
        PreDefinedVoucherType preDefinedVoucherType = preDefinedVoucherTypeDAO.findById(id).orElseThrow(()->

                new ResourceNotFoundException("Predefined voucher type name is not found with this name:" + id));
        preDefinedVoucherTypeDAO.deleteById(id);
    }
}
