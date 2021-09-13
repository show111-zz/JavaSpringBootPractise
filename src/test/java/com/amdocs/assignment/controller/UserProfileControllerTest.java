package com.amdocs.assignment.controller;

import com.amdocs.assignment.model.Profile;
import com.amdocs.assignment.model.User;
import com.amdocs.assignment.service.UserLoginService;
import com.amdocs.assignment.service.UserProfileService;
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

@SpringBootTest
@AutoConfigureMockMvc
class UserProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserLoginService userLoginServiceMock;

    @MockBean
    private UserProfileService userProfileServiceMock;

    @Test
    void createProfile() throws Exception {
        Profile mockedProfile = new Profile();
        mockedProfile.setAddress("ottawa");
        mockedProfile.setPhone("3437771753");
        mockedProfile.setUser(new User("admin", "root"));

        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("address", "ottawa");
        requestParams.add("phone", "3437771753");

        when(userProfileServiceMock.createProfile(mockedProfile)).thenReturn(mockedProfile);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/profile")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .params(requestParams);

        ModelAndView result = mockMvc.perform(mockRequest)
                .andReturn()
                .getModelAndView();
        assertEquals("edit_profile", result.getViewName());
    }
}