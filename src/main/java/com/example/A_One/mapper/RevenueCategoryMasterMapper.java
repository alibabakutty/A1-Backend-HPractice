package com.example.A_One.mapper;

import com.example.A_One.dto.RevenueCategoryMasterDto;
import com.example.A_One.entity.RevenueCategoryMaster;

public class RevenueCategoryMasterMapper {

    public static RevenueCategoryMasterDto mapToRevenueCategoryMasterDto(RevenueCategoryMaster revenueCategoryMaster){
        return new RevenueCategoryMasterDto(
                revenueCategoryMaster.getId(),
                revenueCategoryMaster.getRevenueCategoryName()
        );
    }

    public static RevenueCategoryMaster mapToRevenueCategoryMaster(RevenueCategoryMasterDto revenueCategoryMasterDto){
        return new RevenueCategoryMaster(
                revenueCategoryMasterDto.getId(),
                revenueCategoryMasterDto.getRevenueCategoryName()
        );
    }
}