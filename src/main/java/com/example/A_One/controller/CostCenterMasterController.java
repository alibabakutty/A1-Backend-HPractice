package com.example.A_One.controller;

import com.example.A_One.dto.CostCenterMasterDto;
import com.example.A_One.service.CostCenterMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("costCenterMasterApi")
public class CostCenterMasterController {

    @Autowired
    private CostCenterMasterService costCenterMasterService;

    //Build ADD Masters REST API
    @PostMapping("/addCostCenter")
    public ResponseEntity<CostCenterMasterDto> createCostCenterMaster(@RequestBody CostCenterMasterDto costCenterMasterDto){
        CostCenterMasterDto saveCostCenterMaster = costCenterMasterService.createCostCenterMaster(costCenterMasterDto);
        return new ResponseEntity<>(saveCostCenterMaster, HttpStatus.CREATED);
    }
    //Build GET Master Ids REST API
    @RequestMapping("displayCostCenter/{costCenterName}")
    public ResponseEntity<CostCenterMasterDto> getDataByCostCenterName(@PathVariable String costCenterName){
        CostCenterMasterDto costCenterMasterDto = costCenterMasterService.getCostCenterMaster(costCenterName);
        return ResponseEntity.ok(costCenterMasterDto);
    }

    //Build GET All Master Ids REST API
    @RequestMapping("/allCostCenters")
    public ResponseEntity<List<CostCenterMasterDto>> getAllCostCenterMasters(){
        List<CostCenterMasterDto> allCostCenters = costCenterMasterService.getAllCostCenterMaster();
        return ResponseEntity.ok(allCostCenters);
    }

    //Build UPDATE Master REST API
    @PutMapping("/alterCostCenterMaster/{costCenterName}")
    public ResponseEntity<CostCenterMasterDto> updateCostCenterMaster(@PathVariable String costCenterName,CostCenterMasterDto updatedCostCenter){
        CostCenterMasterDto costCenterMasterDto = costCenterMasterService.updateCostCenterMaster(costCenterName,updatedCostCenter);
        return ResponseEntity.ok(costCenterMasterDto);
    }

    //Build DELETE Ledger REST API
    @DeleteMapping("deleteCostCenter/{id}")
    public ResponseEntity<String> deleteCostCenterMaster(@PathVariable Long id){
        costCenterMasterService.deleteByCostCenterMaster(id);
        return ResponseEntity.ok("Cost center master deleted successfully!");
    }
}