package com.upgrad.BlogPostApplication.service;

import com.upgrad.BlogPostApplication.model.Post;
import com.upgrad.BlogPostApplication.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // Using JPA -> communicate | EntityManagerFactory -> EntityManager


    public List<Post> getAllPosts() {
        //Takes the post from your account's db and shows it on your home page(web).
        return postRepository.getAllPosts();



    }
    //newPost is coming from the view package.
    public void createPost(Post newPost) {
        //This function takes the postTitle and description from the web and saves it on your database.
      postRepository.createPost(newPost);
    }
    public void deletePost(Integer postId) {
        postRepository.deletePost(postId);

    }
}
