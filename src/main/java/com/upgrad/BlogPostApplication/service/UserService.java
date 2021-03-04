package com.upgrad.BlogPostApplication.service;

import com.upgrad.BlogPostApplication.model.User;
import com.upgrad.BlogPostApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User login(User user) {
        //Contain all business logic and communicate with the database.
        User existingUser = userRepository.checkCredentials(user.getUsername(), user.getPassword());
        if(existingUser==null) {
            return null;
        }
        else{
            return existingUser;
        }
    }

    public void registerUser(User newUser) {
        userRepository.registerUser(newUser);
    }

}
