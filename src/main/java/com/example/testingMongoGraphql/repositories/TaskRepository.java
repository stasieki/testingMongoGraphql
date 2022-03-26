package com.example.testingMongoGraphql.repositories;


import com.example.testingMongoGraphql.models.Task;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaskRepository extends MongoRepository<Task, ObjectId> {
}
