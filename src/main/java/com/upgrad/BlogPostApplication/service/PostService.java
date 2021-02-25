package com.upgrad.BlogPostApplication.service;

import com.upgrad.BlogPostApplication.model.Post;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

@Service
public class PostService {
    //Singleton
    private static ArrayList<Post> POSTS = new ArrayList<>();

    /* static {
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
    } */
    //These are the variables you provide from your database
    private final String url = "jdbc:postgresql://localhost:5432/technicalblog";
    private final String username = "postgres";  // "postgresql"
    private final String password = "password";

    public Connection connect() throws SQLException {
        //This function makes connection of the backend logic with the sql database.
        return DriverManager.getConnection(url, username, password);
    }

    public ArrayList<Post> getAllPosts() {
        //DB ma insert gareko stuffs you can see on your web(This function).
        try {
            // Business Logic for connecting the database

            // Step 1: Connect to the DB
            Connection connection = connect();

            // Step 2: Get/ Create the Statement
            Statement statement = connection.createStatement();

            // Step 3: Execute the select query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM posts");

            // Step 4: Loop into the resultSet and get the data
            while (resultSet.next()) {
                Post post1 = new Post();
                //post1 is in transient state
                post1.setTitle(resultSet.getString("title"));
                post1.setBody(resultSet.getString("body"));
                post1.setDate(resultSet.getDate("date"));

                // Store the data in the Singleton
                //Now it might be in persistent state
                POSTS.add(post1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return POSTS;


    }

    public void createPost(Post newPost) {
        //Things you do on the web will be posted on your db.
        String query = "INSERT INTO posts(title, body, date) VALUES(?, ?, ?)";
        try {
            // Step 1: Connect to the DB
            Connection connection = connect();

            // Step 2: Prepare a statement
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            // Step 3: Fix the values from the VIEWS
            preparedStatement.setString(1, newPost.getTitle());
            preparedStatement.setString(2, newPost.getBody());
            preparedStatement.setDate(3, new Date(newPost.getDate().getTime()));

            int updatedRows = preparedStatement.executeUpdate();

            if(updatedRows > 0) {
                System.out.println("Update is working Fine!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }
}
