package com.example.A_One.controller;

import com.example.A_One.dto.BatchSerialNumberMasterDto;
import com.example.A_One.service.BatchSerialNumberMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("batchSerialNumberMasterApi")
public class BatchSerialNumberMasterController {

    @Autowired
    private BatchSerialNumberMasterService batchSerialNumberMasterService;

    //Build ADD Masters REST API
    @PostMapping("/addBatchSerialNumber")
    public ResponseEntity<BatchSerialNumberMasterDto> createBatchSerialNumberMaster(@RequestBody BatchSerialNumberMasterDto batchSerialNumberMasterDto){
        BatchSerialNumberMasterDto saveBatchSerialNumberMaster = batchSerialNumberMasterService.createBatchSerialNumberMaster(batchSerialNumberMasterDto);
        return new ResponseEntity<>(saveBatchSerialNumberMaster, HttpStatus.CREATED);
    }

    //Build GET Master Ids REST API
    @RequestMapping("displayBatchSerialNumber/{batchSerialNumber}")
    public ResponseEntity<BatchSerialNumberMasterDto> getDataByBatchSerialNumber(@PathVariable String batchSerialNumber){
        BatchSerialNumberMasterDto batchSerialNumberMasterDto = batchSerialNumberMasterService.getBatchSerialNumber(batchSerialNumber);
        return ResponseEntity.ok(batchSerialNumberMasterDto);
    }

    //Build GET All Master Ids REST API
    @RequestMapping("/allBatchSerialNumbers")
    public ResponseEntity<List<BatchSerialNumberMasterDto>> getAllBatchSerialNumberMaster(){
        List<BatchSerialNumberMasterDto> allBatchSerialNumberMaster = batchSerialNumberMasterService.getAllBatchSerialNumberMaster();
        return ResponseEntity.ok(allBatchSerialNumberMaster);
    }

    //Build UPDATE Master REST API
    @PutMapping("/alterBatchSerialNumberMaster/{batchSerialNumber}")
    public ResponseEntity<BatchSerialNumberMasterDto> updateBatchSerialNumberMaster(@PathVariable String batchSerialNumber,@RequestBody BatchSerialNumberMasterDto updateBatchSerialNumber){
        BatchSerialNumberMasterDto batchSerialNumberMasterDto = batchSerialNumberMasterService.updateBatchSerialNumberMaster(batchSerialNumber,updateBatchSerialNumber);
        return ResponseEntity.ok(batchSerialNumberMasterDto);
    }

    //Build DELETE Ledger REST API
    @DeleteMapping("/deleteBatchSerialNumber/{id}")
    public ResponseEntity<String> deleteBatchSerialNumberMaster(@PathVariable Long id){
        batchSerialNumberMasterService.deleteByBatchSerialNumberId(id);
        return ResponseEntity.ok("Batch Serial Number Master is deleted successfully!");
    }
}