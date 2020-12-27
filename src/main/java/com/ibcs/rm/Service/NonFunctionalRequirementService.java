package com.ibcs.rm.Service;

import com.ibcs.rm.Entity.NonFunctionalRequirement;
import com.ibcs.rm.Pojo.NonFrPojo;
import com.ibcs.rm.Repository.NonFunctionalRequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonFunctionalRequirementService {
    @Autowired
    NonFunctionalRequirementRepository nonFunctionalRequirementRepository;
    public NonFunctionalRequirement createNewNonFr(NonFrPojo pojo) {
        NonFunctionalRequirement nonFunctionalRequirement = new NonFunctionalRequirement();
        nonFunctionalRequirement.setName(pojo.name);
        nonFunctionalRequirement.setDescription(pojo.description);
        nonFunctionalRequirement.setNonFrId(pojo.nonFrId);
        nonFunctionalRequirement.setNonFrTitle(pojo.nonFrTitle);
        nonFunctionalRequirementRepository.save(nonFunctionalRequirement);
        return  nonFunctionalRequirement;

    }

    public List<NonFunctionalRequirement> getAllNonFr() {
        List<NonFunctionalRequirement> nonFunctionalRequirementList = nonFunctionalRequirementRepository.findAll();
        return nonFunctionalRequirementList;
    }

}
