package com.example.A_One.mapper;

import com.example.A_One.dto.LocationMasterDto;
import com.example.A_One.entity.LocationMaster;

public class LocationMasterMapper {

    public static LocationMasterDto mapToLocationMasterDto(LocationMaster locationMaster){
        return new LocationMasterDto(
                locationMaster.getId(),
                locationMaster.getGodownName()
        );
    }

    public static LocationMaster mapToLocationMaster(LocationMasterDto locationMasterDto){
        return new LocationMaster(
                locationMasterDto.getId(),
                locationMasterDto.getGodownName()
        );
    }
}