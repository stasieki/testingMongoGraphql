package com.example.testingMongoGraphql.dataLoader;

import com.example.testingMongoGraphql.models.Project;
import com.example.testingMongoGraphql.models.Task;
import com.example.testingMongoGraphql.models.User;
import com.example.testingMongoGraphql.repositories.ProjectRepository;
import com.example.testingMongoGraphql.repositories.TaskRepository;
import com.example.testingMongoGraphql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
public class MyDataLoader {
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    @Autowired
    MyDataLoader(UserRepository userRepository, TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    @PostConstruct
    private void generateData() {
        List<String> listOfUsersProject = new ArrayList<>(); //user.getProjectsListIds();
        listOfUsersProject.add("624090993113b3174b2121cc");
        User user = User.builder().name("Kunegunda").birthDate("10.10.2010").surname("Kowalski").email("kowlaski@gmail.com").projectsListIds(listOfUsersProject).build(); //.projectsListIds(new ArrayList<>())
        userRepository.save(user);

        List<String> listOfUsers = new ArrayList<>();
        listOfUsers.add("623dc712f99495782dda2fd9"); //user.getId().toString()
        Project project = Project.builder().title("Boski tylul").description("Robienie bardzo ciezkich rzeczy!").usersListIds(listOfUsers).build();
        projectRepository.save(project);

        Task task = Task.builder().title("Fantastyczny task").usersListIds(listOfUsers).content("Tresc taska").build();
        taskRepository.save(task);

        List<User> users = (List<User>) userRepository.findAll();
        System.out.println("useres: " + user);
    }
}
