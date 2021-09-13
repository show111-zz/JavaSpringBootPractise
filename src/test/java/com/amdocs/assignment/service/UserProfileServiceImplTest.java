package com.amdocs.assignment.service;

import com.amdocs.assignment.dao.ProfileDAOImpl;
import com.amdocs.assignment.model.Profile;
import com.amdocs.assignment.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class UserProfileServiceImplTest {

    @MockBean
    ProfileDAOImpl profileDAO;

    @Autowired
    UserProfileService userProfileService;

    @Mock
    Profile mockedPro;

    @Mock
    List<Profile> mockedList;

    @Test
    void getProfile_success() {
        when(profileDAO.getProfile(1L)).thenReturn(mockedPro);
        Profile profile = userProfileService.getProfile(1L);

        assertEquals(mockedPro.getAddress(), profile.getAddress());
    }

    @Test
    void getProfile_fail() {
        when(profileDAO.getProfile(1L)).thenReturn(null);
        Profile profile = userProfileService.getProfile(1L);
        assertEquals(profileDAO.getProfile(1L), profile);
    }

    @Test
    void createProfile_success() {
        when(profileDAO.createProfile(any(Profile.class))).thenReturn(new Profile());
        Profile profile = userProfileService.createProfile(mockedPro);
        assertEquals(profile.getAddress(), mockedPro.getAddress());
    }

    @Test
    void createProfile_fail() {
        when(profileDAO.createProfile(any(Profile.class))).thenReturn(null);
        assertNull(userProfileService.createProfile(mockedPro));
    }

    @Test
    void updateProfile_success() {
        when(profileDAO.updateProfile(any(Profile.class))).thenReturn(mockedPro);
        Profile profile = userProfileService.updateProfile(mockedPro);
        assertEquals(profile.getAddress(), mockedPro.getAddress());
    }

    @Test
    void updateProfile_fail() {
        when(profileDAO.updateProfile(any(Profile.class))).thenReturn(null);
        assertNull(userProfileService.updateProfile(mockedPro));
    }

    @Test
    void getAllProfiles_success() {
        when(profileDAO.getAllProfiles()).thenReturn(mockedList);
        List<Profile> profile = userProfileService.getAllProfiles();
        assertEquals(profile.size(), mockedList.size());
    }

    @Test
    void getAllProfiles_null() {
        when(profileDAO.getAllProfiles()).thenReturn(null);
        assertNull(userProfileService.getAllProfiles());
    }
}