package com.amdocs.assignment.dao;

import com.amdocs.assignment.model.Profile;

public interface ProfileDAO {
    Profile createProfile(Profile profile);

    Profile updateProfile(Profile profile);

    void deleteProfile(long id);
}
