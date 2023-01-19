package com.goal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import lombok.Data;

 @Data
@Entity
public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

   String userId;
   String name;
   String password;
   String email;
   boolean enabled;

   public static String currentUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userid=authentication.getName();
		return userid;
	}

}