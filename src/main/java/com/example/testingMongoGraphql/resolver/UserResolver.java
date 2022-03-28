package com.example.testingMongoGraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.testingMongoGraphql.models.Project;
import com.example.testingMongoGraphql.models.Task;
import com.example.testingMongoGraphql.models.User;
import com.example.testingMongoGraphql.repositories.ProjectRepository;
import com.example.testingMongoGraphql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class UserResolver implements GraphQLResolver<User> {

    private final UserService userService;
    private final ProjectRepository projectRepository;

    @Autowired
    public UserResolver(UserService userService, ProjectRepository projectRepository) {
        this.userService = userService;
        this.projectRepository = projectRepository;
    }

    public List<Project> projects(User user) {
        List<String> projectsIds = new LinkedList<>();
        projectsIds = user.getProjectsListIds();
        List<Project> projectList = projectRepository.findById(projectsIds);
        return projectList;
    }

    public List<Project> getProjects() {
        Project project = new Project();
        List<Project> userList = new LinkedList<>();
        return userList;
    }

    public List<Task> tasks(User user) {
        List<Task> userList = new LinkedList<>();
        return userList;
    }

    public List<Task> getTasks() {
        Project project = new Project();
        List<Task> userList = new LinkedList<>();
        return userList;
    }
}
