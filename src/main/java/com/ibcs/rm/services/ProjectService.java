package com.ibcs.rm.services;

import com.ibcs.rm.domain.model.Project;
import com.ibcs.rm.domain.repository.ProjectRepository;
import com.ibcs.rm.pojo.request.ProjectPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Transactional
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

    public Project getProjectById(ProjectPojo pojo) {
        Optional<Project> project = projectRepository.findById(pojo.projectId);
        Project project1 = project.get();
        return project1;
    }

    @Transactional
    public void updateProject(ProjectPojo pojo) {
        Optional<Project> project = projectRepository.findById(pojo.projectId);
        Project project1 = project.get();
        project1.setName(pojo.getName());
        project1.setDescription(pojo.getDescription());
        projectRepository.save(project1);
    }

    public void deleteProject(ProjectPojo pojo) {
        Optional<Project> project = projectRepository.findById(pojo.projectId);
        Project project1 = project.get();
        projectRepository.delete(project1);
    }
}
