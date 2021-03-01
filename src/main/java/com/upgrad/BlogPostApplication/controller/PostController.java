package com.upgrad.BlogPostApplication.controller;

import com.upgrad.BlogPostApplication.model.Post;
import com.upgrad.BlogPostApplication.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PostController {
    //IOC - Inversion of Control | Dependency Injection

    @Autowired
    private PostService postService;

    @RequestMapping("/posts")
    public String getUserPost(Model model){
        //Thyakka below line is wrong because of IOC OR dependency injection.
        //PostService postService = new PostService();
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "posts";
    }

    //Everytime you map to /posts/newpost you will be redirected to create wala page.
    @RequestMapping(method = RequestMethod.GET, value = "/posts/newpost")
    public String newPost(){
        return "posts/create";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/posts/create")
    public String createNewPost(Post newPost) {
        newPost.setDate(new Date());
        postService.createPost(newPost);
        return "redirect:/posts";

    }
}
