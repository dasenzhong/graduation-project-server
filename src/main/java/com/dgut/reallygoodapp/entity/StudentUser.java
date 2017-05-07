package com.dgut.reallygoodapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.dgut.reallygoodapp.util.BaseEntity;
import com.dgut.reallygoodapp.util.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class StudentUser extends UserEntity{
	
	String sex;				//性别
	String name;			//昵称
	String area;			//地区
	String school;			//学校
	String log;				//个性签名
	String avatar;			//头像
	
	@Column(nullable=false,updatable=false)
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Column(nullable=true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(nullable=true)
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	@Column(nullable=true)
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	
	@Column(nullable=true)
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
	
	@Column(nullable=true)
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
}
