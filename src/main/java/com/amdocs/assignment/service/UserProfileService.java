package com.amdocs.assignment.service;

import com.amdocs.assignment.model.Profile;

import java.util.List;

public interface UserProfileService {

    Profile getProfile(long id);

    Profile createProfile(Profile profile);

    Profile updateProfile(Profile profile);

    boolean deleteProfileById(long id);

    List<Profile> getAllProfiles();
}
