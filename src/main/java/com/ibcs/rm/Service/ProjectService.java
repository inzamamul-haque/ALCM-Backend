package com.ibcs.rm.Service;

import com.ibcs.rm.Entity.Project;
import com.ibcs.rm.Pojo.ProjectPojo;
import com.ibcs.rm.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    public Project createNewProject(ProjectPojo pojo) {
        Project project = new Project();
        project.setName(pojo.getName());
        project.setDescription(pojo.getDescription());
        projectRepository.save(project);
        return project;
    }
}
