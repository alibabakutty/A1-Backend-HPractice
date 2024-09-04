package com.example.A_One.controller;

import com.example.A_One.dto.ProjectCategoryMasterDto;
import com.example.A_One.service.ProjectCategoryMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("projectCategoryMasterApi")
public class ProjectCategoryMasterController {

    @Autowired
    private ProjectCategoryMasterService projectCategoryMasterService;

    //Build ADD Masters REST API
    @PostMapping("/addProjectCategory")
    public ResponseEntity<ProjectCategoryMasterDto> createProjectCategoryMaster(@RequestBody ProjectCategoryMasterDto projectCategoryMasterDto){
        ProjectCategoryMasterDto saveProjectCategoryMaster = projectCategoryMasterService.createProjectCategoryMaster(projectCategoryMasterDto);
        return new ResponseEntity<>(saveProjectCategoryMaster, HttpStatus.CREATED);
    }

    //Build GET Master Ids REST API
    @RequestMapping("displayProjectCategory/{projectCategoryName}")
    public ResponseEntity<ProjectCategoryMasterDto> getDataByProjectCategoryName(@PathVariable String projectCategoryName){
        ProjectCategoryMasterDto projectCategoryMasterDto = projectCategoryMasterService.getProjectCategoryName(projectCategoryName);
        return ResponseEntity.ok(projectCategoryMasterDto);
    }

    //Build GET All Master Ids REST API
    @RequestMapping("/allProjectCategories")
    public ResponseEntity<List<ProjectCategoryMasterDto>> getAllProjectCategoryMasters(){
        List<ProjectCategoryMasterDto> allProjectCategoryMasters = projectCategoryMasterService.getAllOProjectCategoryMaster();
        return ResponseEntity.ok(allProjectCategoryMasters);
    }

    //Build UPDATE Master REST API
    @PutMapping("/alterProjectCategoryMaster/{projectCategoryName}")
    public ResponseEntity<ProjectCategoryMasterDto> updateProjectCategoryMaster(@PathVariable String projectCategoryName,@RequestBody ProjectCategoryMasterDto updateProjectCategoryMaster){
        ProjectCategoryMasterDto projectCategoryMasterDto = projectCategoryMasterService.updateProjectCategoryMaster(projectCategoryName,updateProjectCategoryMaster);
        return ResponseEntity.ok(projectCategoryMasterDto);
    }

    //Build DELETE Ledger REST API
    @DeleteMapping("deleteProjectCategory/{id}")
    public ResponseEntity<String> deleteProjectCategoryMaster(@PathVariable Long id){
        projectCategoryMasterService.deleteByProjectCategoryMasterId(id);
        return ResponseEntity.ok("Project category master deleted successfully!");
    }
}