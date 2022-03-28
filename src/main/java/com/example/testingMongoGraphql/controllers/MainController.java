package com.example.testingMongoGraphql.controllers;

import com.example.testingMongoGraphql.grahpql_utilities.GraphQlUtility;
import com.example.testingMongoGraphql.resolver.MutationResolver;
import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;

@RestController
public class MainController {

    private final GraphQL graphQL;
    private GraphQlUtility graphQlUtility;
    private final MutationResolver mutationResolver;

    @Autowired
    MainController(GraphQlUtility graphQlUtility, MutationResolver mutationResolver) throws IOException {
        this.graphQlUtility = graphQlUtility;
        this.mutationResolver = mutationResolver;
        graphQL = graphQlUtility.createGraphQlObject();
    }

    @PostMapping(value = "/query")
    public ResponseEntity query(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        mutationResolver.addUser("Janusz", "Duda");
        mutationResolver.updateUser("624154fbc6144c3ca18c50ca", "Janusz", "Duda");
        System.out.println("errors: " + result.getErrors());
        return ResponseEntity.ok(result.getData());
    }

}
