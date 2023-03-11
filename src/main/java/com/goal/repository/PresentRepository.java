package com.goal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goal.entity.Present;


public interface PresentRepository extends JpaRepository<Present, Integer> {


	int countByUserId(String userId);

	Present findByUserId(String userId);

	void deleteAllByUserId(String userId);

}