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
import com.goal.repository.GoalRepository;
import com.goal.service.UserService;

@Controller
public class HomeController {

	 @Autowired
	    GoalRepository goalRepository;
	@Autowired UserService userService;

    @RequestMapping({"/", "index"})
    public String index() {
        return "home/index";
    }

    @RequestMapping("login")
    public String login() {
        return "home/login";
    }

    @GetMapping("join")
    public String join(Model model) {
        model.addAttribute(new UserRegistration());
        return "home/join";
    }

    @PostMapping("join")
    public String join(Model model,
            @Valid UserRegistration userRegistration, BindingResult bindingResult)
    {
    	if (userService.hasErrors(userRegistration, bindingResult))  {
            return "home/join";
        }
        userService.save(userRegistration);

        return "home/index";
    }

    @RequestMapping("index")
    public String index(Model model) {
        return "user/index";
    }

}
