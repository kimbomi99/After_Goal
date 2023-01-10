package com.goal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goal.entity.Goal;

public interface GoalRepository extends JpaRepository<Goal, Integer> { }
