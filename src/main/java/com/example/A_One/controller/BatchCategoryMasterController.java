package com.example.A_One.controller;

import com.example.A_One.dto.BatchCategoryMasterDto;
import com.example.A_One.service.BatchCategoryMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("batchCategoryMasterApi")
public class BatchCategoryMasterController {

    @Autowired
    private BatchCategoryMasterService batchCategoryMasterService;

    //Build ADD Masters REST API
    @PostMapping("/addBatchCategory")
    public ResponseEntity<BatchCategoryMasterDto> createBatchCategoryMaster(@RequestBody BatchCategoryMasterDto batchCategoryMasterDto){
        BatchCategoryMasterDto saveBatchCategoryMaster = batchCategoryMasterService.createBatchCategoryMaster(batchCategoryMasterDto);
        return new ResponseEntity<>(saveBatchCategoryMaster, HttpStatus.CREATED);
    }

    //Build GET Master Ids REST API
    @RequestMapping("displayBatchCategory/{batchCategoryName}")
    public ResponseEntity<BatchCategoryMasterDto> getDataByBatchCategoryName(@PathVariable String batchCategoryName){
        BatchCategoryMasterDto batchCategoryMasterDto = batchCategoryMasterService.getBatchCategoryName(batchCategoryName);
        return ResponseEntity.ok(batchCategoryMasterDto);
    }

    //Build GET All Master Ids REST API
    @RequestMapping("/allBatchCategories")
    public ResponseEntity<List<BatchCategoryMasterDto>> getAllBatchCategoryMaster(){
        List<BatchCategoryMasterDto> allBatchCategoryMaster = batchCategoryMasterService.getAllBatchCategoryMaster();
        return ResponseEntity.ok(allBatchCategoryMaster);
    }

    //Build UPDATE Master REST API
    @PutMapping("/alterBatchCategoryMaster/{batchCategoryName}")
    public ResponseEntity<BatchCategoryMasterDto> updateBatchCategoryMaster(@PathVariable String batchCategoryName,@RequestBody BatchCategoryMasterDto updateBatchCategoryMaster){
        BatchCategoryMasterDto batchCategoryMasterDto = batchCategoryMasterService.updateBatchCategoryMaster(batchCategoryName,updateBatchCategoryMaster);
        return ResponseEntity.ok(batchCategoryMasterDto);
    }

    //Build DELETE Ledger REST API
    @DeleteMapping("deleteBatchCategory/{id}")
    public ResponseEntity<String> deleteBatchCategoryMaster(@PathVariable Long id){
        batchCategoryMasterService.deleteBatchCategoryMaster(id);
        return ResponseEntity.ok("Batch category master deleted successfully!");
    }
}