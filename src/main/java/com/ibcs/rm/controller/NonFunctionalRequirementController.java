package com.ibcs.rm.controller;

import com.ibcs.rm.domain.model.NonFunctionalRequirement;
import com.ibcs.rm.pojo.request.NonFrPojo;
import com.ibcs.rm.services.NonFunctionalRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/Nonfunctional.requirement")
public class NonFunctionalRequirementController {
    @Autowired
    NonFunctionalRequirementService nonFunctionalRequirementService;

    @PostMapping("/createNewNonFr")
    public NonFunctionalRequirement createNewFr(@RequestBody NonFrPojo pojo) {
        return nonFunctionalRequirementService.createNewNonFr(pojo);
    }

    @GetMapping("/getAllNonFr")
    public List<NonFunctionalRequirement> getAllNonFr() {
        return nonFunctionalRequirementService.getAllNonFr();

    }

    @GetMapping("/{id}/view")
    public ResponseEntity<NonFunctionalRequirement> getNonFrById(@PathVariable("id") String id) {
        return nonFunctionalRequirementService.getNonFrById(id);

    }

    @GetMapping("/getSequenceNumber")
    public String getSequenceNumber(String type) {
        return nonFunctionalRequirementService.getSequenceNumber(type);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteNfrById(@PathVariable("id") String id) {
        return nonFunctionalRequirementService.deleteNfrById(id);
    }

    @PutMapping("{id}/update")
    public ResponseEntity<Void> updateNfrById(@PathVariable("id") String id, @RequestBody NonFrPojo nonFrPojo) {
        return nonFunctionalRequirementService.updateNfrById(id, nonFrPojo);
    }
}
