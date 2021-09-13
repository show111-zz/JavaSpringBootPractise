package com.amdocs.assignment.controller;

import com.amdocs.assignment.model.User;
import com.amdocs.assignment.service.UserLoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserLoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserLoginService userLoginServiceMock;

    @Test
    void initLogin_success() throws Exception {
        ModelAndView result = this.mockMvc.perform(get("/assignment")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getModelAndView();
        assert result != null;
        assertEquals("login", result.getViewName());
    }

    @Test
    void login_success_with_admin_root() throws Exception {
        User mockedUser = new User("admin","root");

        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("name", "admin");
        requestParams.add("password", "root");

        when(userLoginServiceMock.login("admin","root")).thenReturn(mockedUser);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/assignment")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .params(requestParams);

        ModelAndView result = mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andReturn()
                .getModelAndView();
        assert result != null;
        assertEquals("add_profile", result.getViewName());
    }

    @Test
    void login_failed_with_other_username() throws Exception {
        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("name", "test");
        requestParams.add("password", "password");

        when(userLoginServiceMock.login("test","password")).thenReturn(null);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/assignment")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .params(requestParams);

        ModelAndView result = mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andReturn()
                .getModelAndView();
        assert result != null;
        assertEquals("login", result.getViewName());
    }
}