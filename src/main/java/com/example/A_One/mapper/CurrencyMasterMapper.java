package com.example.A_One.mapper;

import com.example.A_One.dto.CurrencyMasterDto;
import com.example.A_One.entity.CurrencyMaster;

public class CurrencyMasterMapper {

    public static CurrencyMasterDto mapToCurrencyMasterDto(CurrencyMaster currencyMaster){
        return new CurrencyMasterDto(
                currencyMaster.getId(),
                currencyMaster.getForexCurrencySymbol(),
                currencyMaster.getForexCurrencyName(),
                currencyMaster.getCountry(),
                currencyMaster.getVoucherDate(),
                currencyMaster.getCurrencySymbol(),
                currencyMaster.getRateForPerSalesCurrency(),
                currencyMaster.getRateForSalesInvoice(),
                currencyMaster.getRateForPerPurchaseCurrency(),
                currencyMaster.getRateForPurchaseInvoice(),
                currencyMaster.getRateForPerPaymentCurrency(),
                currencyMaster.getRateForPaymentInvoice(),
                currencyMaster.getRateForPerReceiptCurrency(),
                currencyMaster.getRateForReceiptInvoice()
        );
    }

    public static CurrencyMaster mapToCurrencyMaster(CurrencyMasterDto currencyMasterDto){
        return new CurrencyMaster(
                currencyMasterDto.getId(),
                currencyMasterDto.getForexCurrencySymbol(),
                currencyMasterDto.getForexCurrencyName(),
                currencyMasterDto.getCountry(),
                currencyMasterDto.getVoucherDate(),
                currencyMasterDto.getCurrencySymbol(),
                currencyMasterDto.getRateForPerSalesCurrency(),
                currencyMasterDto.getRateForSalesInvoice(),
                currencyMasterDto.getRateForPerPurchaseCurrency(),
                currencyMasterDto.getRateForPurchaseInvoice(),
                currencyMasterDto.getRateForPerPaymentCurrency(),
                currencyMasterDto.getRateForPaymentInvoice(),
                currencyMasterDto.getRateForPerReceiptCurrency(),
                currencyMasterDto.getRateForReceiptInvoice()
        );
    }
}