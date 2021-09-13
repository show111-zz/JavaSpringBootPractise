package com.amdocs.assignment.service;

import com.amdocs.assignment.dao.UserLoginDAO;
import com.amdocs.assignment.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    UserLoginDAO userLoginDAO;

    /**
     * The user instance base on the username and password
     * @param name username
     * @param password password
     * @return
     */
    @Override
    public User login(String name, String password) {
        return userLoginDAO.login(name, password);
    }

    /**
     * Get the user
     * @return the authorizated user
     */
    @Override
    public User getUser() {
        return userLoginDAO.getUser();
    }
}
