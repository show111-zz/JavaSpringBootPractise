package com.amdocs.assignment.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String name;

    private String password;

    /**
     * The default constructor
     */
    public User(){}

    /**
     * Constructor with two parameters
     * @param name the username for user
     * @param password the password for user
     */
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    /**
     * Get the id from the user
     * @return id id
     */
    public long getId() {
        return id;
    }

    /**
     * Get the username from user
     * @return username
     */
    public String getName() {
        return name;
    }

    /**
     * Get the password from user
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * ToString method for the user object
     * @return the string of the user object
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
