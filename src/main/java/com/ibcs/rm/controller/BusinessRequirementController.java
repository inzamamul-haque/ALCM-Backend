package com.ibcs.rm.controller;

import com.ibcs.rm.domain.model.BusinessRequirement;
import com.ibcs.rm.pojo.request.BrPojo;
import com.ibcs.rm.services.BusinessRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
