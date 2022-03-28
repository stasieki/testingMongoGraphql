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
@Document(collection = "Project")
public class Project {
//    @Id
    ObjectId id;
    String title;
    String description;
    String creationDate;
    String startDate;
    String endDate;
    List<String> usersListIds;
    List<String> tasksListIds;
    List<String> projectsListIds;
}
