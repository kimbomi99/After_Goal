package com.goal.entity;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Present {

	@Id
	String userId;

	String filename;
	String fileOriName;
	String fileurl;
	String resolution;

}
