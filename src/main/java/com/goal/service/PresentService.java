package com.goal.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.goal.entity.Present;
import com.goal.repository.PresentRepository;

public class PresentService {

	@Autowired
	PresentRepository presentRepository;

	public void save(Present present) {
		Present presents = new Present();
		presents.setUserId(present.getUserId());
		presents.setFilename(present.getFilename());
		presents.setFileOriName(present.getFileOriName());
		presents.setFileurl(present.getFileurl());
		presents.setResolution(present.getResolution());

		presentRepository.save(presents);
	}
}
