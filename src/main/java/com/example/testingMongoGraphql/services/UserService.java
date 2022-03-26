package com.example.testingMongoGraphql.services;


import com.example.testingMongoGraphql.models.User;
import org.bson.types.ObjectId;

import java.util.Optional;

public interface UserService {

    Optional<User> findOneById(ObjectId id);
}
