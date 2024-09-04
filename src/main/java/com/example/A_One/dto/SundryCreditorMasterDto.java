package com.example.A_One.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SundryCreditorMasterDto {

    private Long id;

    private String sundryCreditorName;

    private String underGroup;

    private String billWiseStatus;

    private String provideBankDetails;

    private String accountName;

    private BigInteger accountNumber;

    private String bankName;

    private String branchName;

    private String ifscCode;

    private String accountType;

    private String swiftCode;

    private String addressOne;

    private String addressTwo;

    private String addressThree;

    private String addressFour;

    private String addressFive;

    private String landMarkOrArea;

    private String state;

    private String country;

    private Long pincode;

    private String panOrItNumber;

    private String gstinOrUinNumber;

    private String msmeNumber;

    private String contactPersonName;

    private BigInteger mobileNumber;

    private String landlineNumber;

    private String emailId;

    private String dateForOpening;

    private BigDecimal openingBalance;

    private String creditOrDebit;

    private String billWiseBreakOf;

    private BigDecimal uptoOpeningBalanceAmount;

    private String uptoCreditOrDebit;

    private String forexDate;

    private String referenceName;

    private String dueDate;

    private String forexCurrencyType;

    private BigDecimal forexAmount;

    private BigDecimal exchangeRate;

    private BigDecimal referenceAmount;

    private String referenceCreditOrDebit;
}