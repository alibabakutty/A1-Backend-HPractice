package com.example.A_One.controller;

import com.example.A_One.dto.PreDefinedVoucherTypeDto;
import com.example.A_One.service.PreDefinedVoucherTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/preDefinedVoucherTypeApi")
public class PreDefinedVoucherTypeController {

    @Autowired
    private PreDefinedVoucherTypeService preDefinedVoucherTypeService;

    //Build ADD Masters REST API
    @PostMapping("/addPreDefinedVoucherType")
    public ResponseEntity<PreDefinedVoucherTypeDto> createPreDefinedVoucher(@RequestBody PreDefinedVoucherTypeDto preDefinedVoucherTypeDto){
        PreDefinedVoucherTypeDto savePreDefinedVoucher = preDefinedVoucherTypeService.createPreDefinedVoucherType(preDefinedVoucherTypeDto);
        return new ResponseEntity<>(savePreDefinedVoucher, HttpStatus.CREATED);
    }

    //Build GET Master Ids REST API
    @RequestMapping("/displayPreDefinedVoucher/{voucherType}")
    public ResponseEntity<PreDefinedVoucherTypeDto> getDataByVoucherType(@PathVariable String voucherType){
        PreDefinedVoucherTypeDto preDefinedVoucherTypeDto = preDefinedVoucherTypeService.getPreDefinedVoucherTypeName(voucherType);
        return ResponseEntity.ok(preDefinedVoucherTypeDto);
    }

    //Build GET All Master Ids REST API
    @RequestMapping("/allPreDefinedVoucherTypes")
    public ResponseEntity<List<PreDefinedVoucherTypeDto>> getAllPreDefinedVoucherType(){
        List<PreDefinedVoucherTypeDto> allPreDefinedVoucherTypes = preDefinedVoucherTypeService.getAllPreDefinedVoucherTypes();
        return ResponseEntity.ok(allPreDefinedVoucherTypes);
    }

    //Build UPDATE Master REST API
    @PutMapping("/alterPreDefinedVoucher/{voucherTypeName}")
    public ResponseEntity<PreDefinedVoucherTypeDto> updatePreDefinedVoucherType(@PathVariable String voucherType,@RequestBody PreDefinedVoucherTypeDto updatePreDefinedVoucher){
        PreDefinedVoucherTypeDto preDefinedVoucherTypeDto = preDefinedVoucherTypeService.updatePreDefinedVoucherType(voucherType, updatePreDefinedVoucher);
        return ResponseEntity.ok(preDefinedVoucherTypeDto);
    }

    //Build DELETE Ledger REST API
    @DeleteMapping("deletePreDefinedVoucher/{id}")
    public ResponseEntity<String> deletePreDefinedVoucher(@PathVariable Long id){
        preDefinedVoucherTypeService.deleteByPreDefinedVoucherType(id);
        return ResponseEntity.ok("Pre-defined voucher type deleted successfully!");
    }
}
