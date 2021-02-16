package com.upgrad.BlogPostApplication.controller;

import com.upgrad.BlogPostApplication.model.Post;
import com.upgrad.BlogPostApplication.model.User;
import com.upgrad.BlogPostApplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    private UserService userService = new UserService();

    //GET Request to /user/login
    @RequestMapping("/users/login")
    public String login(Model model) {
        //Model is taking your controller to your view.
        model.addAttribute("user",new User());
        return "users/login";


    }
    //POST Request to /user/login
    @RequestMapping(method = RequestMethod.POST, value = "/users/login")
    public String loginUser(User user){
        //check if the credentials match
        if(userService.login(user))
        {
            return "redirect:/posts";
        }
        else
        {
            return "users/login";
        }
    }

    //You get the UI to any page only after the 'GET' request. 'POST' request doesn't have a mapping.

    @RequestMapping(method = RequestMethod.GET, value = "/users/registration")
    public String registration() {
        return "users/registration";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/registration")
    public String userRegistration() {
        return "redirect:/users/login";

    }

    @RequestMapping("/users/logout")
    public String userLogout() {
        return "redirect:/";
    }



}
