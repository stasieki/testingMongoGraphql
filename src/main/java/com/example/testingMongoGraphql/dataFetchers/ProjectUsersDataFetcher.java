package com.example.testingMongoGraphql.dataFetchers;

import com.example.testingMongoGraphql.models.Project;
import com.example.testingMongoGraphql.models.User;
import com.example.testingMongoGraphql.services.ProjectService;
import com.example.testingMongoGraphql.services.UserService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectUsersDataFetcher implements DataFetcher<List<User>> {

    private final UserService userService;

    @Autowired
    public ProjectUsersDataFetcher(UserService userService) {
        this.userService = userService;
    }

    // dla kazdego projektu daje uzytkownika
    @Override
    public List<User> get(DataFetchingEnvironment env) {
        Project project = env.getSource();
        List<String> userListIds = new ArrayList<>();
        if (project != null) {
            userListIds = project.getUsersListIds();
        }
        List<User> users = userService.findAllProjectUsers(userListIds);
        return users;
    }
}

