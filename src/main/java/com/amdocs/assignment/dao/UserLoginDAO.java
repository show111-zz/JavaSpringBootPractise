package com.amdocs.assignment.dao;

import com.amdocs.assignment.model.User;

public interface UserLoginDAO {
    User login(String name, String password);

    User getUser() ;
}
