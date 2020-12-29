package com.ibcs.rm.controller;

import com.ibcs.rm.domain.model.NonFunctionalRequirement;
import com.ibcs.rm.pojo.request.NonFrPojo;
import com.ibcs.rm.services.NonFunctionalRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Nonfunctional.requirement")
public class NonFunctionalRequirementController {
    @Autowired
    NonFunctionalRequirementService nonFunctionalRequirementService;

    @PostMapping("/createNewNonFr")
    public NonFunctionalRequirement createNewFr(@RequestBody NonFrPojo pojo) {
        return nonFunctionalRequirementService.createNewNonFr(pojo);
    }

    @GetMapping("/getAllNonFr")
    public List<NonFunctionalRequirement> getAllNonFr() {
        return nonFunctionalRequirementService.getAllNonFr();

    }
    @GetMapping("/getSequenceNumber")
    public String getSequenceNumber(String type) {
        return nonFunctionalRequirementService.getSequenceNumber(type);
    }
}
