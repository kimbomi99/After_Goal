package com.goal.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

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

}