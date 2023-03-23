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

		 long list_count=goalRepository.countByUserId(userId);
	    	long success_count=goalRepository.countByUserIdAndSuccess(userId, true);

	    	 AllSuccess allSuccess=allSuccessRepository.findByUserId(userId);
	         if(allSuccess==null) {
	         	allSuccess=new AllSuccess();
	         }

	         //&&부분은 삭제수행시 필요
	    	if(list_count==success_count && list_count!=0) {
	    		allSuccess.setUserId(userId);
	    		allSuccess.setSuccess(true);
	    	}
	    	else {
	    		allSuccess.setUserId(userId);
	    		allSuccess.setSuccess(false);
	    	}
	    	allSuccessRepository.save(allSuccess);

	 }

}
