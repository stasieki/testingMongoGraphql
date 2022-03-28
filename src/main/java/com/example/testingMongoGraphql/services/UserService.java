package com.example.testingMongoGraphql.services;


import com.example.testingMongoGraphql.models.Project;
import com.example.testingMongoGraphql.models.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface UserService {

    User findOneById(ObjectId id);

    boolean deleteOneById(ObjectId id);

    User addUser(User user);

    List<User> findAllProjectUsers(List<String> userListIds);


    List<User> findAllBySurname(String surname);

    List<User> findAllByEmail(String email);
}
