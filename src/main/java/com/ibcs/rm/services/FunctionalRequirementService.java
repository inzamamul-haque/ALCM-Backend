package com.ibcs.rm.services;

import com.ibcs.rm.domain.model.FunctionalRequirement;
import com.ibcs.rm.pojo.request.FrPojo;
import com.ibcs.rm.domain.repository.FunctionalRequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FunctionalRequirementService {
    @Autowired
    FunctionalRequirementRepository functionalRequirementRepository;

    @Transactional
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
