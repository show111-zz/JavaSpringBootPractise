package com.amdocs.assignment.service;

import com.amdocs.assignment.model.Profile;

import java.util.List;

public interface UserProfileService {

    /**
     * Get a profile
     * @param id id
     * @return the new profile
     */
    Profile getProfile(long id);

    /**
     * Create a new profile
     * @param profile profile
     * @return the profile
     */
    Profile createProfile(Profile profile);

    /**
     * Update profile base on a new profile
     * @param profile profile
     * @return the updated profile
     */
    Profile updateProfile(Profile profile);

    /**
     * Delete profile from id
     * @param id id
     */
    void deleteProfileById(long id);

    /**
     * Get all of the profiles
     * @return the list of all of the profiles
     */
     List<Profile> getAllProfiles();
}
