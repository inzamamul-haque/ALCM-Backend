package com.ibcs.rm.controller;

import com.ibcs.rm.domain.model.Project;
import com.ibcs.rm.pojo.request.ProjectPojo;
import com.ibcs.rm.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping(value = "/create")
    public Project createProject(@RequestBody ProjectPojo pojo) {
       return projectService.createNewProject(pojo);
    }

    @GetMapping(value = "/getAllPmp")
    public List<Project> getAllPmp() {
        return projectService.getAllPmp();
    }

    @PostMapping(value = "/getProjectById")
    public Project getProjectById(@RequestBody ProjectPojo pojo) {
        return projectService.getProjectById(pojo);
    }

    @PutMapping(value = "/update")
    public void updateProject(@RequestBody ProjectPojo pojo) {
        projectService.updateProject(pojo);
    }

    @PostMapping(value = "/delete")
    public void deleteProject(@RequestBody ProjectPojo pojo){
        projectService.deleteProject(pojo);
    }
}
