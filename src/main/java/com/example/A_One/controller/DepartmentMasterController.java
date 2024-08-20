package com.example.A_One.controller;

import com.example.A_One.dto.DepartmentMasterDto;
import com.example.A_One.service.DepartmentMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/departmentMasterApi")
public class DepartmentMasterController {

    @Autowired
    private DepartmentMasterService departmentMasterService;

    //Build ADD Masters REST API
    @PostMapping("/addDepartmentMaster")
    public ResponseEntity<DepartmentMasterDto> createDepartment(@RequestBody DepartmentMasterDto departmentMasterDto){
        DepartmentMasterDto saveDepartment = departmentMasterService.createDepartmentMaster(departmentMasterDto);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }

    //Build GET Master Ids REST API
    @RequestMapping("/displayDepartment/{departmentName}")
    public ResponseEntity<DepartmentMasterDto> getDataByDepartmentName(@PathVariable String departmentName){
        DepartmentMasterDto departmentMasterDto = departmentMasterService.getDepartmentName(departmentName);
        return ResponseEntity.ok(departmentMasterDto);
    }

    //Build GET All Master Ids REST API
    @RequestMapping("/allDepartment")
    public ResponseEntity<List<DepartmentMasterDto>> getAllDepartment(){
        List<DepartmentMasterDto> allDepartment = departmentMasterService.getAllDepartmentMaster();
        return ResponseEntity.ok(allDepartment);
    }

    //Build DELETE Ledger REST API
    @DeleteMapping("deleteDepartment/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id){
        departmentMasterService.deleteByDepartmentMaster(id);
        return ResponseEntity.ok("Department deleted successfully!");
    }
}