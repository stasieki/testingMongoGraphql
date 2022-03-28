package com.example.testingMongoGraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.testingMongoGraphql.models.Project;
import com.example.testingMongoGraphql.models.Task;
import com.example.testingMongoGraphql.models.User;
import com.example.testingMongoGraphql.services.TaskService;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class TaskResolver implements GraphQLResolver<Task> {

    private final TaskService taskService;

    public TaskResolver(TaskService taskService) {
        this.taskService = taskService;
    }

    public List<Task> tasks(Task task) {
        List<Task> userList = new LinkedList<>();
        return userList;
    }

    public List<Task> getTasks() {
        Project project = new Project();
        List<Task> userList = new LinkedList<>();
        return userList;
    }

    public List<User> users(Task task) {
        List<User> userList = new LinkedList<>();
        return userList;
    }

    public List<User> getUsers() {
        Project project = new Project();
        List<User> userList = new LinkedList<>();
        return userList;
    }
}
