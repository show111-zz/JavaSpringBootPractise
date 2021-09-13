package com.amdocs.assignment.dao;

import com.amdocs.assignment.model.Profile;

import java.util.List;

public interface ProfileDAO {
    /**
     * According to the id retrive the profile object
     * @param id the id for the profile id
     * @return Find the retrieved profile from id
     */
    Profile getProfile(long id);

    /**
     * Create the new profile to the user
     * @param profile the new profile
     * @return return the new profile object
     */
    Profile createProfile(Profile profile);

    /**
     * Updated the profile information
     * @param profile the updated profile
     * @return the new updated profile
     */
    Profile updateProfile(Profile profile);

    /**
     * Delete the profile according to the id
     * @param id the id of profile
     */
    void deleteProfile(long id);

    /**
     * Get all of the profiles from the database
     * @return the list of profiles
     */
    List<Profile> getAllProfiles();
}
