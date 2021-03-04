package com.upgrad.BlogPostApplication.controller;

import com.upgrad.BlogPostApplication.model.Post;
import com.upgrad.BlogPostApplication.model.User;
import com.upgrad.BlogPostApplication.model.UserProfile;
import com.upgrad.BlogPostApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

   @Autowired
   private UserService userService;

    //GET Request to /user/login
    @RequestMapping("/users/login")
    public String login(Model model) {
        //Model is taking your controller to your view.
        model.addAttribute("user",new User());
        return "users/login";


    }
    //POST Request to /user/login
    @RequestMapping(method = RequestMethod.POST, value = "/users/login")
    public String loginUser(User user, HttpSession session){
        //check if the credentials match
        User existingUser = userService.login(user);
        if(existingUser == null) {
            System.out.println("User Not Found");
            return "/users/login";
        }
        else
        {
            //Maintain the session

            session.setAttribute("LoggedUser", existingUser);
            System.out.println("Session running");
            System.out.println("User Found");
            return "redirect:/posts";
        }

    }

    //You get the UI to any page only after the 'GET' request. 'POST' request doesn't have a mapping.

    @RequestMapping(method = RequestMethod.GET, value = "/users/registration")
    public String registration(Model model) {
        User user = new User();
        UserProfile userProfile = new UserProfile();
        user.setUserProfile(userProfile);
        model.addAttribute("user", user);

        return "users/registration";


    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/registration")
    public String userRegistration(User user) {
        //Business Logic to save the credentials of the user in the database.
        userService.registerUser(user);
        return "redirect:/users/login";

    }

    @RequestMapping("/users/logout")
    public String userLogout(HttpSession session) {
        //Kill the session if the user logs out
        session.invalidate();
        System.out.println("Session Killed");

        return "redirect:/";
    }



}
