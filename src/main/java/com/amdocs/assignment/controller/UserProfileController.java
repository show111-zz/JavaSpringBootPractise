package com.amdocs.assignment.controller;

import com.amdocs.assignment.model.Profile;
import com.amdocs.assignment.model.User;
import com.amdocs.assignment.service.UserLoginService;
import com.amdocs.assignment.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private UserLoginService userLoginService;

    /**
     * Post request for the http://localhost/profile. It will create a new profile to the related user.
     * @param model
     * @param address user's address
     * @param phone user's phone number
     * @return It will load the edit_profile page after creating profile information.
     */
    @PostMapping("/profile")
    public ModelAndView createProfile(ModelMap model, @RequestParam String address, @RequestParam String phone) {
        User user = userLoginService.getUser();
        List<Profile> profiles = userProfileService.getAllProfiles();
        if (profiles != null && profiles.size() != 0) {
            for (Profile p : profiles) {
                if (p.getUser().getId() == user.getId()) {
                    p.setAddress(address);
                    p.setPhone(phone);
                    this.userProfileService.updateProfile(p);
                    model.put("id", p.getId());
                }
            }
        } else {
            Profile profileCreate = new Profile();
            profileCreate.setAddress(address);
            profileCreate.setPhone(phone);
            profileCreate.setUser(user);
            this.userProfileService.createProfile(profileCreate);
            model.put("id", profileCreate.getId());
        }

        model.put("address", address);
        model.put("phone", phone);
        return new ModelAndView("edit_profile");
    }

    /**
     * Put request for the http://localhost/profile. It will update profile's information.
     * @param model
     * @param id the id for the old profile
     * @param address user's address
     * @param phone user's phone number
     * @return
     */
    @PutMapping("/profile")
    public ModelAndView updateProfile(ModelMap model, @RequestParam long id, @RequestParam String address, @RequestParam String phone) {
        Profile profile = userProfileService.getProfile(id);
        profile.setAddress(address);
        profile.setPhone(phone);
        this.userProfileService.updateProfile(profile);
        model.put("id", profile.getId());
        model.put("address", address);
        model.put("phone", phone);
        return new ModelAndView("add_profile");
    }

    /**
     * Delete request for the http://localhost/profile. It will delete the profile's information to the related user.
     * @return It will load the add_profile page after deleting the profile information.
     */
    @DeleteMapping("/profile")
    public ModelAndView deleteProfile() {
        Profile profile = userProfileService.getAllProfiles().get(0);
        this.userProfileService.deleteProfileById(profile.getId());
        return new ModelAndView("add_profile");
    }
}
