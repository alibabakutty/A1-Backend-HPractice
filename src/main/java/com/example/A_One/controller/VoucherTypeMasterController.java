package com.example.A_One.controller;

import com.example.A_One.dto.VoucherTypeMasterDto;
import com.example.A_One.service.VoucherTypeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/voucherTypeMasterApi")
public class VoucherTypeMasterController {
    @Autowired
    private VoucherTypeMasterService voucherTypeMasterService;

    //Build ADD Masters REST API
    @PostMapping("/addVoucherTypeMaster")
    public ResponseEntity<VoucherTypeMasterDto> createVoucher(@RequestBody VoucherTypeMasterDto voucherTypeMasterDto){
        VoucherTypeMasterDto saveVoucher = voucherTypeMasterService.createVoucherTypeMaster(voucherTypeMasterDto);
        return new ResponseEntity<>(saveVoucher, HttpStatus.CREATED);
    }

    //Build GET Master Ids REST API
    @RequestMapping("/displayVoucher/{voucherTypeName}")
    public ResponseEntity<VoucherTypeMasterDto> getDataByVoucherTypeName(@PathVariable String voucherTypeName){
        VoucherTypeMasterDto voucherTypeMasterDto = voucherTypeMasterService.getVoucherTypeName(voucherTypeName);
        return ResponseEntity.ok(voucherTypeMasterDto);
    }

    //Build GET All Master Ids REST API
    @RequestMapping("/allVouchers")
    public ResponseEntity<List<VoucherTypeMasterDto>> getAllVoucherTypeMaster(){
        List<VoucherTypeMasterDto> allVoucherTypeMasters = voucherTypeMasterService.getAllVoucherTypeMasters();
        return ResponseEntity.ok(allVoucherTypeMasters);
    }

    //Build UPDATE Master REST API
    @PutMapping("/alterVoucherTypeMaster/{voucherTypeName}")
    public ResponseEntity<VoucherTypeMasterDto> updateVoucher(@PathVariable String voucherTypeName, @RequestBody VoucherTypeMasterDto updateVoucherTypeMaster){
        VoucherTypeMasterDto voucherTypeMasterDto = voucherTypeMasterService.updateVoucherTypeMaster(voucherTypeName,updateVoucherTypeMaster);
        return ResponseEntity.ok(voucherTypeMasterDto);
    }

    //Build DELETE Ledger REST API
    @DeleteMapping("deleteVoucher/{id}")
    public ResponseEntity<String> deleteVoucher(@PathVariable Long id){
        voucherTypeMasterService.deleteByVoucherTypeMaster(id);
        return ResponseEntity.ok("voucher deleted successfully!");
    }
}
