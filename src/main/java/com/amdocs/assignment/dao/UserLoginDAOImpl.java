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
    public User login(String name, String password) {
        // Todo Delete this line after filling the init username and password
        userLoginRepository.save(new User(name, password));
        List<User> list = userLoginRepository.findAll();
        return list.stream().filter(user -> user.getName().equals(name) && user.getPassword().equals(password))
                .findFirst().orElse(null);
    }

    @Override
    public User getUser() {
        List<User> list = userLoginRepository.findAll();
        return list.stream().findFirst().orElse(null);
    }
}
