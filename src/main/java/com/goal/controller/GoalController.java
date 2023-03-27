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


    //메인화면
    @RequestMapping("list")
    public String list(Model model) {

    	String userId = User.currentUserName();

    	//해당 유저의 목표리스트
    	List<Goal> goals = goalRepository.findByUserId(userId);

    	//해당 유저의 총 목표 갯수
    	long list_count=goalRepository.countByUserId(userId);

    	//해당 유저의 총 목표 달성 갯수
    	long success_count=goalRepository.countByUserIdAndSuccess(userId, true);

    	//모든 유저대상, 목표 모두 달성한 유저리스트
    	List<AllSuccess> allSuccess=allSuccessRepository.findBySuccess(true);

    	//해당 유저가 설정한 보상 및 다짐
    	Present present=presentRepository.findByUserId(userId);

        model.addAttribute("goals", goals);
        model.addAttribute("list_count", list_count);
        model.addAttribute("success_count", success_count);
        model.addAttribute("image", present);
        model.addAttribute("allSuccess", allSuccess);

        return "goal/list";
    }


    //목표작성하기
    @PostMapping("insert")
    public String insert(Model model, Goal goal, AllSuccess allSuccess) {

    	String userId = User.currentUserName();
    	goal.setUserId(userId);
        goalRepository.save(goal);

        //목표가 전부 달성되었는지 여부 저장
        allSuccessService.save(userId);

        return "redirect:list";
    }

    //목표수정하기
    @GetMapping("update")
    public String update(Model model, @RequestParam("id") int id) {

		Goal goal = goalRepository.findById(id);

		model.addAttribute("goal", goal);

		return "goal/update";
	}

    @PostMapping("update")
	public String update(Model model, Goal goal) {

    	goalRepository.save(goal);

    	String userId = User.currentUserName();
    	//목표가 전부 달성되었는지 여부 저장
    	allSuccessService.save(userId);

		return "redirect:list";
	}

    //목표삭제하기-> 갯수가0일 경우 목표완료로 보지 않음을 처리해야함
    @RequestMapping("delete")
    public String delete(Model model, int id) {

        goalRepository.deleteById(id);

        String userId = User.currentUserName();
      //목표가 전부 달성되었는지 여부 저장
        allSuccessService.save(userId);

        return "redirect:list";
    }

    //보상설정하기
    @GetMapping("present")
    public String present(Model model) {

    	String userId = User.currentUserName();
    	int count = presentRepository.countByUserId(userId);

    	//조건: 보상을 설정했는지 안했는지 여부
    	if(count == 0)//안했을 경우, 새로운 객체 생성하여 전달
    		model.addAttribute("present", new Present());
    	else //존재하는 경우, 찾아서 전달
    		model.addAttribute("present", presentRepository.findByUserId(userId));

		return "goal/present";
	}

    @Transactional
    @PostMapping("present")
	public String present(HttpServletRequest request, @RequestPart MultipartFile files, Model model, Present present) throws Exception {

    	//이미지 경로에서 원래 파일 이름을 가져온다.
    	String sourceFileName=files.getOriginalFilename();

    	//확장자를 소문자로 가져온다.
    	String sourceFileNameExtension=FilenameUtils.getExtension(sourceFileName).toLowerCase();
    	File destinationFile;
    	String destinationFileName;

    	//이미지 파일을 저장할 곳
    	String fileUrl="C:/imageUpload/";

    	//폴더 내에 이미지 파일끼리 이름이 겹칠 경우를 대비한 처리+최종경로
    	do {
    		destinationFileName=RandomStringUtils.randomAlphanumeric(32)+"."+sourceFileNameExtension;
    		destinationFile=new File(fileUrl+destinationFileName);
    	}while(destinationFile.exists());

    	//부모 폴더 생성
    	destinationFile.getParentFile().mkdirs();

    	//만든 경로와 이름으로 업로드하기위한 작업
    	files.transferTo(destinationFile);

    	//Service에서 저장처리
    	presentService.save(destinationFileName, sourceFileName, fileUrl, present);


		return "redirect:list";
	}


}