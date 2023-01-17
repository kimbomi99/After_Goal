package com.goal.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import lombok.Data;

@Data
@Entity
public class User {

   @Id
   String userId;

   String name;
   String password;
   String email;
   boolean enabled;
   int list_count;
   int success_count;

   public static String currentUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userid=authentication.getName();
		return userid;
	}

}