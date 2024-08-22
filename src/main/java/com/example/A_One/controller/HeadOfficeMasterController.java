package com.example.A_One.controller;

import com.example.A_One.dto.HeadOfficeMasterDto;
import com.example.A_One.service.HeadOfficeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("headOfficeMasterApi")
public class HeadOfficeMasterController {

    @Autowired
    private HeadOfficeMasterService headOfficeMasterService;

    //Build ADD Masters REST API
    @PostMapping("/addHeadOffice")
    public ResponseEntity<HeadOfficeMasterDto> createHeadOffice(@RequestBody HeadOfficeMasterDto headOfficeMasterDto){
        HeadOfficeMasterDto saveHeadOffice = headOfficeMasterService.createHeadOfficeMaster(headOfficeMasterDto);
        return new ResponseEntity<>(saveHeadOffice, HttpStatus.CREATED);
    }

    //Build GET Master Ids REST API
    @RequestMapping("displayHeadOffice/{headOfficeName}")
    public ResponseEntity<HeadOfficeMasterDto> getDataByHeadOfficeName(@PathVariable String headOfficeName){
        HeadOfficeMasterDto headOfficeMasterDto = headOfficeMasterService.getHeadOfficeName(headOfficeName);
        return ResponseEntity.ok(headOfficeMasterDto);
    }

    //Build GET All Master Ids REST API
    @RequestMapping("/allHeadOffices")
    public ResponseEntity<List<HeadOfficeMasterDto>> getAllHeadOfficeMasters(){
        List<HeadOfficeMasterDto> allHeadOfficeMasters = headOfficeMasterService.getAllHeadOfficeMaster();
        return ResponseEntity.ok(allHeadOfficeMasters);
    }

    //Build UPDATE Master REST API
    @PutMapping("/alterHeadOfficeMaster/{headOfficeName}")
    public ResponseEntity<HeadOfficeMasterDto> updateHeadOfficeMaster(@PathVariable String headOfficeName, @RequestBody HeadOfficeMasterDto updatedHeadOffice){
        HeadOfficeMasterDto headOfficeMasterDto = headOfficeMasterService.updateHeadOfficeMaster(headOfficeName,updatedHeadOffice);
        return ResponseEntity.ok(headOfficeMasterDto);
    }

    //Build DELETE Ledger REST API
    @DeleteMapping("deleteHeadOffice/{id}")
    public ResponseEntity<String> deleteHeadOfficeMaster(@PathVariable Long id){
        headOfficeMasterService.deleteByHeadOfficeMaster(id);
        return ResponseEntity.ok("Head office master deleted successfully!");
    }
}