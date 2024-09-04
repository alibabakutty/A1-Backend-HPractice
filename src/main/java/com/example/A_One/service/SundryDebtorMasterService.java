package com.example.A_One.service;

import com.example.A_One.dto.SundryDebtorMasterDto;

import java.util.List;

public interface SundryDebtorMasterService {
    SundryDebtorMasterDto createSundryDebtorMaster(SundryDebtorMasterDto sundryDebtorMasterDto);

    SundryDebtorMasterDto getSundryDebtorName(String sundryDebtorName);

    List<SundryDebtorMasterDto> getAllSundryDebtorMaster();

    SundryDebtorMasterDto updateSundryDebtorMaster(String sundryDebtorName, SundryDebtorMasterDto updateSundryDebtorMaster);

    void deleteBySundryDebtorMaster(Long id);
}
