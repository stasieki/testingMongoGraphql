package com.example.testingMongoGraphql.services.implementation;


import com.example.testingMongoGraphql.models.User;
import com.example.testingMongoGraphql.repositories.UserRepository;
import com.example.testingMongoGraphql.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findOneById(ObjectId id) {
       return  userRepository.findById(id);

    }
}
