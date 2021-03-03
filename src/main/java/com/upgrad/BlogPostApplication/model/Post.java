package com.upgrad.BlogPostApplication.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//POJO -> Plain Old Java Object
@Entity
@Table(name = "posts")
public class Post {
    //components of the Blog Post
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;
    @Column(name = "body")
    private String body;
    @Column(name = "date")
    private Date date;

    //RELATIONSHIP(Many to One between Post to User)

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    //Post has requested cateogory so category also needs to make sure about the relationship.
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    private List<Category> categories = new ArrayList<>();


    // Getters and Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle()
    {

        return title;
    }

    public void setTitle(String title)
    {

        this.title = title;
    }

    public String getBody()
    {

        return body;
    }

    public void setBody(String body)
    {

        this.body = body;
    }

    public Date getDate(){

        return date;
    }
    public void setDate(Date date)
    {

        this.date = date;
    }




}
