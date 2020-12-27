package com.ibcs.rm.Controller;

import com.ibcs.rm.Entity.BusinessRequirement;
import com.ibcs.rm.Service.BusinessRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/business.requirement")
public class BusinessRequirementController {

    @Autowired
    BusinessRequirementService businessRequirementService;

    @PostMapping("/createNewBusiness")
    public BusinessRequirement createNewBusiness(String name, String title, String description) {
       return businessRequirementService.createNewBusiness(name, title, description);
    }

    @GetMapping("/getAllBusinessRequirement")
    public List<BusinessRequirement> getAllBusinessRequirement() {
        return businessRequirementService.getAllBusinessRequirement();
    }

}
