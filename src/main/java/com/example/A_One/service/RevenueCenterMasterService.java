package com.example.A_One.service;

import com.example.A_One.dto.RevenueCenterMasterDto;

import java.util.List;

public interface RevenueCenterMasterService {
    RevenueCenterMasterDto createRevenueCenterMaster(RevenueCenterMasterDto revenueCenterMasterDto);

    RevenueCenterMasterDto getRevenueCenterMaster(String revenueCenterName);

    List<RevenueCenterMasterDto> getAllRevenueCenterMasters();

    RevenueCenterMasterDto updateRevenueCenterMaster(String revenueCenterName, RevenueCenterMasterDto updatedRevenueCenterMaster);

    void deleteByRevenueCenterMaster(Long id);
}
