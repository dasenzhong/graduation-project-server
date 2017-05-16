package com.dgut.reallygoodapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.dgut.reallygoodapp.util.DateEntity;

@Entity
public class NewsStudent extends DateEntity {

	StudentUser studentUser;
	
	String newsText;
	
	Job job;
	
	boolean isRead;
	boolean isAgent;
	boolean isJob;
	
	@ManyToOne(optional=false)
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	
	@ManyToOne(optional=false)
	public StudentUser getStudentUser() {
		return studentUser;
	}
	public void setStudentUser(StudentUser studentUser) {
		this.studentUser = studentUser;
	}
	
	@Column(nullable=false)
	public String getNewsText() {
		return newsText;
	}
	public void setNewsText(String newsText) {
		this.newsText = newsText;
	}
	
	@Column(nullable=false)
	public boolean isRead() {
		return isRead;
	}
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
	
	@Column(nullable=false)
	public boolean isAgent() {
		return isAgent;
	}
	public void setAgent(boolean isAgent) {
		this.isAgent = isAgent;
	}
	
	@Column(nullable=false)
	public boolean isJob() {
		return isJob;
	}
	public void setJob(boolean isJob) {
		this.isJob = isJob;
	}
}
