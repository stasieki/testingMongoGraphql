package com.example.testingMongoGraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.testingMongoGraphql.models.Project;
import com.example.testingMongoGraphql.models.User;
import com.example.testingMongoGraphql.services.ProjectService;
import com.example.testingMongoGraphql.services.TaskService;
import com.example.testingMongoGraphql.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    private final UserService userService;
    private final TaskService taskService;
    private final ProjectService projectService;

    @Autowired
    public QueryResolver(UserService userService, TaskService taskService, ProjectService projectService) {
        this.userService = userService;
        this.taskService = taskService;
        this.projectService = projectService;
    }

    public List<User> getFindSurnameEmail(String surname, String email) {
        List<User> userList = new ArrayList<>();
        return userList;
    }

    public Project project() {
        Project project = new Project();
        return project;
    }

    public List<Project> projects() {
        List<Project> project = new ArrayList<>();
        return project;
    }

//    projects(title:String): [Project]
    public List<Project> findProjects(String title) {
        List<Project> project = new ArrayList<>();
        return project;
    }
    public User user(String id) {
        User user = new User();
        return user;
    }

    public boolean deleteUser(String id) {
        boolean temp = true;
        return temp;
    }

    public User addUser(String name, String surname) {
        User user = User.builder().name(name).birthDate("1.1.2001").surname(surname).email("nweEmail@gmail.com").build();
        User user2 = userService.addUser(user);
        return user2;
    }

    public User getUser() {
        Project project = new Project();
        User user = new User();
        return user;
    }
}
