package com.example.A_One.service;

import com.example.A_One.dto.RevenueCategoryMasterDto;

import java.util.List;

public interface RevenueCategoryMasterService {
    RevenueCategoryMasterDto createRevenueCategoryMaster(RevenueCategoryMasterDto revenueCategoryMasterDto);

    RevenueCategoryMasterDto getRevenueCategoryMaster(String revenueCategoryName);

    List<RevenueCategoryMasterDto> getAllRevenueCategoryMasters();

    RevenueCategoryMasterDto updateRevenueCategoryMaster(String revenueCategoryName, RevenueCategoryMasterDto updateRevenueCategoryMaster);

    void deleteByRevenueCategoryMaster(Long id);
}
