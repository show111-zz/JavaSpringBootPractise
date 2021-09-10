package com.amdocs.assignment.controller;

import com.amdocs.assignment.model.Profile;
import com.amdocs.assignment.model.User;
import com.amdocs.assignment.service.UserLoginService;
import com.amdocs.assignment.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        }
        return new ModelAndView("profile");
    }

    @PutMapping("/profile/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable long id, @RequestBody Profile profile) {
        profile.setId(id);
        return ResponseEntity.ok().body(this.userProfileService.updateProfile(profile));
    }

    @DeleteMapping("/profile/{id}")
    public HttpStatus deleteProfile(@PathVariable long id) {
        this.userProfileService.deleteProfileById(id);
        return HttpStatus.OK;
    }
}
