package com.amdocs.assignment.controller;

import com.amdocs.assignment.model.Profile;
import com.amdocs.assignment.model.User;
import com.amdocs.assignment.service.UserLoginService;
import com.amdocs.assignment.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private UserLoginService userLoginService;

    @PostMapping("/profile")
    public ModelAndView createProfile(ModelMap model, @RequestParam String address, @RequestParam String phone) {
        User user = userLoginService.getUser();
        if (user != null) {
            Profile profile = user.getProfile();
            profile.setId(profile.getId());
            profile.setAddress(address);
            profile.setPhone(phone);
            this.userProfileService.createProfile(profile);
            model.put("result", "created success");
            model.put("id", profile.getId());
            model.put("address", address);
            model.put("phone", phone);
        }
        return new ModelAndView("edit_profile");
    }

    @PutMapping("/profile")
    public ModelAndView updateProfile(ModelMap model, @RequestParam String address, @RequestParam String phone) {
        Profile profile = userProfileService.getProfile();
        profile.setId(profile.getId());
        profile.setAddress(address);
        profile.setPhone(phone);
        this.userProfileService.updateProfile(profile);
        model.put("result", "update success");
        model.put("id", profile.getId());
        model.put("address", address);
        model.put("phone", phone);
        return new ModelAndView("add_profile");
    }

    @DeleteMapping("/profile")
    public ModelAndView deleteProfile(ModelMap model) {
        Profile profile = userProfileService.getProfile();
        boolean isSuccess = this.userProfileService.deleteProfileById(profile.getId());
        model.put("result", isSuccess? "Deleted success" : "Deleted failed");
        return new ModelAndView("add_profile");
    }
}
