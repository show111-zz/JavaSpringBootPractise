package com.amdocs.assignment.dao;

import com.amdocs.assignment.model.User;
import com.amdocs.assignment.repository.UserLoginRepository;
import com.amdocs.assignment.repository.UserProfileRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class UserLoginDAOImplTest {

    @MockBean
    private UserLoginRepository userLoginRepository;

    @Autowired
    UserLoginDAO userLoginDAO;

    @Mock
    User user;

    @Test
    void login_success() {
        List<User> userList = new ArrayList<>();
        User u = new User("admin", "root");
        userList.add(u);
        userLoginRepository.save(u);
        when(userLoginRepository.findAll()).thenReturn(userList);
        assertEquals(userList.get(0).getName(),"admin");
    }

    @Test
    void login_fail() {
        List<User> userList = new ArrayList<>();
        User u = new User("test", "password");
        userList.add(u);
        when(userLoginRepository.findAll()).thenReturn(userList);
        assertNotEquals(userList.get(0).getName(),"admin");
    }

    @Test
    void getUser_success() {
        List<User> userList = new ArrayList<>();
        User u = new User("admin", "root");
        userList.add(u);

        when(userLoginRepository.findAll()).thenReturn(userList);
        assertEquals("admin", userList.get(0).getName());
    }

    @Test
    void getUser_fail() {
        List<User> userList = new ArrayList<>();
        User u = new User("test", "password");
        userList.add(u);

        when(userLoginRepository.findAll()).thenReturn(userList);
        assertNotEquals("admin", userList.get(0).getName());
    }
}