package com.ibcs.rm.services;

import com.ibcs.rm.domain.model.NonFunctionalRequirement;
import com.ibcs.rm.domain.repository.BusinessRequirementRepository;
import com.ibcs.rm.domain.repository.NonFunctionalRequirementRepository;
import com.ibcs.rm.pojo.request.NonFrPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class NonFunctionalRequirementService {
    @Autowired
    NonFunctionalRequirementRepository nonFunctionalRequirementRepository;

    @Autowired
    BusinessRequirementRepository businessRequirementRepository;

    @Transactional
    public NonFunctionalRequirement createNewNonFr(NonFrPojo pojo) {
        //TODO : Need to add BusinessRequirement which find by brId
        NonFunctionalRequirement nonFunctionalRequirement = new NonFunctionalRequirement();
        nonFunctionalRequirement.setDescription(pojo.description);
        nonFunctionalRequirement.setNonFrId(pojo.nonFrId);
        nonFunctionalRequirement.setNonFrTitle(pojo.nonFrTitle);
        //nonFunctionalRequirement.setBusinessRequirement(pojo.nonFrTitle);
        nonFunctionalRequirementRepository.save(nonFunctionalRequirement);
        return  nonFunctionalRequirement;

    }

    public List<NonFunctionalRequirement> getAllNonFr() {
        List<NonFunctionalRequirement> nonFunctionalRequirementList = nonFunctionalRequirementRepository.findAll();
        return nonFunctionalRequirementList;
    }
    public String getSequenceNumber(String type) {
        String nfr = "NFR";
        if (type.equals(nfr)) {
            List<NonFunctionalRequirement> businessRequirementList = nonFunctionalRequirementRepository.findAll();
            int d = businessRequirementList.size() + 1;
            String pattern = "-00000";
            String cd = type + pattern + String.valueOf(d);
            return cd;
        }
        return null;
    }
}
