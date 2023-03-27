package com.goal.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goal.entity.Present;
import com.goal.entity.User;
import com.goal.repository.PresentRepository;

@Service
public class PresentService {

	 @Autowired
	    public PresentRepository presentRepository;

	public void save(String destinationFileName, String sourceFileName, String fileUrl, Present present) {
		String userId = User.currentUserName();

		Present present1= new Present();

    	Present userPresent= presentRepository.findByUserId(userId);
    	if(userPresent!=null) {
    		String findfile=userPresent.getFilename();
    		String path =  "C:\\imageUpload\\";
        	//현재 리스트에 존재하는 파일객체를 만듬
        	File file = new File(path + "\\" + findfile);
        	file.delete(); // 파일 삭제
    		presentRepository.deleteAllByUserId(userId);
    	}

    	present1.setUserId(userId);
    	present1.setFilename(destinationFileName);
    	present1.setFileOriName(sourceFileName);
    	present1.setFileurl(fileUrl);
    	present1.setResolution(present.getResolution());
    	presentRepository.save(present1);
	}

}
