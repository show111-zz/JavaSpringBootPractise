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

    @DeleteMapping("/profile")
    public ModelAndView deleteProfile() {
        Profile profile = userProfileService.getAllProfiles().get(0);
        this.userProfileService.deleteProfileById(profile.getId());
        return new ModelAndView("add_profile");
    }
}
