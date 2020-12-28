package com.ibcs.rm.services;

import com.ibcs.rm.domain.model.BusinessRequirement;
import com.ibcs.rm.pojo.request.BrPojo;
import com.ibcs.rm.domain.repository.BusinessRequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BusinessRequirementService {

    @Autowired
    BusinessRequirementRepository businessRequirementRepository;

    @Transactional
    public BusinessRequirement createNewBusiness(BrPojo pojo) {
        BusinessRequirement businessRequirement =new BusinessRequirement();
        businessRequirement.setName(pojo.name);
        businessRequirement.setBrId(pojo.brId);
        businessRequirement.setBrTitle(pojo.brTitle);
        businessRequirement.setDescription(pojo.description);
        businessRequirementRepository.save(businessRequirement);
        return businessRequirement;

    }

    public List<BusinessRequirement> getAllBusinessRequirement() {
        List<BusinessRequirement> businessRequirementList = businessRequirementRepository.findAll();
        return businessRequirementList;
    }
}
