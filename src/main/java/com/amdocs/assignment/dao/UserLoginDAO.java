package com.amdocs.assignment.dao;

import com.amdocs.assignment.model.User;

public interface UserLoginDAO {
    boolean login(User user);
}
