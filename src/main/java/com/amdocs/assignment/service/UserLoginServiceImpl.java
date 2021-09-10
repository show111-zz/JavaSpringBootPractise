package com.amdocs.assignment.service;

import com.amdocs.assignment.dao.UserLoginDAOImpl;
import com.amdocs.assignment.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    UserLoginDAOImpl userLoginDAO;

    @Override
    public boolean login(User user) {
        return userLoginDAO.login(user);
    }

    @Override
    public User getUser() {
        return userLoginDAO.getUser();
    }
}
