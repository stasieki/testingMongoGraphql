package com.example.testingMongoGraphql.dataFetchers;

import com.example.testingMongoGraphql.models.Project;
import com.example.testingMongoGraphql.models.User;
import com.example.testingMongoGraphql.services.UserService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class UsersSurnameEmailDataFetcher implements DataFetcher<List<User>> {
    private final UserService userService;

    @Autowired
    public UsersSurnameEmailDataFetcher(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> get(DataFetchingEnvironment env) {
        Map args = env.getArguments();
        List<User> userList = new ArrayList<>();
        List<User> userListSurname = new ArrayList<>();
        List<User> userListEmail = new ArrayList<>();
        userListSurname = userService.findAllBySurname(String.valueOf(args.get("surname")));
        userListEmail = userService.findAllByEmail(String.valueOf(args.get("email")));
//        userList = userListSurname.containsAll(userListEmail) && userListEmail.containsAll(userListSurname);

        System.out.println(userListEmail);
        userListEmail.retainAll(userListSurname);
        System.out.println(userListEmail);
        return userListEmail;
    }
}
