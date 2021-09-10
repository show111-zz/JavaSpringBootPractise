package com.amdocs.assignment.dao;

import com.amdocs.assignment.model.User;
import com.amdocs.assignment.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserLoginDAOImpl implements UserLoginDAO {

    @Autowired
    UserLoginRepository userLoginRepository;

    @Override
    public boolean login(User user) {
        List<User> list = userLoginRepository.findAll();
        for (User u : list) {
            if (u.getName().equals(user.getName()) && u.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User getUser() {
        List<User> list = userLoginRepository.findAll();
        if (list != null && list.size() != 0) {
            return list.get(0);
        }
        return null;
    }
}
