package com.example.A_One.service.Impl;

import com.example.A_One.dto.SundryCreditorMasterDto;
import com.example.A_One.entity.SundryCreditorMaster;
import com.example.A_One.exception.ResourceNotFoundException;
import com.example.A_One.mapper.SundryCreditorMasterMapper;
import com.example.A_One.repository.SundryCreditorMasterDAO;
import com.example.A_One.service.SundryCreditorMasterService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SundryCreditorMasterServiceImpl implements SundryCreditorMasterService {

    private SundryCreditorMasterDAO sundryCreditorMasterDAO;

    @Override
    public SundryCreditorMasterDto createSundryCreditorMaster(SundryCreditorMasterDto sundryCreditorMasterDto){

        // validate sundry creditor name
        validateSundryCreditorName(sundryCreditorMasterDto);

        // check duplicate entry for sundry creditor name
        if (sundryCreditorMasterDAO.existsBySundryCreditorName(sundryCreditorMasterDto.getSundryCreditorName())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + sundryCreditorMasterDto.getSundryCreditorName());
        }

        SundryCreditorMaster sundryCreditorMaster = SundryCreditorMasterMapper.mapToSundryCreditorMaster(sundryCreditorMasterDto);
        SundryCreditorMaster saveSundryCreditorMaster = sundryCreditorMasterDAO.save(sundryCreditorMaster);
        return SundryCreditorMasterMapper.mapToSundryCreditorMasterDto(saveSundryCreditorMaster);
    }

    public void validateSundryCreditorName(SundryCreditorMasterDto sundryCreditorMasterDto){
        if (sundryCreditorMasterDto.getSundryCreditorName() == null || sundryCreditorMasterDto.getSundryCreditorName().isEmpty()){
            throw new IllegalArgumentException("Sundry creditor name is unique field cannot be empty!");
        }
    }

    @Override
    public SundryCreditorMasterDto getSundryCreditorName(String sundryCreditorName){
        SundryCreditorMaster sundryCreditorMaster = sundryCreditorMasterDAO.findBySundryCreditorName(sundryCreditorName).orElseThrow(() ->

                new ResourceNotFoundException("Sundry creditor name is not found with this name:" + sundryCreditorName));
        return SundryCreditorMasterMapper.mapToSundryCreditorMasterDto(sundryCreditorMaster);
    }

    @Override
    public List<SundryCreditorMasterDto> getAllSundryCreditorMaster(){
        List<SundryCreditorMaster> sundryCreditorMaster = sundryCreditorMasterDAO.findAll();
        return sundryCreditorMaster.stream().map(SundryCreditorMasterMapper::mapToSundryCreditorMasterDto).toList();
    }

    @Override
    public SundryCreditorMasterDto updateSundryCreditorMaster(String sundryCreditorName, SundryCreditorMasterDto updateSundryCreditorMaster){
        SundryCreditorMaster sundryCreditorMaster = sundryCreditorMasterDAO.findBySundryCreditorName(sundryCreditorName).orElseThrow(() ->

                new ResourceNotFoundException("Sundry creditor name is not found with this name:" + sundryCreditorName));

        sundryCreditorMaster.setSundryCreditorName(updateSundryCreditorMaster.getSundryCreditorName());
        sundryCreditorMaster.setUnderGroup(updateSundryCreditorMaster.getUnderGroup());
        sundryCreditorMaster.setBillWiseStatus(updateSundryCreditorMaster.getBillWiseStatus());
        sundryCreditorMaster.setProvideBankDetails(updateSundryCreditorMaster.getProvideBankDetails());
        sundryCreditorMaster.setAccountName(updateSundryCreditorMaster.getAccountName());
        sundryCreditorMaster.setAccountNumber(updateSundryCreditorMaster.getAccountNumber());
        sundryCreditorMaster.setBankName(updateSundryCreditorMaster.getBankName());
        sundryCreditorMaster.setBranchName(updateSundryCreditorMaster.getBranchName());
        sundryCreditorMaster.setIfscCode(updateSundryCreditorMaster.getIfscCode());
        sundryCreditorMaster.setAccountType(updateSundryCreditorMaster.getAccountType());
        sundryCreditorMaster.setSwiftCode(updateSundryCreditorMaster.getSwiftCode());
        sundryCreditorMaster.setAddressOne(updateSundryCreditorMaster.getAddressOne());
        sundryCreditorMaster.setAddressTwo(updateSundryCreditorMaster.getAddressTwo());
        sundryCreditorMaster.setAddressThree(updateSundryCreditorMaster.getAddressThree());
        sundryCreditorMaster.setAddressFour(updateSundryCreditorMaster.getAddressFour());
        sundryCreditorMaster.setAddressFive(updateSundryCreditorMaster.getAddressFive());
        sundryCreditorMaster.setLandMarkOrArea(updateSundryCreditorMaster.getLandMarkOrArea());
        sundryCreditorMaster.setState(updateSundryCreditorMaster.getState());
        sundryCreditorMaster.setCountry(updateSundryCreditorMaster.getCountry());
        sundryCreditorMaster.setPincode(updateSundryCreditorMaster.getPincode());
        sundryCreditorMaster.setPanOrItNumber(updateSundryCreditorMaster.getPanOrItNumber());
        sundryCreditorMaster.setGstinOrUinNumber(updateSundryCreditorMaster.getGstinOrUinNumber());
        sundryCreditorMaster.setMsmeNumber(updateSundryCreditorMaster.getMsmeNumber());
        sundryCreditorMaster.setContactPersonName(updateSundryCreditorMaster.getContactPersonName());
        sundryCreditorMaster.setMobileNumber(updateSundryCreditorMaster.getMobileNumber());
        sundryCreditorMaster.setLandlineNumber(updateSundryCreditorMaster.getLandlineNumber());
        sundryCreditorMaster.setEmailId(updateSundryCreditorMaster.getEmailId());
        sundryCreditorMaster.setDateForOpening(updateSundryCreditorMaster.getDateForOpening());
        sundryCreditorMaster.setOpeningBalance(updateSundryCreditorMaster.getOpeningBalance());
        sundryCreditorMaster.setCreditOrDebit(updateSundryCreditorMaster.getCreditOrDebit());
        sundryCreditorMaster.setForexDate(updateSundryCreditorMaster.getForexDate());
        sundryCreditorMaster.setReferenceName(updateSundryCreditorMaster.getReferenceName());
        sundryCreditorMaster.setDueDate(updateSundryCreditorMaster.getDueDate());
        sundryCreditorMaster.setForexCurrencyType(updateSundryCreditorMaster.getForexCurrencyType());
        sundryCreditorMaster.setForexAmount(updateSundryCreditorMaster.getForexAmount());
        sundryCreditorMaster.setExchangeRate(updateSundryCreditorMaster.getExchangeRate());
        sundryCreditorMaster.setReferenceAmount(updateSundryCreditorMaster.getReferenceAmount());
        sundryCreditorMaster.setReferenceCreditOrDebit(updateSundryCreditorMaster.getReferenceCreditOrDebit());

        SundryCreditorMaster sundryCreditorMasterObj = sundryCreditorMasterDAO.save(sundryCreditorMaster);
        return SundryCreditorMasterMapper.mapToSundryCreditorMasterDto(sundryCreditorMasterObj);
    }

    @Override
    public void deleteBySundryCreditorMaster(Long id){
        SundryCreditorMaster sundryCreditorMaster = sundryCreditorMasterDAO.findById(id).orElseThrow(() ->

                new ResourceNotFoundException("Sundry creditor name is not found with this id:" + id));
        sundryCreditorMasterDAO.deleteById(id);
    }
}