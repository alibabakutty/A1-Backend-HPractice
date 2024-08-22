package com.example.A_One.mapper;

import com.example.A_One.dto.BranchOfficeMasterDto;
import com.example.A_One.entity.BranchOfficeMaster;

public class BranchOfficeMasterMapper {

    public static BranchOfficeMasterDto mapToBranchOfficeMasterDto(BranchOfficeMaster branchOfficeMaster){
        return new BranchOfficeMasterDto(
                branchOfficeMaster.getId(),
                branchOfficeMaster.getBranchOfficeName()
        );
    }

    public static BranchOfficeMaster mapToBranchOfficeMaster(BranchOfficeMasterDto branchOfficeMasterDto){
        return new BranchOfficeMaster(
                branchOfficeMasterDto.getId(),
                branchOfficeMasterDto.getBranchOfficeName()
        );
    }
}