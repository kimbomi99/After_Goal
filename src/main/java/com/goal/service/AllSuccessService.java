package com.goal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goal.entity.AllSuccess;
import com.goal.repository.AllSuccessRepository;
import com.goal.repository.GoalRepository;

@Service
public class AllSuccessService {

	 @Autowired
	    public AllSuccessRepository allSuccessRepository;
	 @Autowired
	    public GoalRepository goalRepository;

	 public void save(String userId) {

		    //해당 유저의 목표 갯수
		    long list_count=goalRepository.countByUserId(userId);
	        //해당 유저의 목표 달성 갯수
		    long success_count=goalRepository.countByUserIdAndSuccess(userId, true);

	    	 AllSuccess allSuccess=allSuccessRepository.findByUserId(userId);

	    	 if(allSuccess==null) { //보상설정을 처음하는 경우
	         	allSuccess=new AllSuccess();
	         	allSuccess.setUserId(userId);
	         }

	         //&&부분은 삭제수행시 필요
	    	if(list_count==success_count && list_count!=0) { //목표갯수와 목표달성갯수 비교

	    		allSuccess.setSuccess(true);
	    	}
	    	else {

	    		allSuccess.setSuccess(false);
	    	}
	    	allSuccessRepository.save(allSuccess);

	 }

}
