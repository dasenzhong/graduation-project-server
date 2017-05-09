package com.dgut.reallygoodapp.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.dgut.reallygoodapp.util.BaseEntity;

@Entity
public class Resume extends BaseEntity {

	StudentUser studentUser;

	@OneToOne(optional=false)
	public StudentUser getStudentUser() {
		return studentUser;
	}

	public void setStudentUser(StudentUser studentUser) {
		this.studentUser = studentUser;
	}
	
	
}
