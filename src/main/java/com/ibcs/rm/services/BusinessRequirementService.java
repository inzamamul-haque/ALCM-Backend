package com.ibcs.rm.services;

import com.ibcs.rm.domain.model.BusinessRequirement;
import com.ibcs.rm.domain.model.Project;
import com.ibcs.rm.domain.repository.BusinessRequirementRepository;
import com.ibcs.rm.domain.repository.ProjectRepository;
import com.ibcs.rm.pojo.request.BrPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BusinessRequirementService {

    @Autowired
    BusinessRequirementRepository businessRequirementRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Transactional
    public BusinessRequirement createNewBusiness(BrPojo pojo) {

        BusinessRequirement businessRequirement =new BusinessRequirement();
        businessRequirement.setName(pojo.name);
        businessRequirement.setBrId(pojo.brId);
        businessRequirement.setBrTitle(pojo.brTitle);
        businessRequirement.setDescription(pojo.description);
        businessRequirement.setFileUrl(pojo.fileUrl);
        Optional<Project> pro = projectRepository.findById(pojo.projectId);
        Project project = pro.get();
        businessRequirement.setProject(project);
        businessRequirementRepository.save(businessRequirement);
        return businessRequirement;
    }

    public List<BusinessRequirement> getAllBusinessRequirement() {
        List<BusinessRequirement> businessRequirementList = businessRequirementRepository.findAll();
        return businessRequirementList;
    }

    public BrPojo getSequenceNumber() {
        List<BusinessRequirement> businessRequirementList = businessRequirementRepository.findAll();
        int d = businessRequirementList.size() + 1;
        String pattern = "-00000";
        String cd = "BR-" + pattern + String.valueOf(d);
        BrPojo pojo = new BrPojo();
        pojo.brId = cd;
        return pojo;
    }

    public void updateProject(BrPojo pojo) {
        Optional<BusinessRequirement> businessRequirement = businessRequirementRepository.findById(pojo.id);
        BusinessRequirement businessRequirement1 = businessRequirement.get();
        businessRequirement1.setName(pojo.name);
        businessRequirement1.setDescription(pojo.description);
        businessRequirement1.setBrTitle(pojo.brTitle);
        businessRequirement1.setBrId(pojo.brId);
        businessRequirementRepository.save(businessRequirement1);
    }

    public BusinessRequirement getBrProjectByID(BrPojo pojo) {
        Optional<BusinessRequirement> businessRequirement = businessRequirementRepository.findById(pojo.projectId);
        BusinessRequirement businessRequirement1 = businessRequirement.get();
        return businessRequirement1;
    }

    public void deleteProject(BrPojo pojo) {
    Optional<BusinessRequirement> optionalBusinessRequirement = businessRequirementRepository.findById(pojo.projectId);
    BusinessRequirement businessRequirement = optionalBusinessRequirement.get();
    businessRequirementRepository.delete(businessRequirement);
    }

}
