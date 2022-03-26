package com.example.testingMongoGraphql.grahpql_utilities;

import com.example.testingMongoGraphql.dataFetchers.AllProjectsDataFetcher;
import com.example.testingMongoGraphql.dataFetchers.UserDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

import static graphql.GraphQL.newGraphQL;
import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

@Component
public class GraphQlUtility {

    @Value("classpath:schemas.graphqls")
    private Resource schemaResource;
    private GraphQL graphQL;
    private AllProjectsDataFetcher allProjectsDataFetcher;
    private UserDataFetcher userDataFetcher;
//    private AllTasksDataFetcher allTasksDataFetcher;
//    private UserDataFetcher userDataFetcher;
//    private TaskDataFetcher taskDataFetcher;
//    private ProjectDataFetcher projectDataFetcher;
//    private UserProjectsDataFetcher userProjectsDataFetcher;
//    private UserTasksDataFetcher userTasksDataFetcher;

//    @Autowired
////    GraphQlUtility(UserProjectsDataFetcher userProjectsDataFetcher, UserTasksDataFetcher userTasksDataFetcher, ProjectDataFetcher projectDataFetcher, AllTasksDataFetcher allTasksDataFetcher, UserDataFetcher userDataFetcher,
////                   TaskDataFetcher taskDataFetcher, AllProjectsDataFetcher allProjectsDataFetcher) throws IOException {
////        this.userDataFetcher = userDataFetcher;
////        this.taskDataFetcher = taskDataFetcher;
////        this.allProjectsDataFetcher = allProjectsDataFetcher;
////        this.allTasksDataFetcher = allTasksDataFetcher;
////        this.projectDataFetcher = projectDataFetcher;
////        this.userProjectsDataFetcher=userProjectsDataFetcher;
////        this.userTasksDataFetcher=userTasksDataFetcher;
////
////    }

    @Autowired
    GraphQlUtility(AllProjectsDataFetcher allProjectsDataFetcher, UserDataFetcher userDataFetcher) throws IOException {
        this.allProjectsDataFetcher = allProjectsDataFetcher;
        this.userDataFetcher=userDataFetcher;
    }


    @PostConstruct
    public GraphQL createGraphQlObject() throws IOException {
        File schemas = schemaResource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemas);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        return newGraphQL(schema).build();
    }

    public RuntimeWiring buildRuntimeWiring() {
        return newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("projects", allProjectsDataFetcher)
                        .dataFetcher("user", userDataFetcher)
                )
                .type("Project", typeWiring -> typeWiring
                        .dataFetcher("projectsList", allProjectsDataFetcher))
                .build();
    }
}