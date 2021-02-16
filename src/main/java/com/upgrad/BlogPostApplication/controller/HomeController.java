package com.upgrad.BlogPostApplication.controller;

import com.upgrad.BlogPostApplication.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.Date;

//Controller tells the compiler that HomeController is not a normal java class. it is a class that interacts with web.
//RestController will give you JSON data back and we dont want that right now.
@Controller
public class HomeController {
    //Business Logic

    //Request mapping is by default a GET request.
    @RequestMapping("/")
    public String getAllPost(Model model) {
        ArrayList<Post> posts = new ArrayList<>();

        Post post1 = new Post();
        post1.setTitle("SmartPhone");
        post1.setBody("Iphones are better than Android");
        post1.setDate(new Date());

        Post post2 = new Post();
        post2.setTitle("Beauty");
        post2.setBody("Selena Gomez has started her own makeup line");
        post2.setDate(new Date());

        Post post3 = new Post();
        post3.setTitle("Tesla");
        post3.setBody("Tesla CEO to start his own thing soon");
        post3.setDate(new Date());

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);

         //Gave this post to the view
        //The data i am passing would be named posts because the main at the view has that id too.. and the data im passing also fortunately is named posts.
        model.addAttribute("posts",posts);
        return "index";






    }
}
