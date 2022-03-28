package com.example.testingMongoGraphql.repositories;

import com.example.testingMongoGraphql.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

//public interface UserRepository extends PagingAndSortingRepository<User,String> {
public interface UserRepository extends MongoRepository<User,ObjectId> {
    List<User> findAllByIdIn(List<String> userListIds);

    List<User> findAllBySurname(String surname);

    List<User> findAllByEmail(String email);
}
