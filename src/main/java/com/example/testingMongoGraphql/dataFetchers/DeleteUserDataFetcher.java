package com.example.testingMongoGraphql.dataFetchers;

import com.example.testingMongoGraphql.models.User;
import com.example.testingMongoGraphql.services.UserService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DeleteUserDataFetcher implements DataFetcher<Boolean> {

    private final UserService userService;

    @Autowired
    public DeleteUserDataFetcher(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Boolean get(DataFetchingEnvironment env) {
        Map args = env.getArguments();
        boolean b1 = userService.deleteOneById(new ObjectId(String.valueOf(args.get("id"))));
        return b1;
    }
}
