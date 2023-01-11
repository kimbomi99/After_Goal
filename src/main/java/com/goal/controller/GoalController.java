package com.goal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("update")
    public String update(Model model, @RequestParam("id") int id) {

		Goal goal = goalRepository.findById(id).get();

		model.addAttribute("goal", goal);

		return "goal/update";
	}

    @PostMapping("update")
	public String update(Model model, Goal goal) {
		goalRepository.save(goal);

		return "redirect:list";
	}

    @RequestMapping("delete")
    public String delete(Model model, int id) {
        goalRepository.deleteById(id);
        return "redirect:list";
    }



}