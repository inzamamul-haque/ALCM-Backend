package com.ibcs.rm.controller;

import com.ibcs.rm.domain.model.FunctionalRequirement;
import com.ibcs.rm.pojo.request.FrPojo;
import com.ibcs.rm.services.FunctionalRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/functional.requirement")
public class FunctionalRequirementController {
    @Autowired
    FunctionalRequirementService functionalRequirementService;

    @PostMapping("/createNewFr")
    public FunctionalRequirement createNewFr(@RequestBody FrPojo pojo) {
        return functionalRequirementService.createNewFr(pojo);
    }

    @GetMapping("/getAllFr")
    public List<FunctionalRequirement> getAllFr() {
        return functionalRequirementService.getAllFr();
    }
    @GetMapping("/getSequenceNumber")
    public FrPojo getSequenceNumber() {
        return functionalRequirementService.getSequenceNumber();
    }
    @PostMapping("/getProjectById")
    public FunctionalRequirement getProjectById(@RequestBody FrPojo pojo) {
        return functionalRequirementService.getProjectById(pojo);
    }

    @PutMapping(value = "/update")
    public void updateProject(@RequestBody FrPojo pojo) {
        functionalRequirementService.updateProject(pojo);
    }
    @PostMapping(value = "/delete")
    public void deleteProject(@RequestBody FrPojo pojo){
        functionalRequirementService.deleteProject(pojo);
    }

}

