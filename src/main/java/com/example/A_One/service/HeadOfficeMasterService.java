package com.example.A_One.service;

import com.example.A_One.dto.HeadOfficeMasterDto;

import java.util.List;

public interface HeadOfficeMasterService {
    HeadOfficeMasterDto createHeadOfficeMaster(HeadOfficeMasterDto headOfficeMasterDto);

    HeadOfficeMasterDto getHeadOfficeName(String headOfficeName);

    List<HeadOfficeMasterDto> getAllHeadOfficeMaster();

    HeadOfficeMasterDto updateHeadOfficeMaster(String headOfficeName, HeadOfficeMasterDto updatedHeadOfficeMaster);

    void deleteByHeadOfficeMaster(Long id);
}
