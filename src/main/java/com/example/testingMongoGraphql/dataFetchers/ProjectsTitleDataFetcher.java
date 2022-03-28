package com.example.testingMongoGraphql.dataFetchers;

import com.example.testingMongoGraphql.models.Project;
import com.example.testingMongoGraphql.models.User;
import com.example.testingMongoGraphql.services.ProjectService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ProjectsTitleDataFetcher implements DataFetcher<List<Project>> {
    private final ProjectService projectService;

    @Autowired
    public ProjectsTitleDataFetcher(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public List<Project> get(DataFetchingEnvironment env) {
        Map args = env.getArguments();
        List<Project> projectList = new ArrayList<>();
        projectList = projectService.findAllByTitle(String.valueOf(args.get("title")));
        return projectList;
    }

}
