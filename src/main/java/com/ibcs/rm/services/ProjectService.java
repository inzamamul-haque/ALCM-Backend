package com.ibcs.rm.services;

import com.ibcs.rm.domain.model.Project;
import com.ibcs.rm.pojo.request.ProjectPojo;
import com.ibcs.rm.domain.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Project> getAllPmp() {
        List<Project> projectList = projectRepository.findAll();
        return projectList;
    }
}
