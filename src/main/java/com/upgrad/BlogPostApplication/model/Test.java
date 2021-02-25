package com.upgrad.BlogPostApplication.model;

import javax.persistence.*;

//The class is made to be the entity which later on would be mapped to be a table using the table entity
@Entity
@Table(name = "testTable")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "testId")
    private int id;

    @Column(name = "testName")
    private String name;

    @Column(name= "testEmail")
    private String email;

    @Column(name = "testPassword")
    private String password;

    public Test() {

    }

    public Test(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
