package com.dgut.reallygoodapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.dgut.reallygoodapp.util.BaseEntity;

@Entity
public class Post extends BaseEntity {
	
	Resume resume;			//职务所属

	String startTime;		//开始时间
	String endTime;			//结束时间
	String postName;		//职务名称
	String describe;		//描述
	
	@ManyToOne(optional=false)
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
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	
	@Column(nullable=false,updatable=false)
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
}
