package com.ibcs.rm.Controller;

import com.ibcs.rm.Entity.FunctionalRequirement;
import com.ibcs.rm.Service.FunctionalRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/functional.requirement")
public class FunctionalRequirementController {
    @Autowired
    FunctionalRequirementService functionalRequirementService;

    @PostMapping("/createNewFr")
    public FunctionalRequirement createNewFr(String name, String description, String frId, String title ) {
        return functionalRequirementService.createNewFr(name, description, frId, title);
    }

    @GetMapping("/getAllFr")

    public List<FunctionalRequirement> getAllFr() {
        return functionalRequirementService.getAllFr();

    }
}

