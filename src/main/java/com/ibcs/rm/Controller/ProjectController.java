package com.ibcs.rm.Controller;

import com.ibcs.rm.Entity.Project;
import com.ibcs.rm.Pojo.ProjectPojo;
import com.ibcs.rm.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
