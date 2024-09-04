package com.example.A_One.controller;

import com.example.A_One.dto.BatchSizeMasterDto;
import com.example.A_One.service.BatchSizeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("batchSizeMasterApi")
public class BatchSizeMasterController {

    @Autowired
    private BatchSizeMasterService batchSizeMasterService;

    //Build ADD Masters REST API
    @PostMapping("/addBatchSize")
    public ResponseEntity<BatchSizeMasterDto> createBatchSizeMaster(@RequestBody BatchSizeMasterDto batchSizeMasterDto){
        BatchSizeMasterDto saveBatchSizeMaster = batchSizeMasterService.createBatchSizeMaster(batchSizeMasterDto);
        return new ResponseEntity<>(saveBatchSizeMaster, HttpStatus.CREATED);
    }

    //Build GET Master Ids REST API
    @RequestMapping("displayBatchSize/{batchSizeName}")
    public ResponseEntity<BatchSizeMasterDto> getDataByBatchSizeName(@PathVariable String batchSizeName){
        BatchSizeMasterDto batchSizeMasterDto = batchSizeMasterService.getBatchSizeName(batchSizeName);
        return ResponseEntity.ok(batchSizeMasterDto);
    }

    //Build GET All Master Ids REST API
    @RequestMapping("/allBatchSizes")
    public ResponseEntity<List<BatchSizeMasterDto>> getAllBatchSizeMasters(){
        List<BatchSizeMasterDto> allBatchSizeMasters = batchSizeMasterService.getAllBatchSizeMaster();
        return ResponseEntity.ok(allBatchSizeMasters);
    }

    //Build UPDATE Master REST API
    @PutMapping("/alterBatchSizeMaster/{batchSizeName}")
    public ResponseEntity<BatchSizeMasterDto> updateBatchSizeMaster(@PathVariable String batchSizeName, @RequestBody BatchSizeMasterDto updateBatchSizeMaster){
        BatchSizeMasterDto batchSizeMasterDto = batchSizeMasterService.updateBatchSizeMaster(batchSizeName,updateBatchSizeMaster);
        return ResponseEntity.ok(batchSizeMasterDto);
    }

    //Build DELETE Ledger REST API
    @DeleteMapping("/deleteBatchSize/{id}")
    public ResponseEntity<String> deleteBatchSizeMaster(@PathVariable Long id){
        batchSizeMasterService.deleteByBatchSizeMaster(id);
        return ResponseEntity.ok("Batch size master deleted successfully!");
    }
}