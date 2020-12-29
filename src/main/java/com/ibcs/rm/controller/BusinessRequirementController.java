package com.ibcs.rm.controller;

import com.ibcs.rm.domain.model.BusinessRequirement;
import com.ibcs.rm.pojo.request.BrPojo;
import com.ibcs.rm.services.BusinessRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/business.requirement")
public class BusinessRequirementController {

    @Autowired
    BusinessRequirementService businessRequirementService;

    @PostMapping("/createNewBusiness")
    public BusinessRequirement createNewBusiness(@RequestBody BrPojo pojo) {
       return businessRequirementService.createNewBusiness(pojo);
    }

    @GetMapping("/getAllBusinessRequirement")
    public List<BusinessRequirement> getAllBusinessRequirement() {
        return businessRequirementService.getAllBusinessRequirement();
    }
    @GetMapping("/getSequenceNumber")
    public BrPojo getSequenceNumber() {
        return businessRequirementService.getSequenceNumber();
    }

    @PostMapping("/updateProject")
    public void updateProject(@RequestBody BrPojo pojo) {
        businessRequirementService.updateProject(pojo);
    }

    @PostMapping("/getBrProjectById")
    public BusinessRequirement getBrProjectByID(@RequestBody BrPojo pojo) {
        return businessRequirementService.getBrProjectByID(pojo);
    }

}
