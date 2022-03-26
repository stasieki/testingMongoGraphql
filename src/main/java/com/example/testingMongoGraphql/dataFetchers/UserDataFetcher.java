package com.example.testingMongoGraphql.dataFetchers;

import com.example.testingMongoGraphql.models.User;
import com.example.testingMongoGraphql.services.UserService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class UserDataFetcher implements DataFetcher<Optional<User>> {

    private final UserService userService;

    @Autowired
    public UserDataFetcher(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Optional<User> get(DataFetchingEnvironment env) {
        Map args = env.getArguments();
//        Optional<User> user = userService.findOneById(new ObjectId(String.valueOf(args.get("id"))));
        Optional<User> user = userService.findOneById(new ObjectId(String.valueOf(args.get("id"))));
        return user;
    }
}
