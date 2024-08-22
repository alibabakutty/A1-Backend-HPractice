package com.example.A_One.mapper;

import com.example.A_One.dto.RevenueCenterMasterDto;
import com.example.A_One.entity.RevenueCenterMaster;

public class RevenueCenterMasterMapper {

    public static RevenueCenterMasterDto mapToRevenueCenterMasterDto(RevenueCenterMaster revenueCenterMaster){
        return new RevenueCenterMasterDto(
                revenueCenterMaster.getId(),
                revenueCenterMaster.getRevenueCenterName()
        );
    }

    public static RevenueCenterMaster mapToRevenueCenterMaster(RevenueCenterMasterDto revenueCenterMasterDto){
        return new RevenueCenterMaster(
                revenueCenterMasterDto.getId(),
                revenueCenterMasterDto.getRevenueCenterName()
        );
    }
}