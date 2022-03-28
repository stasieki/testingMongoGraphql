package com.example.testingMongoGraphql.services.implementation;


import com.example.testingMongoGraphql.models.Project;
import com.example.testingMongoGraphql.models.User;
import com.example.testingMongoGraphql.repositories.UserRepository;
import com.example.testingMongoGraphql.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findOneById(ObjectId id) {
        return userRepository.findById(id).orElseThrow(null);

    }

    @Override
    public boolean deleteOneById(ObjectId id) {
        boolean b1 = userRepository.existsById(id);
        userRepository.deleteById(id);

        return b1;
    }

    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> findAllProjectUsers(List<String> userListIds) {
        return userRepository.findAllByIdIn(userListIds);
    }

    @Override
    public List<User> findAllBySurname(String surname) {
        return userRepository.findAllBySurname(surname);
    }

    @Override
    public List<User> findAllByEmail(String email) {
        return userRepository.findAllByEmail(email);
    }
}
