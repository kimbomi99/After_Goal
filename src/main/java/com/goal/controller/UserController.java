package com.goal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

	//사용자 정보
    @RequestMapping("index")
    public String index(Model model) {
        return "user/index";
    }

}
