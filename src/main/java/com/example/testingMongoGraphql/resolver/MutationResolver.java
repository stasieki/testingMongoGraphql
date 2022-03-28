package com.example.testingMongoGraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.testingMongoGraphql.models.User;
import com.example.testingMongoGraphql.repositories.UserRepository;
import com.example.testingMongoGraphql.services.ProjectService;
import com.example.testingMongoGraphql.services.TaskService;
import com.example.testingMongoGraphql.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MutationResolver implements GraphQLMutationResolver { //GraphQLQueryResolver // implements GraphQLMutationResolver

    private final UserService userService;
    private final TaskService taskService;
    private final ProjectService projectService;
    private final UserRepository userRepository;

    @Autowired
    public MutationResolver(UserService userService, TaskService taskService, ProjectService projectService,
                            UserRepository userRepository) {
        this.userService = userService;
        this.taskService = taskService;
        this.projectService = projectService;
        this.userRepository = userRepository;
    }

    //addUser(name:String, surname:String):User
    public User addUser(String name, String surname) {
        User user = User.builder().name(name).birthDate("1.1.2001").surname(surname).email("nweEmail@gmail.com").build();
        userRepository.save(user);
        return user;
    }
    public User updateUser(String id, String name, String surname) {


       User foundUser = userRepository.findById(new ObjectId(id)).orElseThrow(null);

        User user = User.builder().name(name).birthDate("1.1.2001").surname(surname).email("newEmail@gmail.com").id(foundUser.getId()).build();
        userService.deleteOneById(foundUser.getId());
        userRepository.insert(user);
//       userRepository.findOne()
//       foundUser.u
        return user;
    }


}
