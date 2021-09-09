package com.amdocs.assignment.controller;

import com.amdocs.assignment.model.User;
import com.amdocs.assignment.service.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserLoginController {

    @Autowired
    UserLoginServiceImpl userLoginService;

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
            model.put("name", user.getName());
            return new ModelAndView("profile");
        }
        model.put("errorMsg", "Please provide a correct userId and password");
        return new ModelAndView("login");
    }
}
