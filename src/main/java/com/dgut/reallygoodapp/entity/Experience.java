package com.dgut.reallygoodapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.dgut.reallygoodapp.util.DateEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Experience extends DateEntity {

	Resume resume;				//工作经验所属
	
	String startTime;			//入职时间
	String endTime;				//离职时间
	String companyName;			//公司名称
	String companyPost;			//公司职务
	String describe;			//描述
	String type;				//类型
	
	@ManyToOne(optional=false)
	@JsonIgnore
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	
	@Column(nullable=false,updatable=false)
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	@Column(nullable=false,updatable=false)
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	@Column(nullable=false,updatable=false)
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Column(nullable=false,updatable=false)
	public String getCompanyPost() {
		return companyPost;
	}
	public void setCompanyPost(String companyPost) {
		this.companyPost = companyPost;
	}
	
	@Column(nullable=false,updatable=false)
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	@Column(nullable=false,updatable=false)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
