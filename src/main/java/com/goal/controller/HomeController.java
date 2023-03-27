package com.goal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goal.entity.AllSuccess;
import com.goal.model.UserRegistration;
import com.goal.repository.AllSuccessRepository;
import com.goal.repository.GoalRepository;
import com.goal.service.UserService;

@Controller
public class HomeController {

	 @Autowired
	    GoalRepository goalRepository;
	@Autowired
		UserService userService;
	@Autowired
    	AllSuccessRepository allSuccessRepository;


	//초기화면
    @RequestMapping({"/", "index"})
    public String index(Model model) {

    	//모든 유저 대상, 모든 목표 달성한 유저를 보이기 위해 전달
    	List<AllSuccess> allSuccess=allSuccessRepository.findBySuccess(true);
    	model.addAttribute("allSuccess", allSuccess);

        return "home/index";
    }

    //로그인
    @RequestMapping("login")
    public String login() {
        return "home/login";
    }


    //회원가입
    @GetMapping("join")
    public String join(Model model) {
        model.addAttribute(new UserRegistration());
        return "home/join";
    }

    @PostMapping("join")
    public String join(Model model,
            @Valid UserRegistration userRegistration, BindingResult bindingResult)
    {
    	if (userService.hasErrors(userRegistration, bindingResult))  { //에러발생 시 페이지 넘김없이 에러메시지를 보여줌
            return "home/join";
        }
        userService.save(userRegistration);

        return "redirect:index";
    }



}
