package com.goal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goal.entity.Goal;
import com.goal.entity.Present;
import com.goal.entity.User;
import com.goal.repository.GoalRepository;
import com.goal.repository.PresentRepository;

@Controller
@RequestMapping("goal")
public class GoalController {

    @Autowired
    GoalRepository goalRepository;
    @Autowired
    PresentRepository presentRepository;


    @RequestMapping("list") //메인화면
    public String list(Model model) {


    	String userId = User.currentUserName();
    	List<Goal> goals = goalRepository.findByUserId(userId);
    	long list_count=goalRepository.countByUserId(userId);
    	long success_count=goalRepository.countByUserIdAndSuccess(userId, true);
    	List<Present> presents=presentRepository.findByUserId(userId);
        model.addAttribute("goals", goals);
        model.addAttribute("list_count", list_count);
        model.addAttribute("success_count", success_count);
        model.addAttribute("presents", presents);
        return "goal/list";
    }

    @PostMapping("insert") //목표작성하기
    public String insert(Model model, Goal goal) {

    	String userId = User.currentUserName();
    	goal.setUserId(userId);
        goalRepository.save(goal);
        return "redirect:list";
    }

    @GetMapping("update") //목표수정하기
    public String update(Model model, @RequestParam("id") int id) {

		Goal goal = goalRepository.findById(id).get();

		model.addAttribute("goal", goal);

		return "goal/update";
	}

    @PostMapping("update") //목표수정하기
	public String update(Model model, Goal goal) {

    	goalRepository.save(goal);

		return "redirect:list";
	}

    @RequestMapping("delete") //목표삭제하기
    public String delete(Model model, int id) {
        goalRepository.deleteById(id);
        return "redirect:list";
    }




    @GetMapping("present") //보상설정하기
    public String present(Model model) {

    	String userId = User.currentUserName();
    	int count = presentRepository.countByUserId(userId);
    	if(count == 0)
    		model.addAttribute("present", new Present());
    	else
    		model.addAttribute("present", presentRepository.findByUserId(userId));
		return "goal/present";
	}

    @PostMapping("present") //보상설정하기
	public String present(Model model, Present present) {

    	String userId = User.currentUserName();
    	present.setUserId(userId);
    	presentRepository.save(present);

		return "redirect:list";
	}


}