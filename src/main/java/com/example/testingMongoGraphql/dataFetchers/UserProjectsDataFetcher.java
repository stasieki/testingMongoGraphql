package com.example.testingMongoGraphql.dataFetchers;

import com.example.testingMongoGraphql.models.Project;
import com.example.testingMongoGraphql.models.User;
import com.example.testingMongoGraphql.services.ProjectService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserProjectsDataFetcher implements DataFetcher<List<Project>> {

    public final ProjectService projectService;

    @Autowired
    public UserProjectsDataFetcher(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public List<Project> get(DataFetchingEnvironment env) {
        User user = env.getSource();
        List<String> projectsIds = new ArrayList<>();
        ;
        if (user != null) {
            projectsIds = user.getProjectsListIds();
        }
        List<Project> projectList = projectService.findByIdInProject(projectsIds);
        return projectList;
    }
}
