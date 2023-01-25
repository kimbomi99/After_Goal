package com.goal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goal.entity.Present;


public interface PresentRepository extends JpaRepository<Present, Integer> {

	List<Present> findByUserId(String userId);
	int countByUserId(String userId);

}