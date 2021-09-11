package com.amdocs.assignment.dao;

import com.amdocs.assignment.model.Profile;

import java.util.List;

public interface ProfileDAO {
    Profile getProfile(long id);

    Profile createProfile(Profile profile);

    Profile updateProfile(Profile profile);

    boolean deleteProfile(long id);

    List<Profile> getAllProfiles();
}
