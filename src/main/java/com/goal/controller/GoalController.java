package com.goal.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.goal.entity.AllSuccess;
import com.goal.entity.Goal;
import com.goal.entity.Present;
import com.goal.entity.User;
import com.goal.repository.AllSuccessRepository;
import com.goal.repository.GoalRepository;
import com.goal.repository.PresentRepository;
import com.goal.service.AllSuccessService;
import com.goal.service.PresentService;

@Controller
@RequestMapping("goal")
public class GoalController {

    @Autowired
    GoalRepository goalRepository;
    @Autowired
  	PresentRepository presentRepository;
    @Autowired
  	PresentService presentService;
    @Autowired
  	AllSuccessRepository allSuccessRepository;
    @Autowired
  	AllSuccessService allSuccessService;


    @RequestMapping("list") //메인화면
    public String list(Model model) {


    	String userId = User.currentUserName();
    	List<Goal> goals = goalRepository.findByUserId(userId);
    	long list_count=goalRepository.countByUserId(userId);
    	long success_count=goalRepository.countByUserIdAndSuccess(userId, true);

    	List<AllSuccess> allSuccess=allSuccessRepository.findBySuccess(true);

    	Present present=presentRepository.findByUserId(userId);

    	model.addAttribute("userId", userId);
        model.addAttribute("goals", goals);
        model.addAttribute("list_count", list_count);
        model.addAttribute("success_count", success_count);
        model.addAttribute("image", present);
        model.addAttribute("allSuccess", allSuccess);

        return "goal/list";
    }

    @PostMapping("insert") //목표작성하기
    public String insert(Model model, Goal goal, AllSuccess allSuccess) {

    	String userId = User.currentUserName();
    	goal.setUserId(userId);
        goalRepository.save(goal);
        allSuccessService.save(userId);

        return "redirect:list";
    }

    @GetMapping("update") //목표수정하기
    public String update(Model model, @RequestParam("id") int id) {

		Goal goal = goalRepository.findById(id);

		model.addAttribute("goal", goal);

		return "goal/update";
	}

    @PostMapping("update") //목표수정하기
	public String update(Model model, Goal goal) {
    	String userId = User.currentUserName();
    	goalRepository.save(goal);
    	allSuccessService.save(userId);

		return "redirect:list";
	}

    @RequestMapping("delete") //목표삭제하기-> 갯수가0일 경우 목표완료로 보지 않음을 처리해야함
    public String delete(Model model, int id) {

        goalRepository.deleteById(id);
        String userId = User.currentUserName();
        allSuccessService.save(userId);

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



    @Transactional
    @PostMapping("present") //보상설정하기
	public String present(HttpServletRequest request, @RequestPart MultipartFile files, Model model, Present present) throws Exception {

    	String sourceFileName=files.getOriginalFilename();
    	String sourceFileNameExtension=FilenameUtils.getExtension(sourceFileName).toLowerCase();
    	File destinationFile;
    	String destinationFileName;
    	String fileUrl="C:/imageUpload/";
    			//"C:/Users/LG/Documents/workspace-spring-tool-suite-4-4.11.0.RELEASE/AfterGoal1/src/main/resources/static/images/";

    	do {
    		destinationFileName=RandomStringUtils.randomAlphanumeric(32)+"."+sourceFileNameExtension;
    		destinationFile=new File(fileUrl+destinationFileName);
    	}while(destinationFile.exists());

    	destinationFile.getParentFile().mkdirs();
    	files.transferTo(destinationFile);

    	presentService.save(destinationFileName, sourceFileName, fileUrl, present);

		return "redirect:list";
	}


}