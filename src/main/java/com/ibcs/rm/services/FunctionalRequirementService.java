package com.ibcs.rm.services;

import com.ibcs.rm.domain.model.BusinessRequirement;
import com.ibcs.rm.domain.model.FunctionalRequirement;
import com.ibcs.rm.domain.repository.BusinessRequirementRepository;
import com.ibcs.rm.pojo.request.FrPojo;
import com.ibcs.rm.domain.repository.FunctionalRequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FunctionalRequirementService {
    @Autowired
    FunctionalRequirementRepository functionalRequirementRepository;

    @Autowired
    BusinessRequirementRepository businessRequirementRepository;

    @Transactional
    public FunctionalRequirement createNewFr(FrPojo pojo) {
        FunctionalRequirement functionalRequirement = new FunctionalRequirement();
        Optional<BusinessRequirement> businessRequirementOptional = businessRequirementRepository.findById(pojo.projectId);
        BusinessRequirement businessRequirement = businessRequirementOptional.get();
        functionalRequirement.setBusinessRequirement(businessRequirement);
        functionalRequirement.setName(pojo.name);
        functionalRequirement.setFrId(pojo.frId);
        functionalRequirement.setFrTitle(pojo.frTitle);
        functionalRequirement.setFileUrl(pojo.fileUrl);
        functionalRequirement.setDescription(pojo.description);
        functionalRequirementRepository.save(functionalRequirement);
        return  functionalRequirement;
    }

    public List<FunctionalRequirement> getAllFr() {
        List<FunctionalRequirement> functionalRequirementList = functionalRequirementRepository.findAll();
        return functionalRequirementList;
    }
    public FrPojo getSequenceNumber() {
        List<FunctionalRequirement> functionalRequirementList = functionalRequirementRepository.findAll();
        int d = functionalRequirementList.size() + 1;
        String pattern = "-00000";
        String cd = "FR-" + pattern + String.valueOf(d);
        FrPojo pojo = new FrPojo();
        pojo.frId = cd;
        return pojo;
    }

    public FunctionalRequirement getProjectById(FrPojo pojo) {
        Optional<FunctionalRequirement> optionalFunctionalRequirement = functionalRequirementRepository.findById(pojo.projectId);
        FunctionalRequirement functionalRequirement = optionalFunctionalRequirement.get();
        return functionalRequirement;
    }

    public void updateProject(FrPojo pojo) {
        Optional<FunctionalRequirement> projectOptional = functionalRequirementRepository.findById(pojo.projectId);
        FunctionalRequirement functionalRequirement = projectOptional.get();
        functionalRequirement.setName(pojo.name);
        functionalRequirement.setFrId(pojo.frId);
        functionalRequirement.setFrTitle(pojo.frTitle);
        functionalRequirement.setDescription(pojo.description);
        functionalRequirement.setFileUrl(pojo.fileUrl);
        functionalRequirementRepository.save(functionalRequirement);
    }

    public void deleteProject(FrPojo pojo) {
        Optional<FunctionalRequirement> optionalFunctionalRequirement = functionalRequirementRepository.findById(pojo.projectId);
        FunctionalRequirement functionalRequirement = optionalFunctionalRequirement.get();
        functionalRequirementRepository.delete(functionalRequirement);

    }
}
