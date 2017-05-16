package com.dgut.reallygoodapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.dgut.reallygoodapp.util.DateEntity;

@Entity
public class NewsCompany extends DateEntity {

	CompanyUser companyUser;
	
	String newsText;
	
	Job job;
	Resume resume;
	
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
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	
	@ManyToOne(optional=false)
	public CompanyUser getCompanyUser() {
		return companyUser;
	}
	public void setCompanyUser(CompanyUser companyUser) {
		this.companyUser = companyUser;
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
	
	@Column(nullable=false,updatable=false)
	public boolean isAgent() {
		return isAgent;
	}
	public void setAgent(boolean isAgent) {
		this.isAgent = isAgent;
	}
	
	@Column(nullable=false,updatable=false)
	public boolean isJob() {
		return isJob;
	}
	public void setJob(boolean isJob) {
		this.isJob = isJob;
	}
	
}
