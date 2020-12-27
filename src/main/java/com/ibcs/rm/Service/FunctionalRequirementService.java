package com.ibcs.rm.Service;

import com.ibcs.rm.Entity.FunctionalRequirement;
import com.ibcs.rm.Pojo.FrPojo;
import com.ibcs.rm.Repository.FunctionalRequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionalRequirementService {
    @Autowired
    FunctionalRequirementRepository functionalRequirementRepository;

    public FunctionalRequirement createNewFr(FrPojo pojo) {
        FunctionalRequirement functionalRequirement = new FunctionalRequirement();
        functionalRequirement.setName(pojo.name);
        functionalRequirement.setFrId(pojo.frId);
        functionalRequirement.setFrTitle(pojo.frTitle);
        functionalRequirement.setDescription(pojo.description);
        functionalRequirementRepository.save(functionalRequirement);
        return  functionalRequirement;
    }

    public List<FunctionalRequirement> getAllFr() {
        List<FunctionalRequirement> functionalRequirementList = functionalRequirementRepository.findAll();
        return functionalRequirementList;
    }
}
