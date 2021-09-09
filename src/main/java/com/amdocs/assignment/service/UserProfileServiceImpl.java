package com.amdocs.assignment.service;

import com.amdocs.assignment.dao.ProfileDAOImpl;
import com.amdocs.assignment.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    ProfileDAOImpl profileDAO;

    @Override
    public Profile createProfile(Profile profile) {
        return profileDAO.createProfile(profile);
    }

    @Override
    public Profile updateProfile(Profile profile) {
        return profileDAO.updateProfile(profile);
    }

    @Override
    public void deleteProfileById(long id) {
        profileDAO.deleteProfile(id);
    }
}
