package com.example.A_One.controller;

import com.example.A_One.dto.RevenueCenterMasterDto;
import com.example.A_One.service.RevenueCenterMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("revenueCenterMasterApi")
public class RevenueCenterMasterController {

    @Autowired
    private RevenueCenterMasterService revenueCenterMasterService;

    //Build ADD Masters REST API
    @PostMapping("/addRevenueCenter")
    public ResponseEntity<RevenueCenterMasterDto> createRevenueCenterMaster(@RequestBody RevenueCenterMasterDto revenueCenterMasterDto){

        RevenueCenterMasterDto saveRevenueCenterMaster = revenueCenterMasterService.createRevenueCenterMaster(revenueCenterMasterDto);
        return new ResponseEntity<>(saveRevenueCenterMaster, HttpStatus.CREATED);
    }

    //Build GET Master Ids REST API
    @RequestMapping("displayRevenueCenter/{revenueCenterName}")
    public ResponseEntity<RevenueCenterMasterDto> getRevenueCenterMaster(@PathVariable String revenueCenterName){
        RevenueCenterMasterDto revenueCenterMasterDto = revenueCenterMasterService.getRevenueCenterMaster(revenueCenterName);
        return ResponseEntity.ok(revenueCenterMasterDto);
    }

    //Build GET All Master Ids REST API
    @RequestMapping("/allRevenueCenters")
    public ResponseEntity<List<RevenueCenterMasterDto>> getAllRevenueCenterMasters(){
        List<RevenueCenterMasterDto> allRevenueCenterMasters = revenueCenterMasterService.getAllRevenueCenterMasters();
        return ResponseEntity.ok(allRevenueCenterMasters);
    }

    //Build UPDATE Master REST API
    @PutMapping("/alterRevenueCenterMaster/{revenueCenterName}")
    public ResponseEntity<RevenueCenterMasterDto> updateRevenueCenterMaster(@PathVariable String revenueCenterName, @RequestBody RevenueCenterMasterDto updatedRevenueCenterMaster){
        RevenueCenterMasterDto revenueCenterMasterDto = revenueCenterMasterService.updateRevenueCenterMaster(revenueCenterName,updatedRevenueCenterMaster);
        return ResponseEntity.ok(revenueCenterMasterDto);
    }

    //Build DELETE Ledger REST API
    @DeleteMapping("/deleteRevenueCenter/{id}")
    public ResponseEntity<String> deleteRevenueCenterMaster(@PathVariable Long id){
        revenueCenterMasterService.deleteByRevenueCenterMaster(id);
        return ResponseEntity.ok("Revenue center name deleted successfully!");
    }
}