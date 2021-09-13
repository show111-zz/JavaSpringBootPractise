package com.amdocs.assignment.service;

import com.amdocs.assignment.dao.UserLoginDAO;
import com.amdocs.assignment.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class UserLoginServiceImplTest {

    @MockBean
    UserLoginDAO userLoginDAO;

    @Test
    void login_success() {
        User userMock = new User("admin", "root");
        when(userLoginDAO.login("admin", "root")).thenReturn(userMock);
        assertEquals(userMock, userLoginDAO.login("admin", "root"));
    }

    @Test
    void login_fail() {
        when(userLoginDAO.login("test", "password")).thenReturn(null);
        assertNull(userLoginDAO.login("test", "password"));
    }

    @Test
    void getUser_success() {
        User userMock = new User("admin", "root");
        when(userLoginDAO.getUser()).thenReturn(userMock);
        assertEquals(userMock, userLoginDAO.getUser());
    }

    @Test
    void getUser_fail() {
        when(userLoginDAO.getUser()).thenReturn(null);
        assertNull(userLoginDAO.getUser());
    }
}