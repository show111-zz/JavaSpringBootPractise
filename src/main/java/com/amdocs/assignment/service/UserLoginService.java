package com.amdocs.assignment.service;

import com.amdocs.assignment.model.User;

public interface UserLoginService {
    /**
     * Get the user instance according to the name and password
     * @param name username
     * @param password password
     * @return the new user object
     */
    User login(String name, String password);

    /**
     * Get user instance
     * @return
     */
    User getUser();
}
