package com.example.testingMongoGraphql.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Task")
public class Task {
//    @Id
    ObjectId id;
    String title;
    String content;
    String creationDate;
    String startDate;
    String endDate;
    String priority;
    List<String> usersListIds;
    List<String> tasksListIds;
}
