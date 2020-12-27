package com.ibcs.rm.Service;

import com.ibcs.rm.Entity.NonFunctionalRequirement;
import com.ibcs.rm.Repository.NonFunctionalRequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonFunctionalRequirementService {
    @Autowired
    NonFunctionalRequirementRepository nonFunctionalRequirementRepository;
    public NonFunctionalRequirement createNewNonFr(String name, String description, String frId, String title) {
        NonFunctionalRequirement nonFunctionalRequirement = new NonFunctionalRequirement();
        nonFunctionalRequirement.setName(name);
        nonFunctionalRequirement.setDescription(description);
        nonFunctionalRequirement.setNonFrId(frId);
        nonFunctionalRequirement.setNonFrTitle(title);
        nonFunctionalRequirementRepository.save(nonFunctionalRequirement);
        return  nonFunctionalRequirement;

    }

    public List<NonFunctionalRequirement> getAllNonFr() {
        List<NonFunctionalRequirement> nonFunctionalRequirementList = nonFunctionalRequirementRepository.findAll();
        return nonFunctionalRequirementList;
    }

}
