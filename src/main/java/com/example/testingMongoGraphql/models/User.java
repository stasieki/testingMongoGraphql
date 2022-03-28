package com.example.testingMongoGraphql.models;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "User")
public class User {
//    @Id
    ObjectId id;
    String name;
    String surname;
    String email;
    String birthDate;
    List<String> tasksListIds;
    List<String> projectsListIds;
}