package com.example.A_One.controller;

import com.example.A_One.dto.SundryDebtorMasterDto;
import com.example.A_One.service.SundryDebtorMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("sundryDebtorMasterApi")
public class SundryDebtorMasterController {

    @Autowired
    private SundryDebtorMasterService sundryDebtorMasterService;

    @PostMapping("/addSundryDebtor")
    public ResponseEntity<SundryDebtorMasterDto> createSundryDebtorMaster(@RequestBody SundryDebtorMasterDto sundryDebtorMasterDto){
        SundryDebtorMasterDto saveSundryDebtorMaster = sundryDebtorMasterService.createSundryDebtorMaster(sundryDebtorMasterDto);
        return new ResponseEntity<>(saveSundryDebtorMaster, HttpStatus.CREATED);
    }

    @RequestMapping("/displaySundryDebtor/{sundryDebtorName}")
    public ResponseEntity<SundryDebtorMasterDto> getDataBySundryDebtorName(@PathVariable String sundryDebtorName){
        SundryDebtorMasterDto sundryDebtorMasterDto = sundryDebtorMasterService.getSundryDebtorName(sundryDebtorName);
        return ResponseEntity.ok(sundryDebtorMasterDto);
    }

    @RequestMapping("/allSundryDebtors")
    public ResponseEntity<List<SundryDebtorMasterDto>> getAllSundryDebtorMaster(){
        List<SundryDebtorMasterDto> allSundryDebtors = sundryDebtorMasterService.getAllSundryDebtorMaster();
        return ResponseEntity.ok(allSundryDebtors);
    }

    @PutMapping("/alterSundryDebtorMaster/{sundryDebtorName}")
    public ResponseEntity<SundryDebtorMasterDto> updateSundryDebtorMaster(@PathVariable String sundryDebtorName, @RequestBody SundryDebtorMasterDto updateSundryDebtorMaster){
        SundryDebtorMasterDto sundryDebtorMasterDto = sundryDebtorMasterService.updateSundryDebtorMaster(sundryDebtorName,updateSundryDebtorMaster);
        return ResponseEntity.ok(sundryDebtorMasterDto);
    }

    @DeleteMapping("/deleteSundryDebtor/{id}")
    public ResponseEntity<String> deleteSundryDebtorMaster(@PathVariable Long id){
        sundryDebtorMasterService.deleteBySundryDebtorMaster(id);
        return ResponseEntity.ok("Sundry debtor master deleted successfully!");
    }
}