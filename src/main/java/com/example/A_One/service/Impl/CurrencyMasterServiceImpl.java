package com.example.A_One.service.Impl;

import com.example.A_One.dto.CurrencyMasterDto;
import com.example.A_One.entity.CurrencyMaster;
import com.example.A_One.exception.ResourceNotFoundException;
import com.example.A_One.mapper.CurrencyMasterMapper;
import com.example.A_One.repository.CurrencyMasterDAO;
import com.example.A_One.service.CurrencyMasterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CurrencyMasterServiceImpl implements CurrencyMasterService {

    @Autowired
    private CurrencyMasterDAO currencyMasterDAO;

    @Override
    public CurrencyMasterDto createCurrencyMaster(CurrencyMasterDto currencyMasterDto){
        //validate currency symbol object
        validateCurrencyMaster(currencyMasterDto);

        //check for duplicate entry
        if (currencyMasterDAO.existsByForexCurrencySymbol(currencyMasterDto.getForexCurrencySymbol())){
            throw new DuplicateKeyException("Duplicate entry for unique field:" + currencyMasterDto.getForexCurrencySymbol());
        }

        CurrencyMaster currencyMaster = CurrencyMasterMapper.mapToCurrencyMaster(currencyMasterDto);
        CurrencyMaster saveCurrencyMaster = currencyMasterDAO.save(currencyMaster);
        return CurrencyMasterMapper.mapToCurrencyMasterDto(saveCurrencyMaster);
    };

    private void validateCurrencyMaster(CurrencyMasterDto currencyMasterDto){
        if (currencyMasterDto.getForexCurrencySymbol() == null || currencyMasterDto.getForexCurrencySymbol().isEmpty()){
            throw new IllegalArgumentException("Unique field cannot be empty!");
        }
    };

    @Override
    public CurrencyMasterDto getCurrencySymbol(String forexCurrencySymbol){
        CurrencyMaster currencyMaster = currencyMasterDAO.findByForexCurrencySymbol(forexCurrencySymbol).orElseThrow(() ->

                new ResourceNotFoundException("Currency master is not found with this name:" + forexCurrencySymbol));

        return CurrencyMasterMapper.mapToCurrencyMasterDto(currencyMaster);
    }

    @Override
    public List<CurrencyMasterDto> getAllCurrencyMasters(){
        List<CurrencyMaster> currencyMaster = currencyMasterDAO.findAll();
        return currencyMaster.stream().map(CurrencyMasterMapper::mapToCurrencyMasterDto).toList();
    }

    @Override
    public CurrencyMasterDto updateCurrencyMaster(String forexCurrencySymbol, CurrencyMasterDto updatedCurrencyMaster){
        CurrencyMaster currencyMaster = currencyMasterDAO.findByForexCurrencySymbol(forexCurrencySymbol).orElseThrow(()->

                new ResourceNotFoundException("Forex currency symbol is not found with this name:" + forexCurrencySymbol));

        currencyMaster.setId(updatedCurrencyMaster.getId());
        currencyMaster.setForexCurrencySymbol(updatedCurrencyMaster.getForexCurrencySymbol());
        currencyMaster.setForexCurrencyName(updatedCurrencyMaster.getForexCurrencyName());
        currencyMaster.setCountry(updatedCurrencyMaster.getCountry());
        currencyMaster.setVoucherDate(updatedCurrencyMaster.getVoucherDate());
        currencyMaster.setCurrencySymbol(updatedCurrencyMaster.getCurrencySymbol());
        currencyMaster.setRateForPerSalesCurrency(updatedCurrencyMaster.getRateForPerSalesCurrency());
        currencyMaster.setRateForSalesInvoice(updatedCurrencyMaster.getRateForSalesInvoice());
        currencyMaster.setRateForPerPurchaseCurrency(updatedCurrencyMaster.getRateForPerPurchaseCurrency());
        currencyMaster.setRateForPurchaseInvoice(updatedCurrencyMaster.getRateForPurchaseInvoice());
        currencyMaster.setRateForPerPaymentCurrency(updatedCurrencyMaster.getRateForPerPaymentCurrency());
        currencyMaster.setRateForPaymentInvoice(updatedCurrencyMaster.getRateForPaymentInvoice());
        currencyMaster.setRateForPerReceiptCurrency(updatedCurrencyMaster.getRateForPerReceiptCurrency());
        currencyMaster.setRateForReceiptInvoice(updatedCurrencyMaster.getRateForReceiptInvoice());

        CurrencyMaster currencyMasterObj = currencyMasterDAO.save(currencyMaster);
        return CurrencyMasterMapper.mapToCurrencyMasterDto(currencyMasterObj);
    };

    @Override
    public void deleteByCurrencyMaster(Long id){
        CurrencyMaster currencyMaster = currencyMasterDAO.findById(id).orElseThrow(() ->

                new ResourceNotFoundException("Currency symbol id not found with this name:" + id));
        currencyMasterDAO.deleteById(id);
    }
}