package com.example.testingMongoGraphql.dataFetchers;

import com.example.testingMongoGraphql.models.Project;
import com.example.testingMongoGraphql.services.ProjectService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AllProjectsDataFetcher implements DataFetcher<List<Project>> {

    private final ProjectService projectService;

    @Autowired
    public AllProjectsDataFetcher(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public List<Project> get(DataFetchingEnvironment env) {
        Project project =  env.getSource();
        List<Project> projectList = new ArrayList<>();
        if(project !=null){
            projectList = projectService.findByIdInProject(project.getProjectsListIds());
        }else {
            projectList = projectService.findAllProjects();
        }
        return projectList;
    }
}
