package com.example.A_One.controller;

import com.example.A_One.dto.SundryCreditorMasterDto;
import com.example.A_One.service.SundryCreditorMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("sundryCreditorMasterApi")
public class SundryCreditorMasterController {

    @Autowired
    private SundryCreditorMasterService sundryCreditorMasterService;

    @PostMapping("/addSundryCreditor")
    public ResponseEntity<SundryCreditorMasterDto> createSundryCreditorMaster(@RequestBody SundryCreditorMasterDto sundryCreditorMasterDto){
        SundryCreditorMasterDto saveSundryCreditorMaster = sundryCreditorMasterService.createSundryCreditorMaster(sundryCreditorMasterDto);
        return new ResponseEntity<>(saveSundryCreditorMaster, HttpStatus.CREATED);
    }

    @RequestMapping("displaySundryCreditor/{sundryCreditorName}")
    public ResponseEntity<SundryCreditorMasterDto> findDataBySundryCreditorName(@PathVariable String sundryCreditorName){
        SundryCreditorMasterDto sundryCreditorMasterDto = sundryCreditorMasterService.getSundryCreditorName(sundryCreditorName);
        return ResponseEntity.ok(sundryCreditorMasterDto);
    }

    @RequestMapping("/allSundryCreditors")
    public ResponseEntity<List<SundryCreditorMasterDto>> getAllSundryCreditorMaster(){
        List<SundryCreditorMasterDto> allSundryCreditorMaster = sundryCreditorMasterService.getAllSundryCreditorMaster();
        return ResponseEntity.ok(allSundryCreditorMaster);
    }

    @PutMapping("/alterSundryCreditorMaster/{sundryCreditorName}")
    public ResponseEntity<SundryCreditorMasterDto> updateSundryCreditorMaster(@PathVariable String sundryCreditorName, @RequestBody SundryCreditorMasterDto updateSundryCreditorMaster){
        SundryCreditorMasterDto sundryCreditorMasterDto = sundryCreditorMasterService.updateSundryCreditorMaster(sundryCreditorName,updateSundryCreditorMaster);
        return ResponseEntity.ok(sundryCreditorMasterDto);
    }

    @DeleteMapping("/deleteSundryCreditor/{id}")
    public ResponseEntity<String> deleteSundryCreditorMaster(@PathVariable Long id){
        sundryCreditorMasterService.deleteBySundryCreditorMaster(id);
        return ResponseEntity.ok("Sundry creditor master deleted successfully!");
    }
}