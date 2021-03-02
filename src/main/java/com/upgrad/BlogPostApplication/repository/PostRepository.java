package com.upgrad.BlogPostApplication.repository;

import com.upgrad.BlogPostApplication.model.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class PostRepository {

    PostRepository() {
        System.out.println("***Post Repo***");
    }
    //EntityManagerFactory is needed to create EntityManager which in return helps you perform Crud Operations.
    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory entityManagerFactory;

    public List<Post> getAllPosts() {
        //Takes the post from your account's db and shows it on your home page(web).
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Post> query = entityManager.createQuery("SELECT p from Post p", Post.class);
        List<Post> result = query.getResultList();
        return result;

    }

    public void createPost(Post newPost) {
        //This function takes the postTitle and description from the web and saves it on your database.
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            //Persist saves the data in your database.
            entityManager.persist(newPost);
            //Committing transaction to your database if exception doesnt come.
            transaction.commit();

        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        }

    }

    public void deletePost(Integer postId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Post post = entityManager.find(Post.class, postId);
            entityManager.remove(post);
            transaction.commit();

        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }

}
