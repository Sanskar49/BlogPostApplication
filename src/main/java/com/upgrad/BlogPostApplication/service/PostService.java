package com.upgrad.BlogPostApplication.service;

import com.upgrad.BlogPostApplication.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
    //Singleton
    private static ArrayList<Post> POSTS = new ArrayList<>();

    static {
        Post post1 = new Post();
        post1.setTitle("Worldwide News 1");
        post1.setBody("A heavy flood occurred in Uttarakhand. All citizens are asked to follow necessary precautions!!");
        post1.setDate(new Date());
        POSTS.add(post1);

        Post post2 = new Post();
        post2.setTitle("Worldwide News 2");
        post2.setBody("Corona virus has caused a lot of damage in London as for now. The new syndrome seems deadly!!");
        post2.setDate(new Date());
        POSTS.add(post2);

        Post post3 = new Post();
        post3.setTitle("Worldwide News 3");
        post3.setBody("Selena Gomez and Justin Bieber plan to get back together and this is a shocking news to the world!!");
        post3.setDate(new Date());
        POSTS.add(post3);

        Post post4 = new Post();
        post4.setTitle("Worldwide News 4");
        post4.setBody("Apple's new IOS 14.5, the beta version has been released and updates are out for registered beta developers.!!");
        post4.setDate(new Date());
        POSTS.add(post4);
    }

    public ArrayList<Post> getAllPosts() {
        return POSTS;



    }

    public void createPost(Post newPost) {
        POSTS.add(newPost);

    }
}
