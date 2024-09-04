package com.example.A_One.controller;

import com.example.A_One.dto.ProjectNameMasterDto;
import com.example.A_One.service.ProjectNameMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("projectNameMasterApi")
public class ProjectNameMasterController {

    @Autowired
    private ProjectNameMasterService projectNameMasterService;


    //Build ADD Masters REST API
    @PostMapping("/addProjectName")
    public ResponseEntity<ProjectNameMasterDto> createProjectNameMaster(@RequestBody ProjectNameMasterDto projectNameMasterDto){
        ProjectNameMasterDto saveProjectNameMaster = projectNameMasterService.createProjectNameMaster(projectNameMasterDto);
        return new ResponseEntity<>(saveProjectNameMaster, HttpStatus.CREATED);
    }

    //Build GET Master Ids REST API
    @RequestMapping("displayProjectName/{projectName}")
    public ResponseEntity<ProjectNameMasterDto> getDataByProjectName(@PathVariable String projectName){
        ProjectNameMasterDto projectNameMasterDto = projectNameMasterService.getProjectName(projectName);
        return ResponseEntity.ok(projectNameMasterDto);
    }

    //Build GET All Master Ids REST API
    @RequestMapping("/allProjects")
    public ResponseEntity<List<ProjectNameMasterDto>> getAllProjectNameMasters(){
        List<ProjectNameMasterDto> allProjectNames = projectNameMasterService.getAllProjectNameMaster();
        return ResponseEntity.ok(allProjectNames);
    }

    //Build UPDATE Master REST API
    @PutMapping("/alterProjectNameMaster/{projectName}")
    public ResponseEntity<ProjectNameMasterDto> updateProjectNameMaster(@PathVariable String projectName, @RequestBody ProjectNameMasterDto updateProjectName){
        ProjectNameMasterDto projectNameMasterDto = projectNameMasterService.updateProjectNameMaster(projectName,updateProjectName);
        return ResponseEntity.ok(projectNameMasterDto);
    }

    //Build DELETE Ledger REST API
    @DeleteMapping("/deleteProjectName/{id}")
    public ResponseEntity<String> deleteProjectNameMaster(@PathVariable Long id){
        projectNameMasterService.deleteByProjectNameMasterId(id);
        return ResponseEntity.ok("Project name master is deleted successfully!");
    }
}