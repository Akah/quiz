package com.rob.quiz.controller;


import com.rob.quiz.model.MongoUser;
import com.rob.quiz.service.security.SecurityService;
import com.rob.quiz.service.user.UserService;
import com.rob.quiz.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm",new MongoUser());
        return  "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") MongoUser userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
        if(bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getPassword());
        return "login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userForm",new MongoUser());
        return  "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        securityService.logout(request, response);
        return "/login";
    }

}
