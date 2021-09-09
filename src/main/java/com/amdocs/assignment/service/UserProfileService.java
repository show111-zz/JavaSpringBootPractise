package com.amdocs.assignment.service;

import com.amdocs.assignment.model.Profile;

public interface UserProfileService {

    Profile createProfile(Profile profile);

    Profile updateProfile(Profile profile);

    void deleteProfileById(long id);
}
