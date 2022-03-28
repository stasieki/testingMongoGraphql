package com.example.testingMongoGraphql.repositories;


import com.example.testingMongoGraphql.models.Project;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProjectRepository extends MongoRepository<Project, ObjectId> {
    List<Project> findById(List<String> projectsListIds);

    List<Project> findAllByTitle(String title);
}
