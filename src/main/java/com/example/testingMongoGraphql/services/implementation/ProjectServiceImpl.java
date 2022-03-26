package com.example.testingMongoGraphql.services.implementation;


import com.example.testingMongoGraphql.models.Project;
import com.example.testingMongoGraphql.repositories.ProjectRepository;
import com.example.testingMongoGraphql.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> findByIdInProject(List<String> projectsListIds) {
        return projectRepository.findById(projectsListIds);
    }

    @Override
    public List<Project> findAllProjects() {
        return (List<Project>) projectRepository.findAll();
    }
}
