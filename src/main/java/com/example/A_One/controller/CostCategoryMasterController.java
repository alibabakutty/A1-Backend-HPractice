package com.example.A_One.controller;

import com.example.A_One.dto.CostCategoryMasterDto;
import com.example.A_One.service.CostCategoryMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/costCategoryMasterApi")
public class CostCategoryMasterController {

    private final CostCategoryMasterService costCategoryMasterService;

    @Autowired
    public CostCategoryMasterController(CostCategoryMasterService costCategoryMasterService) {
        this.costCategoryMasterService = costCategoryMasterService;
    }

    // Build ADD Master REST API
    @PostMapping("/addCostCategory")
    public ResponseEntity<CostCategoryMasterDto> createCostCategoryMaster(@RequestBody CostCategoryMasterDto costCategoryMasterDto) {
        CostCategoryMasterDto savedCostCategoryMaster = costCategoryMasterService.createCostCategoryMaster(costCategoryMasterDto);
        return new ResponseEntity<>(savedCostCategoryMaster, HttpStatus.CREATED);
    }

    // Build GET Master by Name REST API
    @GetMapping("/displayCostCategory/{costCategoryName}")
    public ResponseEntity<CostCategoryMasterDto> getDataByCostCategoryName(@PathVariable String costCategoryName) {
        CostCategoryMasterDto costCategoryMasterDto = costCategoryMasterService.getCostCategoryMaster(costCategoryName);
        return ResponseEntity.ok(costCategoryMasterDto);
    }

    // Build GET All Masters REST API
    @GetMapping("/allCostCategories")
    public ResponseEntity<List<CostCategoryMasterDto>> getAllCostCategoryMaster() {
        List<CostCategoryMasterDto> allCostCategoryMasters = costCategoryMasterService.getAllCostCategoryMaster();
        return ResponseEntity.ok(allCostCategoryMasters);
    }

    // Build UPDATE Master REST API
    @PutMapping("/alterCostCategoryMaster/{costCategoryName}")
    public ResponseEntity<CostCategoryMasterDto> updateCostCategoryMaster(
            @PathVariable String costCategoryName,
            @RequestBody CostCategoryMasterDto updatedCostCategory) {
        CostCategoryMasterDto updatedCostCategoryMasterDto = costCategoryMasterService.updateCostCategoryMaster(costCategoryName, updatedCostCategory);
        return ResponseEntity.ok(updatedCostCategoryMasterDto);
    }
    @DeleteMapping("deleteCostCategory/{id}")
    public ResponseEntity<String> deleteCostCategoryMaster(@PathVariable Long id){
        costCategoryMasterService.deleteByCostCategoryMaster(id);
        return ResponseEntity.ok("Cost category master deleted successfully!");
    }
}