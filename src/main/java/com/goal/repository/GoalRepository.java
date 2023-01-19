package com.goal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goal.entity.Goal;


public interface GoalRepository extends JpaRepository<Goal, Integer> {

	List<Goal> findByUserId(String userId);
	Long countByUserId(String userId);

	Long countByUserIdAndSuccess(String userId, Boolean success);
}
