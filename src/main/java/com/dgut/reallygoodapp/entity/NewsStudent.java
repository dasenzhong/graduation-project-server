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
	Integer deal;
	boolean isPass;
	String meetTime;
	String meetAddress;
	String telephone;
	
	
	@Column(nullable=true)
	public String getMeetTime() {
		return meetTime;
	}
	public void setMeetTime(String meetTime) {
		this.meetTime = meetTime;
	}
	
	@Column(nullable=true)
	public String getMeetAddress() {
		return meetAddress;
	}
	public void setMeetAddress(String meetAddress) {
		this.meetAddress = meetAddress;
	}
	
	@Column(nullable=true)
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Column(nullable=false)
	public boolean isPass() {
		return isPass;
	}
	public void setPass(boolean isPass) {
		this.isPass = isPass;
	}
	
	@Column(nullable=false,updatable=false)
	public Integer getDeal() {
		return deal;
	}
	public void setDeal(Integer deal) {
		this.deal = deal;
	}
	
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
	
}
