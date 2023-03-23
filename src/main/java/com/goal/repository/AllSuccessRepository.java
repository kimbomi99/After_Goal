package com.goal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goal.entity.AllSuccess;

public interface AllSuccessRepository extends JpaRepository<AllSuccess, Integer> {

	List<AllSuccess> findBySuccess(Boolean success);
	AllSuccess findByUserId(String userId);
}