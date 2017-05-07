package com.dgut.reallygoodapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.dgut.reallygoodapp.util.BaseEntity;
import com.dgut.reallygoodapp.util.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CompanyUser extends UserEntity{

	String province;
	String city;
	String town;
	String companyName;
	String log;
	String avatar;
	
	@Column(nullable=false)
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	@Column(nullable=true)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(nullable=true)
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	
	@Column(nullable=false)
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
