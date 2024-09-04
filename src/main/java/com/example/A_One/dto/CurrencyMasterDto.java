package com.example.A_One.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyMasterDto {

    private Long id;

    private String forexCurrencySymbol;

    private String forexCurrencyName;

    private String country;

    private String voucherDate;

    private String currencySymbol;

    private BigDecimal rateForPerSalesCurrency;

    private BigDecimal rateForSalesInvoice;

    private BigDecimal rateForPerPurchaseCurrency;

    private BigDecimal rateForPurchaseInvoice;

    private BigDecimal rateForPerPaymentCurrency;

    private BigDecimal rateForPaymentInvoice;

    private BigDecimal rateForPerReceiptCurrency;

    private BigDecimal rateForReceiptInvoice;
}