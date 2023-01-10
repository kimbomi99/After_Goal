package com.goal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goal.entity.Goal;
import com.goal.repository.GoalRepository;

@Controller
@RequestMapping("goal")
public class GoalController {

    @Autowired
    GoalRepository goalRepository;

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("goals", goalRepository.findAll());
        return "goal/list";
    }

    @PostMapping("insert")
    public String insert(Model model, Goal goal) {
        goalRepository.save(goal);
        return "redirect:list";
    }

}