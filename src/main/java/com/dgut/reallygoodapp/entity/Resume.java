package com.dgut.reallygoodapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.dgut.reallygoodapp.util.BaseEntity;

@Entity
public class Resume extends BaseEntity {

	StudentUser studentUser;

	@OneToOne(optional=false,cascade=CascadeType.REFRESH)
	@JoinColumn(name="student_id",referencedColumnName="id",unique=true)
	public StudentUser getStudentUser() {
		return studentUser;
	}

	public void setStudentUser(StudentUser studentUser) {
		this.studentUser = studentUser;
	}
	
	
}
