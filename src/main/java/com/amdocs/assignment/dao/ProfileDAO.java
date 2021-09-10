package com.amdocs.assignment.dao;

import com.amdocs.assignment.model.Profile;

public interface ProfileDAO {
    Profile getProfile();

    Profile createProfile(Profile profile);

    Profile updateProfile(Profile profile);

    boolean deleteProfile(long id);
}
