package com.ibcs.rm.controller;

import com.ibcs.rm.domain.model.FunctionalRequirement;
import com.ibcs.rm.pojo.request.FrPojo;
import com.ibcs.rm.services.FunctionalRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}

