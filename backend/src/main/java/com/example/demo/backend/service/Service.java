package com.example.demo.backend.service;


import com.example.demo.backend.entity.User;
import com.example.demo.backend.exception.UserNotFoundException;
import com.example.demo.backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


@org.springframework.stereotype.Service
public class Service {

    @Autowired
    UserRepo userRepo;

    public User insertUser(User user) {
        return userRepo.save(user);
    }

    public User getUser(long id){

        Optional<User> u = userRepo.findById(id);
        if(u.isPresent()){
            return u.get();
        }

        throw new UserNotFoundException("Not Found");

    }


}
