package com.example.A_One.controller;

import com.example.A_One.dto.BranchOfficeMasterDto;
import com.example.A_One.service.BranchOfficeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("branchOfficeMasterApi")
public class BranchOfficeMasterController {

    @Autowired
    private BranchOfficeMasterService branchOfficeMasterService;

    //Build ADD Masters REST API
    @PostMapping("/addBranchOffice")
    public ResponseEntity<BranchOfficeMasterDto> createBranchOffice(@RequestBody BranchOfficeMasterDto branchOfficeMasterDto){
        BranchOfficeMasterDto saveBranchOfficeMaster = branchOfficeMasterService.createBranchOfficeMaster(branchOfficeMasterDto);
        return new ResponseEntity<>(saveBranchOfficeMaster, HttpStatus.CREATED);
    }

    //Build GET Master Ids REST API
    @RequestMapping("displayBranchOffice/{branchOfficeName}")
    public ResponseEntity<BranchOfficeMasterDto> getDataByBranchOfficeName(@PathVariable String branchOfficeName){
        BranchOfficeMasterDto branchOfficeMasterDto = branchOfficeMasterService.getBranchOfficeMaster(branchOfficeName);
        return ResponseEntity.ok(branchOfficeMasterDto);
    }

    //Build GET All Master Ids REST API
    @RequestMapping("/allBranchOffices")
    public ResponseEntity<List<BranchOfficeMasterDto>> getAllBranchOfficeMasters(){
        List<BranchOfficeMasterDto> allBranchOfficeMasters = branchOfficeMasterService.getAllBranchOfficeMaster();
        return ResponseEntity.ok(allBranchOfficeMasters);
    }

    //Build UPDATE Master REST API
    @PutMapping("/alterBranchOfficeMaster/{branchOfficeName}")
    public ResponseEntity<BranchOfficeMasterDto> updateBranchOfficeMaster(@PathVariable String branchOfficeName,@RequestBody BranchOfficeMasterDto updatedBranchOfficeMaster){
        BranchOfficeMasterDto branchOfficeMasterDto = branchOfficeMasterService.updateBranchOfficeMaster(branchOfficeName,updatedBranchOfficeMaster);
        return ResponseEntity.ok(branchOfficeMasterDto);
    }

    //Build DELETE Ledger REST API
    @DeleteMapping("deleteBranchOffice/{id}")
    public ResponseEntity<String> deleteBranchOfficeMaster(@PathVariable Long id){
        branchOfficeMasterService.deleteByBranchOfficeMaster(id);
        return ResponseEntity.ok("Branch Office Master deleted successfully!");
    }
}