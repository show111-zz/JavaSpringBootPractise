package com.amdocs.assignment.controller;

import com.amdocs.assignment.model.Profile;
import com.amdocs.assignment.model.User;
import com.amdocs.assignment.service.UserLoginServiceImpl;
import com.amdocs.assignment.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserLoginController {

    @Autowired
    UserLoginServiceImpl userLoginService;

    @Autowired
    private UserProfileService userProfileService;

    @RequestMapping(value = "/assignment")
    public ModelAndView myLogin() {
        return new ModelAndView("login");
    }

    @PostMapping(value = "/assignment")
    public ModelAndView login(ModelMap model, @RequestParam String name, @RequestParam String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        if (userLoginService.login(user)) {

            List<Profile> profiles = userProfileService.getAllProfiles();
            if(profiles != null && profiles.size() != 0){
                model.put("id", profiles.get(0).getId());
                model.put("address", profiles.get(0).getAddress());
                model.put("phone", profiles.get(0).getPhone());
            }
            model.put("name", name);
            return new ModelAndView("add_profile");
        }
        model.put("errorMsg", "Please provide a correct userName and password");
        return new ModelAndView("login");
    }
}
