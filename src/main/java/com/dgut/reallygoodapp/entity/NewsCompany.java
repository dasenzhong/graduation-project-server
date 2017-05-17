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
	Integer deal;
	boolean isdeal;
	
	@Column(nullable=false)
	public boolean isIsdeal() {
		return isdeal;
	}
	public void setIsdeal(boolean isdeal) {
		this.isdeal = isdeal;
	}
	
	@Column(nullable=false,updatable=false)
	public Integer getDeal() {
		return deal;
	}
	public void setDeal(Integer deal) {
		this.deal = deal;
	}
	
	@ManyToOne(optional=true)
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	
	@ManyToOne(optional=true)
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
	
}
