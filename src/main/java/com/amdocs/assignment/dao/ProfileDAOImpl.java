package com.amdocs.assignment.dao;

import com.amdocs.assignment.model.Profile;
import com.amdocs.assignment.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProfileDAOImpl implements ProfileDAO {

    @Autowired
    private UserProfileRepository userProfileRepository;

    /**
     * Get profile according to the id
     * @param id the id for the profile id
     * @return
     */
    @Override
    public Profile getProfile(long id) {
        Optional<Profile> profile = userProfileRepository.findById(id);
        return profile.orElse(null);
    }

    /**
     * Create profile
     * @param profile the new profile
     * @return the profile
     */
    public Profile createProfile(Profile profile) {
        return userProfileRepository.save(profile);
    }

    /**
     * Updated profile
     * @param profile the updated profile
     * @return the new Profile
     */
    @Override
    public Profile updateProfile(Profile profile) {
        Optional<Profile> profileDB = this.userProfileRepository.findById(profile.getId());
        if (profileDB.isPresent()) {
            Profile profileUpdated = profileDB.get();
            profileUpdated.setId(profile.getId());
            profileUpdated.setAddress(profile.getAddress());
            profileUpdated.setPhone(profile.getPhone());
            userProfileRepository.save(profileUpdated);
            return profileUpdated;
        } else {
            return null;
        }
    }

    /**
     * Delete the profile base on the id value
     * @param id the id of profile
     */
    @Override
    public void deleteProfile(long id) {
        Optional<Profile> profileDB = this.userProfileRepository.findById(id);
        if (profileDB.isPresent()) {
            userProfileRepository.delete(profileDB.get());
        }
    }

    /**
     * Get all of the profiles
     * @return List<Profile>
     */
    @Override
    public List<Profile> getAllProfiles() {
        return this.userProfileRepository.findAll();
    }
}
