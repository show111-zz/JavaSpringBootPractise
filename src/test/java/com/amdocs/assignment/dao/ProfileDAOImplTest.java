package com.amdocs.assignment.dao;

import com.amdocs.assignment.model.Profile;
import com.amdocs.assignment.model.User;
import com.amdocs.assignment.repository.UserProfileRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class ProfileDAOImplTest {

    @MockBean
    private UserProfileRepository userProfileRepository;

    @Autowired
    private ProfileDAO profileDAO;

    @Test
    void getProfile_success() {
        Profile mockedProfile = new Profile();
        mockedProfile.setId(1L);
        mockedProfile.setAddress("ottawa");
        mockedProfile.setPhone("3437771753");
        mockedProfile.setUser(new User("admin", "root"));

        when(userProfileRepository.getById(1L)).thenReturn(mockedProfile);
        assertEquals(mockedProfile.getAddress(), "ottawa");
    }

    @Test
    void getProfile_fail() {
        when(userProfileRepository.getById(1L)).thenReturn(null);
        assertNull(profileDAO.getProfile(1L));
    }


    @Test
    void createProfile_success() {
        Profile mockedProfile = new Profile();
        mockedProfile.setId(1L);
        mockedProfile.setAddress("ottawa");
        mockedProfile.setPhone("3437771753");
        mockedProfile.setUser(new User("admin", "root"));

        when(userProfileRepository.save(mockedProfile)).thenReturn(mockedProfile);
        when(profileDAO.createProfile(mockedProfile)).thenReturn(mockedProfile);
        assertEquals(1, profileDAO.createProfile(mockedProfile).getId());
    }

    @Test
    void updateProfile_success() {
        Profile mockedProfile = new Profile();
        mockedProfile.setAddress("ottawa");
        mockedProfile.setPhone("3437771753");
        mockedProfile.setUser(new User("admin", "root"));

        when(profileDAO.updateProfile(mockedProfile)).thenReturn(mockedProfile);
        assertEquals(mockedProfile.getAddress(), profileDAO.createProfile(mockedProfile).getAddress());
    }


    @Test
    void updateProfile_fail() {
        Profile mockedProfile = new Profile();
        mockedProfile.setAddress("ottawa");
        mockedProfile.setPhone("3437771753");
        mockedProfile.setUser(new User("admin", "root"));

        when(profileDAO.updateProfile(mockedProfile)).thenReturn(null);
        assertNull(userProfileRepository.getById(any(Long.class)));
    }

    @Test
    void getAllProfiles_success() {
        List<Profile> lists = new ArrayList<>();
        Profile mockedProfile = new Profile();
        mockedProfile.setAddress("ottawa");
        mockedProfile.setPhone("3437771753");
        mockedProfile.setUser(new User("admin", "root"));
        lists.add(mockedProfile);

        when(profileDAO.getAllProfiles()).thenReturn(lists);
        assertEquals(lists.size(), userProfileRepository.findAll().size());
    }

    @Test
    void getAllProfiles_fail() {
        when(profileDAO.getAllProfiles()).thenReturn(null);
        assertNull(userProfileRepository.findAll());
    }
}