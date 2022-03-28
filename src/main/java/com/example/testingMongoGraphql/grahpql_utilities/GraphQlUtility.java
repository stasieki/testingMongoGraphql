package com.example.testingMongoGraphql.grahpql_utilities;

import com.example.testingMongoGraphql.dataFetchers.*;
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
    private final AllProjectsDataFetcher allProjectsDataFetcher;
    private final UserDataFetcher userDataFetcher;
    private final DeleteUserDataFetcher deleteUserDataFetcher;
    private final ProjectUsersDataFetcher projectUsersDataFetcher;
    private final UserProjectsDataFetcher userProjectsDataFetcher;
    private final ProjectsTitleDataFetcher projectsTitleDataFetcher;
    private final UsersSurnameEmailDataFetcher usersSurnameEmailDataFetcher;

    @Autowired
    GraphQlUtility(AllProjectsDataFetcher allProjectsDataFetcher, UserDataFetcher userDataFetcher,
                   DeleteUserDataFetcher deleteUserDataFetcher, ProjectUsersDataFetcher projectUsersDataFetcher,
                   UserProjectsDataFetcher userProjectsDataFetcher, ProjectsTitleDataFetcher projectsTitleDataFetcher,
                   UsersSurnameEmailDataFetcher usersSurnameEmailDataFetcher ) throws IOException {
        this.allProjectsDataFetcher = allProjectsDataFetcher;
        this.userDataFetcher = userDataFetcher;
        this.deleteUserDataFetcher = deleteUserDataFetcher;
        this.projectUsersDataFetcher = projectUsersDataFetcher;
        this.userProjectsDataFetcher = userProjectsDataFetcher;
        this.projectsTitleDataFetcher = projectsTitleDataFetcher;
        this.usersSurnameEmailDataFetcher= usersSurnameEmailDataFetcher;
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
                        .dataFetcher("findProjects", projectsTitleDataFetcher)
                        .dataFetcher("findSurnameEmail", usersSurnameEmailDataFetcher)
                        .dataFetcher("deleteUser", deleteUserDataFetcher))
//                .type("Mutation", typeWiring -> typeWiring
//                )
                .type("Project", typeWiring -> typeWiring
                        .dataFetcher("projects", allProjectsDataFetcher)
                        .dataFetcher("users", projectUsersDataFetcher))
                .type("User", typeWiring -> typeWiring
                        .dataFetcher("projects", userProjectsDataFetcher))
                .build();
    }
}