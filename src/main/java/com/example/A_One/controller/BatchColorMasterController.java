package com.example.A_One.controller;

import com.example.A_One.dto.BatchColorMasterDto;
import com.example.A_One.service.BatchColorMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("batchColorMasterApi")
public class BatchColorMasterController {

    @Autowired
    private BatchColorMasterService batchColorMasterService;

    //Build ADD Masters REST API
    @PostMapping("/addBatchColor")
    public ResponseEntity<BatchColorMasterDto> createBatchColorMaster(@RequestBody BatchColorMasterDto batchColorMasterDto){
        BatchColorMasterDto saveBatchColorMaster = batchColorMasterService.createBatchColorMaster(batchColorMasterDto);
        return new ResponseEntity<>(saveBatchColorMaster, HttpStatus.CREATED);
    }
    //Build GET Master Ids REST API
    @RequestMapping("displayBatchColor/{batchColorName}")
    public ResponseEntity<BatchColorMasterDto> getDataByBatchColorMaster(@PathVariable String batchColorName){
        BatchColorMasterDto batchColorMasterDto = batchColorMasterService.getBatchColorName(batchColorName);
        return ResponseEntity.ok(batchColorMasterDto);
    }
    //Build GET All Master Ids REST API
    @RequestMapping("/allBatchColors")
    public ResponseEntity<List<BatchColorMasterDto>> getAllBatchColorMasters(){
        List<BatchColorMasterDto> allBatchColorMasters = batchColorMasterService.getAllBatchColorMaster();
        return ResponseEntity.ok(allBatchColorMasters);
    }

    //Build UPDATE Master REST API
    @PutMapping("/alterBatchColorMaster/{batchColorName}")
    public ResponseEntity<BatchColorMasterDto> updateBatchColorMaster(@PathVariable String batchColorName,@RequestBody BatchColorMasterDto updateBatchColorMaster){
        BatchColorMasterDto batchColorMasterDto = batchColorMasterService.updateBatchColorMaster(batchColorName,updateBatchColorMaster);
        return ResponseEntity.ok(batchColorMasterDto);

    }

    //Build DELETE Ledger REST API
    @DeleteMapping("deleteBatchColor/{id}")
    public ResponseEntity<String> deleteBatchColorMaster(@PathVariable Long id){
        batchColorMasterService.deleteByBatchColorNameId(id);
        return ResponseEntity.ok("Batch Color Master deleted successfully!");
    }
}