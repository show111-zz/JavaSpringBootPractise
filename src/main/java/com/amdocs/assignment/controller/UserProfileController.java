package com.amdocs.assignment.controller;

import com.amdocs.assignment.model.Profile;
import com.amdocs.assignment.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/profile")
    public ResponseEntity<Profile> save(@RequestBody Profile profile) {
        return ResponseEntity.ok().body(this.userProfileService.createProfile(profile));
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
