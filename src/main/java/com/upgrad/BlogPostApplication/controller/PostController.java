package com.upgrad.BlogPostApplication.controller;

import com.upgrad.BlogPostApplication.model.Post;
import com.upgrad.BlogPostApplication.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        //PostService postService = new PostService();
        //Model.addAttribute is adding the things in the model and then the post is getting returned in view.
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

    @RequestMapping(method = RequestMethod.DELETE, value = "/deletepost")
    public String deletePost(@RequestParam(name = "postId") Integer postId) {
        //postId comes when you request it it come so thats why annotation is being used with it.
        postService.deletePost(postId);
        return "redirect:/posts";


    }
}
