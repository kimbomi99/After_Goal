package com.goal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Goal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String userId;
	String goalList;
	boolean success;


	 /*@ManyToOne
     @JoinColumn(name="userId") User user;

	 @ManyToOne
     @JoinColumn(name="userId") Present present;

*/
}