package com.goal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goal.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}