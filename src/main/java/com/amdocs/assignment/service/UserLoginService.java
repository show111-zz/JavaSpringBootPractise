package com.amdocs.assignment.service;

import com.amdocs.assignment.model.User;

public interface UserLoginService {
    User login(String name, String password);

    User getUser();
}
