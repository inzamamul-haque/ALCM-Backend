package com.ibcs.rm.Controller;

import com.ibcs.rm.Entity.NonFunctionalRequirement;
import com.ibcs.rm.Service.NonFunctionalRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NonFunctionalRequirementController {
    @Autowired
    NonFunctionalRequirementService nonFunctionalRequirementService;

    @PostMapping("/createNewNonFr")
    public NonFunctionalRequirement createNewFr(String name, String description, String frId, String title ) {
        return nonFunctionalRequirementService.createNewNonFr(name, description, frId, title);
    }

    @GetMapping("/getAllNonFr")

    public List<NonFunctionalRequirement> getAllNonFr() {
        return nonFunctionalRequirementService.getAllNonFr();

    }
}
