package com.upgrad.BlogPostApplication.service;

import com.upgrad.BlogPostApplication.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public boolean login(User user) {
        //Contain all business logic and communicate with the database.
        if (user.getUsername().equals("ashish_kumar") && user.getPassword().equals("chitkara"))
            return true;
        else
            return false;
    }
}
