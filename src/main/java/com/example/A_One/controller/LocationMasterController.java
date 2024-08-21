package com.example.A_One.controller;

import com.example.A_One.dto.LocationMasterDto;
import com.example.A_One.service.LocationMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("locationMasterApi")
public class LocationMasterController {

    @Autowired
    private LocationMasterService locationMasterService;

    //Build ADD Masters REST API
    @PostMapping("/addGodown")
    public ResponseEntity<LocationMasterDto> createLocation(@RequestBody LocationMasterDto locationMasterDto){
        LocationMasterDto saveLocationMaster = locationMasterService.createLocationMaster(locationMasterDto);
        return new ResponseEntity<>(saveLocationMaster, HttpStatus.CREATED);
    }

    //Build GET Master Ids REST API
    @RequestMapping("displayGodown/{godownName}")
    public ResponseEntity<LocationMasterDto> getDataByGodownName(@PathVariable String godownName){
        LocationMasterDto locationMasterDto = locationMasterService.getGodownName(godownName);
        return ResponseEntity.ok(locationMasterDto);
    }

    //Build GET All Master Ids REST API
    @RequestMapping("/allGodowns")
    public ResponseEntity<List<LocationMasterDto>> getAllGodown(){
        List<LocationMasterDto> allGodown = locationMasterService.getAllLocationMasters();
        return ResponseEntity.ok(allGodown);
    }

    //Build UPDATE Master REST API
    @PutMapping("/alterGodown/{godownName}")
    public ResponseEntity<LocationMasterDto> updateGodown(@PathVariable String godownName, @RequestBody LocationMasterDto updatedLocationMaster){
        LocationMasterDto locationMasterDto = locationMasterService.updateLocationMaster(godownName,updatedLocationMaster);
        return ResponseEntity.ok(locationMasterDto);
    }

    //Build DELETE Ledger REST API
    @DeleteMapping("deleteGodown/{id}")
    public ResponseEntity<String> deleteGodown(@PathVariable Long id){
        locationMasterService.deleteByLocationMaster(id);
        return ResponseEntity.ok("Godown deleted successfully!");
    }
}