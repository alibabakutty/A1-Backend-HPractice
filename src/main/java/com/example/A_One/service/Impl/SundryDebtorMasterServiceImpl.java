package com.example.A_One.service.Impl;

import com.example.A_One.dto.SundryDebtorMasterDto;
import com.example.A_One.entity.SundryDebtorMaster;
import com.example.A_One.exception.ResourceNotFoundException;
import com.example.A_One.mapper.SundryDebtorMasterMapper;
import com.example.A_One.repository.SundryDebtorMasterDAO;
import com.example.A_One.service.SundryDebtorMasterService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SundryDebtorMasterServiceImpl implements SundryDebtorMasterService {


    private SundryDebtorMasterDAO sundryDebtorMasterDAO;

    @Override
    public SundryDebtorMasterDto createSundryDebtorMaster(SundryDebtorMasterDto sundryDebtorMasterDto){
        // validate sundry debtor name
        validateSundryDebtorName(sundryDebtorMasterDto);

        // check duplicate entry for sundry debtor name
        if (sundryDebtorMasterDAO.existsBySundryDebtorName(sundryDebtorMasterDto.getSundryDebtorName())){
            throw new DuplicateKeyException("Duplicate entry for unique field!" + sundryDebtorMasterDto.getSundryDebtorName());
        }

        SundryDebtorMaster sundryDebtorMaster = SundryDebtorMasterMapper.mapToSundryDebtorMaster(sundryDebtorMasterDto);
        SundryDebtorMaster saveSundryDebtorMaster = sundryDebtorMasterDAO.save(sundryDebtorMaster);
        return SundryDebtorMasterMapper.mapToSundryDebtorMasterDto(saveSundryDebtorMaster);
    }

    public void validateSundryDebtorName(SundryDebtorMasterDto sundryDebtorMasterDto){
        if (sundryDebtorMasterDto.getSundryDebtorName() == null || sundryDebtorMasterDto.getSundryDebtorName().isEmpty()){
            throw new IllegalArgumentException("Sundry debtor name is unique field cannot be empty!");
        }
    }

    @Override
    public SundryDebtorMasterDto getSundryDebtorName(String sundryDebtorName){
        SundryDebtorMaster sundryDebtorMaster = sundryDebtorMasterDAO.findBySundryDebtorName(sundryDebtorName).orElseThrow(() ->

                new ResourceNotFoundException("Sundry debtor name is not found with this name:" + sundryDebtorName));

        return SundryDebtorMasterMapper.mapToSundryDebtorMasterDto(sundryDebtorMaster);
    }

    @Override
    public List<SundryDebtorMasterDto> getAllSundryDebtorMaster(){
        List<SundryDebtorMaster> sundryDebtorMaster = sundryDebtorMasterDAO.findAll();
        return sundryDebtorMaster.stream().map(SundryDebtorMasterMapper::mapToSundryDebtorMasterDto).toList();
    }

    @Override
    public SundryDebtorMasterDto updateSundryDebtorMaster(String sundryDebtorName, SundryDebtorMasterDto updateSundryDebtorMaster){
        SundryDebtorMaster sundryDebtorMaster = sundryDebtorMasterDAO.findBySundryDebtorName(sundryDebtorName).orElseThrow(() ->

                new ResourceNotFoundException("Sundry debtor name is not found with this name:" + sundryDebtorName));

        sundryDebtorMaster.setSundryDebtorName(updateSundryDebtorMaster.getSundryDebtorName());
        sundryDebtorMaster.setUnderGroup(updateSundryDebtorMaster.getUnderGroup());
        sundryDebtorMaster.setBillWiseStatus(updateSundryDebtorMaster.getBillWiseStatus());
        sundryDebtorMaster.setProvideBankDetails(updateSundryDebtorMaster.getProvideBankDetails());
        sundryDebtorMaster.setAccountName(updateSundryDebtorMaster.getAccountName());
        sundryDebtorMaster.setAccountNumber(updateSundryDebtorMaster.getAccountNumber());
        sundryDebtorMaster.setBankName(updateSundryDebtorMaster.getBankName());
        sundryDebtorMaster.setBranchName(updateSundryDebtorMaster.getBranchName());
        sundryDebtorMaster.setIfscCode(updateSundryDebtorMaster.getIfscCode());
        sundryDebtorMaster.setAccountType(updateSundryDebtorMaster.getAccountType());
        sundryDebtorMaster.setSwiftCode(updateSundryDebtorMaster.getSwiftCode());
        sundryDebtorMaster.setAddressOne(updateSundryDebtorMaster.getAddressOne());
        sundryDebtorMaster.setAddressTwo(updateSundryDebtorMaster.getAddressTwo());
        sundryDebtorMaster.setAddressThree(updateSundryDebtorMaster.getAddressThree());
        sundryDebtorMaster.setAddressFour(updateSundryDebtorMaster.getAddressFour());
        sundryDebtorMaster.setAddressFive(updateSundryDebtorMaster.getAddressFive());
        sundryDebtorMaster.setLandMarkOrArea(updateSundryDebtorMaster.getLandMarkOrArea());
        sundryDebtorMaster.setState(updateSundryDebtorMaster.getState());
        sundryDebtorMaster.setCountry(updateSundryDebtorMaster.getCountry());
        sundryDebtorMaster.setPincode(updateSundryDebtorMaster.getPincode());
        sundryDebtorMaster.setPanOrItNumber(updateSundryDebtorMaster.getPanOrItNumber());
        sundryDebtorMaster.setGstinOrUinNumber(updateSundryDebtorMaster.getGstinOrUinNumber());
        sundryDebtorMaster.setMsmeNumber(updateSundryDebtorMaster.getMsmeNumber());
        sundryDebtorMaster.setContactPersonName(updateSundryDebtorMaster.getContactPersonName());
        sundryDebtorMaster.setMobileNumber(updateSundryDebtorMaster.getMobileNumber());
        sundryDebtorMaster.setLandlineNumber(updateSundryDebtorMaster.getLandlineNumber());
        sundryDebtorMaster.setEmailId(updateSundryDebtorMaster.getEmailId());
        sundryDebtorMaster.setDateForOpening(updateSundryDebtorMaster.getDateForOpening());
        sundryDebtorMaster.setOpeningBalance(updateSundryDebtorMaster.getOpeningBalance());
        sundryDebtorMaster.setCreditOrDebit(updateSundryDebtorMaster.getCreditOrDebit());
        sundryDebtorMaster.setForexDate(updateSundryDebtorMaster.getForexDate());
        sundryDebtorMaster.setReferenceName(updateSundryDebtorMaster.getReferenceName());
        sundryDebtorMaster.setDueDate(updateSundryDebtorMaster.getDueDate());
        sundryDebtorMaster.setForexCurrencyType(updateSundryDebtorMaster.getForexCurrencyType());
        sundryDebtorMaster.setForexAmount(updateSundryDebtorMaster.getForexAmount());
        sundryDebtorMaster.setExchangeRate(updateSundryDebtorMaster.getExchangeRate());
        sundryDebtorMaster.setReferenceAmount(updateSundryDebtorMaster.getReferenceAmount());
        sundryDebtorMaster.setReferenceCreditOrDebit(updateSundryDebtorMaster.getReferenceCreditOrDebit());

        SundryDebtorMaster sundryDebtorMasterObj = sundryDebtorMasterDAO.save(sundryDebtorMaster);
        return SundryDebtorMasterMapper.mapToSundryDebtorMasterDto(sundryDebtorMasterObj);
    }

    @Override
    public void deleteBySundryDebtorMaster(Long id){
        SundryDebtorMaster sundryDebtorMaster = sundryDebtorMasterDAO.findById(id).orElseThrow(()->

                new ResourceNotFoundException("Sundry debtor name is not found with this id:" + id));
        sundryDebtorMasterDAO.deleteById(id);
    }
}