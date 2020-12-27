package com.ibcs.rm.Controller;

import com.ibcs.rm.Entity.NonFunctionalRequirement;
import com.ibcs.rm.Pojo.NonFrPojo;
import com.ibcs.rm.Service.NonFunctionalRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
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
}
