package com.example.A_One.mapper;

import com.example.A_One.dto.VoucherTypeMasterDto;
import com.example.A_One.entity.VoucherTypeMaster;

public class VoucherTypeMasterMapper {

    public static VoucherTypeMasterDto mapToVoucherTypeMasterDto(VoucherTypeMaster voucherTypeMaster){
        return new VoucherTypeMasterDto(
                voucherTypeMaster.getId(),
                voucherTypeMaster.getVoucherTypeName(),
                voucherTypeMaster.getVoucherType(),
                voucherTypeMaster.getStartingNumber(),
                voucherTypeMaster.getWidthOfNumericalPart(),
                voucherTypeMaster.getPrefillWithZero(),
                voucherTypeMaster.getRestartNumberingApplicationForm(),
                voucherTypeMaster.getRestartNumberingStartingNumber(),
                voucherTypeMaster.getRestartNumberingPeriodicity(),
                voucherTypeMaster.getPrefixDetailsApplicationForm(),
                voucherTypeMaster.getPrefixDetailsParticulars(),
                voucherTypeMaster.getSuffixDetailsApplicationForm(),
                voucherTypeMaster.getSuffixDetailsParticulars(),
                voucherTypeMaster.getVoucherDate(),
                voucherTypeMaster.getVoucherNumber()
        );

    }

    public static VoucherTypeMaster mapToVoucherTypeMaster(VoucherTypeMasterDto voucherTypeMasterDto){
        return new VoucherTypeMaster(
                voucherTypeMasterDto.getId(),
                voucherTypeMasterDto.getVoucherTypeName(),
                voucherTypeMasterDto.getVoucherType(),
                voucherTypeMasterDto.getStartingNumber(),
                voucherTypeMasterDto.getWidthOfNumericalPart(),
                voucherTypeMasterDto.getPrefillWithZero(),
                voucherTypeMasterDto.getRestartNumberingApplicationForm(),
                voucherTypeMasterDto.getRestartNumberingStartingNumber(),
                voucherTypeMasterDto.getRestartNumberingPeriodicity(),
                voucherTypeMasterDto.getPrefixDetailsApplicationForm(),
                voucherTypeMasterDto.getPrefixDetailsParticulars(),
                voucherTypeMasterDto.getSuffixDetailsApplicationForm(),
                voucherTypeMasterDto.getSuffixDetailsParticulars(),
                voucherTypeMasterDto.getVoucherDate(),
                voucherTypeMasterDto.getVoucherNumber()
        );
    }
}
