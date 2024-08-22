package com.example.A_One.controller;

import com.example.A_One.dto.RevenueCategoryMasterDto;
import com.example.A_One.service.RevenueCategoryMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("revenueCategoryMasterApi")
public class RevenueCategoryMasterController {

    @Autowired
    private RevenueCategoryMasterService revenueCategoryMasterService;

    //Build ADD Masters REST API
    @PostMapping("/addRevenueCategory")
    public ResponseEntity<RevenueCategoryMasterDto> createRevenueCategoryMaster(@RequestBody RevenueCategoryMasterDto revenueCategoryMasterDto){
        RevenueCategoryMasterDto saveRevenueCategoryMaster = revenueCategoryMasterService.createRevenueCategoryMaster(revenueCategoryMasterDto);
        return new ResponseEntity<>(saveRevenueCategoryMaster,HttpStatus.CREATED);
    }

    //Build GET Master Ids REST API
    @RequestMapping("displayRevenueCategory/{revenueCategoryName}")
    public ResponseEntity<RevenueCategoryMasterDto> getDataByRevenueCategoryName(@PathVariable String revenueCategoryName){
        RevenueCategoryMasterDto revenueCategoryMasterDto = revenueCategoryMasterService.getRevenueCategoryMaster(revenueCategoryName);
        return ResponseEntity.ok(revenueCategoryMasterDto);
    }

    //Build GET All Master Ids REST API
    @RequestMapping("/allRevenueCategories")
    public ResponseEntity<List<RevenueCategoryMasterDto>> getAllRevenueCategoryMasters(){
        List<RevenueCategoryMasterDto> allRevenueCategoryMasters = revenueCategoryMasterService.getAllRevenueCategoryMasters();
        return ResponseEntity.ok(allRevenueCategoryMasters);
    }

    //Build UPDATE Master REST API
    @PutMapping("/alterRevenueCategoryMaster/{revenueCategoryName}")
    public ResponseEntity<RevenueCategoryMasterDto> updateRevenueCategoryMaster(@PathVariable String revenueCategoryName,@RequestBody RevenueCategoryMasterDto updatedRevenueCategoryMaster){
        RevenueCategoryMasterDto revenueCategoryMasterDto = revenueCategoryMasterService.updateRevenueCategoryMaster(revenueCategoryName,updatedRevenueCategoryMaster);
        return ResponseEntity.ok(revenueCategoryMasterDto);
    }

    //Build DELETE Ledger REST API
    @DeleteMapping("deleteRevenueCategoryMaster/{id}")
    public ResponseEntity<String> deleteRevenueCategoryMaster(@PathVariable Long id){
        revenueCategoryMasterService.deleteByRevenueCategoryMaster(id);
        return ResponseEntity.ok("Revenue category master deleted successfully!");
    }
}