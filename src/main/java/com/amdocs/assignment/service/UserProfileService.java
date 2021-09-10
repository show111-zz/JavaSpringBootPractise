package com.amdocs.assignment.service;

import com.amdocs.assignment.model.Profile;

public interface UserProfileService {

    Profile getProfile();

    Profile createProfile(Profile profile);

    Profile updateProfile(Profile profile);

    boolean deleteProfileById(long id);
}
