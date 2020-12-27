package com.ibcs.rm.Controller;

import com.ibcs.rm.Entity.BusinessRequirement;
import com.ibcs.rm.Pojo.BrPojo;
import com.ibcs.rm.Service.BusinessRequirementService;
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
