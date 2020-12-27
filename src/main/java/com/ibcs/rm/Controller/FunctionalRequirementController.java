package com.ibcs.rm.Controller;

import com.ibcs.rm.Entity.FunctionalRequirement;
import com.ibcs.rm.Pojo.FrPojo;
import com.ibcs.rm.Service.FunctionalRequirementService;
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
}

