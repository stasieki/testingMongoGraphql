package com.example.testingMongoGraphql.repositories;

import com.example.testingMongoGraphql.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

//public interface UserRepository extends PagingAndSortingRepository<User,String> {
public interface UserRepository extends MongoRepository<User,ObjectId> {
//    Optional<User> findById(ObjectId id);
//    List<Task> findByIdIn(List<Task> ids);
}
