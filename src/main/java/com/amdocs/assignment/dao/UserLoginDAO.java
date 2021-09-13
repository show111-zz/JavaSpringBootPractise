package com.amdocs.assignment.dao;

import com.amdocs.assignment.model.User;

public interface UserLoginDAO {
    /**
     * Pass the username and password to the login
     * @param name username of user
     * @param password password of user
     * @return this new User according to the name and password
     */
    User login(String name, String password);

    /**
     * Get the user information
     * @return the user instance
     */
    User getUser() ;
}
