package com.amdocs.assignment.dao;

import com.amdocs.assignment.model.Profile;
import com.amdocs.assignment.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProfileDAOImpl implements ProfileDAO {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public Profile createProfile(Profile profile) {
        return userProfileRepository.save(profile);
    }

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

    @Override
    public void deleteProfile(long id) {
        Optional<Profile> profileDB = this.userProfileRepository.findById(id);
        if (profileDB.isPresent()) {
            userProfileRepository.delete(profileDB.get());
        }
    }
}
