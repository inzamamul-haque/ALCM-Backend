package com.ibcs.rm.Service;

import com.ibcs.rm.Entity.FunctionalRequirement;
import com.ibcs.rm.Repository.FunctionalRequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionalRequirementService {
    @Autowired
    FunctionalRequirementRepository functionalRequirementRepository;
    public FunctionalRequirement createNewFr(String name, String description, String frId, String title ) {
        FunctionalRequirement functionalRequirement = new FunctionalRequirement();
        functionalRequirement.setName(name);
        functionalRequirement.setFrId(frId);
        functionalRequirement.setFrTitle(title);
        functionalRequirement.setDescription(description);
        functionalRequirementRepository.save(functionalRequirement);
        return  functionalRequirement;
    }

    public List<FunctionalRequirement> getAllFr() {
        List<FunctionalRequirement> functionalRequirementList = functionalRequirementRepository.findAll();
        return functionalRequirementList;
    }
}
