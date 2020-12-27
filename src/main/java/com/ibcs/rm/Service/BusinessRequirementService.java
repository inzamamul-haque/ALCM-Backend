package com.ibcs.rm.Service;

import com.ibcs.rm.Entity.BusinessRequirement;
import com.ibcs.rm.Repository.BusinessRequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BusinessRequirementService {

    @Autowired
    BusinessRequirementRepository businessRequirementRepository;

    @Transactional
    public BusinessRequirement createNewBusiness(String name, String title, String description) {
        BusinessRequirement businessRequirement =new BusinessRequirement();
        businessRequirement.setName(name);
        businessRequirement.setBrTitle(title);
        businessRequirement.setDescription(description);
        businessRequirementRepository.save(businessRequirement);
        return businessRequirement;

    }

    public List<BusinessRequirement> getAllBusinessRequirement() {
        List<BusinessRequirement> businessRequirementList = businessRequirementRepository.findAll();
        return businessRequirementList;
    }
}
