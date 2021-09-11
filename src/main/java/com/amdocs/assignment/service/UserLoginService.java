package com.amdocs.assignment.service;

import com.amdocs.assignment.model.User;

public interface UserLoginService {
    boolean login(User user);

    User getUser();
}
