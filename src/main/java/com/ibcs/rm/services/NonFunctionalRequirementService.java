package com.ibcs.rm.services;

import com.ibcs.rm.domain.model.NonFunctionalRequirement;
import com.ibcs.rm.domain.repository.BusinessRequirementRepository;
import com.ibcs.rm.domain.repository.NonFunctionalRequirementRepository;
import com.ibcs.rm.exception.ResourseNotFoundException;
import com.ibcs.rm.pojo.request.NonFrPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        return nonFunctionalRequirement;

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

    public ResponseEntity<Void> deleteNfrById(String id) {
        nonFunctionalRequirementRepository.deleteById(Long.valueOf(id));
        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity<NonFunctionalRequirement> getNonFrById(String id) {
        Optional<NonFunctionalRequirement> optionalNonFunctionalRequirement = nonFunctionalRequirementRepository.findById(Long.valueOf(id));
        return new ResponseEntity(optionalNonFunctionalRequirement.get(), HttpStatus.OK);
    }

    public ResponseEntity<Void> updateNfrById(String id, NonFrPojo nonFrPojo) {
        Optional<NonFunctionalRequirement> optionalNonFunctionalRequirement = nonFunctionalRequirementRepository.findById(Long.valueOf(id));
        if (!optionalNonFunctionalRequirement.isPresent()) {
            throw new ResourseNotFoundException("NRF Not Found");
        }
        NonFunctionalRequirement nonFunctionalRequirement = optionalNonFunctionalRequirement.get();
        nonFunctionalRequirement.setNonFrId(nonFrPojo.getNonFrId());
        nonFunctionalRequirement.setNonFrTitle(nonFrPojo.getNonFrTitle());
        nonFunctionalRequirement.setDescription(nonFrPojo.getDescription());
        nonFunctionalRequirement.setFileUrl(nonFrPojo.getFileUrl());

        nonFunctionalRequirementRepository.save(nonFunctionalRequirement);

        return new ResponseEntity(HttpStatus.OK);

    }
}
