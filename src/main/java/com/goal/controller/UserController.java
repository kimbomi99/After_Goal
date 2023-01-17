package com.goal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goal.model.UserRegistration;
import com.goal.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired UserService userService;

    @GetMapping("join")
    public String join(Model model) {
        model.addAttribute(new UserRegistration());
        return "user/join";
    }

    @PostMapping("join")
    public String join(Model model,
            @Valid UserRegistration userRegistration, BindingResult bindingResult)
    {
    	if (userService.hasErrors(userRegistration, bindingResult))  {
            return "user/join";
        }
        userService.save(userRegistration);
        return "goal/list";
    }

    @RequestMapping("index")
    public String index(Model model) {
        return "user/index";
    }

}
