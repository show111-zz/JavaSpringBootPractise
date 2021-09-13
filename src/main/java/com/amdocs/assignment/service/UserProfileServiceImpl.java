package com.amdocs.assignment.service;

import com.amdocs.assignment.dao.ProfileDAOImpl;
import com.amdocs.assignment.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    ProfileDAOImpl profileDAO;

    /**
     * Get profile
     * @param id id
     * @return the profile
     */
    @Override
    public Profile getProfile(long id) {
        return profileDAO.getProfile(id);
    }

    /**
     * Create profile
     * @param profile profile
     * @return the new created profile
     */
    @Override
    public Profile createProfile(Profile profile) {
        return profileDAO.createProfile(profile);
    }

    /**
     * Update profile
     * @param profile profile
     * @return the updated profile
     */
    @Override
    public Profile updateProfile(Profile profile) {
        return profileDAO.updateProfile(profile);
    }

    /**
     * Delete the profile according to the id
     * @param id id
     */
    @Override
    public void deleteProfileById(long id) {
        profileDAO.deleteProfile(id);
    }

    /**
     * Get all profiles
     * @return List<Profile>
     */
    @Override
    public List<Profile> getAllProfiles() {
        return profileDAO.getAllProfiles();
    }
}
