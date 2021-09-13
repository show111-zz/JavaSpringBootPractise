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

    /**
     * Pass the username and password to login
     * @param name username
     * @param password password
     * @return The user object according to the name and password
     */
    @Override
    public User login(String name, String password) {
        // Todo Delete this line after filling the init username and password
//        userLoginRepository.save(new User(name, password));
        List<User> list = userLoginRepository.findAll();
        return list.stream().filter(user -> user.getName().equals(name) && user.getPassword().equals(password))
                .findFirst().orElse(null);
    }

    /**
     * Get user from the database
     * @return The user object
     */
    @Override
    public User getUser() {
        List<User> list = userLoginRepository.findAll();
        return list.stream().findFirst().orElse(null);
    }
}
