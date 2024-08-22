package com.example.A_One.mapper;

import com.example.A_One.dto.HeadOfficeMasterDto;
import com.example.A_One.entity.HeadOfficeMaster;

public class HeadOfficeMasterMapper {

    public static HeadOfficeMasterDto mapToHeadOfficeDto (HeadOfficeMaster headOfficeMaster){
        return new HeadOfficeMasterDto(
                headOfficeMaster.getId(),
                headOfficeMaster.getHeadOfficeName()
        );
    }

    public static HeadOfficeMaster mapToHeadOffice (HeadOfficeMasterDto headOfficeMasterDto){
        return new HeadOfficeMaster(
                headOfficeMasterDto.getId(),
                headOfficeMasterDto.getHeadOfficeName()
        );
    }
}