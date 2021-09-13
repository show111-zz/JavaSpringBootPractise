package com.amdocs.assignment.controller;

import com.amdocs.assignment.model.Profile;
import com.amdocs.assignment.service.UserLoginService;
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
    UserLoginService userLoginService;

    @Autowired
    private UserProfileService userProfileService;

    /**
     * the init Get request
     * @return
     */
    @RequestMapping(value = "/")
    public ModelAndView initLogin2() {
        return new ModelAndView("index");
    }

    /**
     * Get request for the http://localhost/assignment
     * @return the login page that let user input the username and password
     */
    @RequestMapping(value = "/assignment")
    public ModelAndView initLogin() {
        return new ModelAndView("login");
    }

    /**
     * Post request for the http://localhost/assignment with the parameter username and password
     * @param model
     * @param name username
     * @param password  password
     * @return if the username and password have permitted then load the add_profile page, if not will load the login page
     */
    @PostMapping(value = "/assignment")
    public ModelAndView login(ModelMap model, @RequestParam String name, @RequestParam String password) {
        if (userLoginService.login(name, password) != null) {
            List<Profile> profiles = userProfileService.getAllProfiles();
            if(profiles != null && profiles.size() != 0){
                model.put("id", profiles.get(0).getId());
                model.put("address", profiles.get(0).getAddress());
                model.put("phone", profiles.get(0).getPhone());
            }
            return new ModelAndView("add_profile");
        }
        model.put("errorMsg", "Please provide a correct userName and password");
        return new ModelAndView("login");
    }
}
