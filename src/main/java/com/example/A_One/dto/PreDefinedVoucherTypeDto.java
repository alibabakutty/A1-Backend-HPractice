package com.example.A_One.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreDefinedVoucherTypeDto {

    private Long id;

    private String voucherTypeName;

    private String voucherType;

    private Long startingNumber;

    private Long widthOfNumericalPart;

    private String prefillWithZero;

    private String restartNumberingApplicationForm;

    private Long restartNumberingStartingNumber;

    private String restartNumberingPeriodicity;

    private String prefixDetailsApplicationForm;

    private String prefixDetailsParticulars;

    private String suffixDetailsApplicationForm;

    private String suffixDetailsParticulars;

}
