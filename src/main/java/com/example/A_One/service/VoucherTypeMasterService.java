package com.example.A_One.service;

import com.example.A_One.dto.VoucherTypeMasterDto;

import java.util.List;

public interface VoucherTypeMasterService {
    VoucherTypeMasterDto createVoucherTypeMaster(VoucherTypeMasterDto voucherTypeMasterDto);

    VoucherTypeMasterDto getVoucherTypeName(String voucherTypeName);

    List<VoucherTypeMasterDto> getAllVoucherTypeMasters();

    VoucherTypeMasterDto updateVoucherTypeMaster(String voucherTypeName, VoucherTypeMasterDto updatedVoucherTypeMaster);

    void deleteByVoucherTypeMaster(Long id);
}
