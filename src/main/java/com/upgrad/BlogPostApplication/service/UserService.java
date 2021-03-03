package com.upgrad.BlogPostApplication.service;

import com.upgrad.BlogPostApplication.model.User;
import com.upgrad.BlogPostApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public boolean login(User user) {
        //Contain all business logic and communicate with the database.
        if (user.getUsername().equals("ashish_kumar") && user.getPassword().equals("chitkara"))
            return true;
        else
            return false;
    }

    public void registerUser(User newUser) {
        userRepository.registerUser(newUser);
    }

}
