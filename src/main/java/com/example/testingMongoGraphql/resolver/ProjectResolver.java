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
public class ProjectResolver implements GraphQLResolver<Project> {

    private final UserService userService;
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectResolver(UserService userService, ProjectRepository projectRepository) {
        this.userService = userService;
        this.projectRepository = projectRepository;
    }

    public User getUser(Project project) {
        User user = new User();
        return user;
    }

    public List<User> users(Project project) {
        List<User> userList = new LinkedList<>();
        return userList;
    }

    public List<User> getUsers() {
        Project project = new Project();
        List<User> userList = new LinkedList<>();
        return userList;
    }

    public List<Task> tasks(Project project) {
        List<Task> userList = new LinkedList<>();
        return userList;
    }

    public List<Task> getTasks() {
        Project project = new Project();
        List<Task> userList = new LinkedList<>();
        return userList;
    }

    public List<Project> projects(Project project) {
        List<String> projectsIds = new LinkedList<>();
        projectsIds = project.getProjectsListIds();
        List<Project> projectList = projectRepository.findById(projectsIds);
        System.out.println("NIE DZIALAM TUTAJ! " + project.getId());
        return projectList;
    }

    public List<Project> getProjects() {
        Project project = new Project();
        List<Project> userList = new LinkedList<>();
        return userList;
    }
}
