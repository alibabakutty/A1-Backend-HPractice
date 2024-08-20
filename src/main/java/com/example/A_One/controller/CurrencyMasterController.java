package com.example.A_One.controller;

import com.example.A_One.dto.CurrencyMasterDto;
import com.example.A_One.service.CurrencyMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/currencyMasterApi")
public class CurrencyMasterController {

    @Autowired
    private CurrencyMasterService currencyMasterService;

    //Build ADD Masters REST API
    @PostMapping("/addCurrencyMaster")
    public ResponseEntity<CurrencyMasterDto> createCurrency(@RequestBody CurrencyMasterDto currencyMasterDto){
        CurrencyMasterDto saveCurrency = currencyMasterService.createCurrencyMaster(currencyMasterDto);
        return new ResponseEntity<>(saveCurrency, HttpStatus.CREATED);
    }

    //Build GET Master Ids REST API
    @RequestMapping("/displayCurrency/{forexCurrencySymbol}")
    public ResponseEntity<CurrencyMasterDto> getDataByCurrencySymbol(@PathVariable String forexCurrencySymbol){
        CurrencyMasterDto currencyMasterDto = currencyMasterService.getCurrencySymbol(forexCurrencySymbol);
        return ResponseEntity.ok(currencyMasterDto);
    }

    //Build GET All Master Ids REST API
    @RequestMapping("/allCurrency")
    public ResponseEntity<List<CurrencyMasterDto>> getAllCurrencyMaster(){
        List<CurrencyMasterDto> allCurrencyMasters = currencyMasterService.getAllCurrencyMasters();
        return ResponseEntity.ok(allCurrencyMasters);
    }

    //Build UPDATE Master REST API
    @PutMapping("/alterCurrencyMaster/{forexCurrencySymbol}")
    public ResponseEntity<CurrencyMasterDto> updateCurrency(@PathVariable String forexCurrencySymbol, @RequestBody CurrencyMasterDto updateCurrencyMaster){
        CurrencyMasterDto currencyMasterDto = currencyMasterService.updateCurrencyMaster(forexCurrencySymbol,updateCurrencyMaster);
        return ResponseEntity.ok(currencyMasterDto);
    }

    //Build DELETE Ledger REST API
    @DeleteMapping("deleteCurrency/{id}")
    public ResponseEntity<String> deleteCurrency(@PathVariable Long id){
        currencyMasterService.deleteByCurrencyMaster(id);
        return ResponseEntity.ok("Currency deleted successfully!");
    }
}