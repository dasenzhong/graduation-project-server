package com.dgut.reallygoodapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.dgut.reallygoodapp.util.BaseEntity;

@Entity
public class Job extends BaseEntity {

	CompanyUser companyUser;	//工作所属
	
	String jobName;		//工作名名
	String jobType;		//工作类型
	String number;		//招募人数
	String education;	//学历
	String money;		//薪酬
	String decribe;		//描述
	String employProvince;		//招募省份
	String employCity;			//招募城市
	String employTown;			//招募城镇
	String workProvince;		//工作省份
	String workCity;			//工作城市
	String workTown;			//工作城镇
	String workAddress;			//详细地址
	
	
	@ManyToOne(optional=false)
	public CompanyUser getCompanyUser() {
		return companyUser;
	}
	public void setCompanyUser(CompanyUser companyUser) {
		this.companyUser = companyUser;
	}
	
	@Column(nullable=false,updatable=false)
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	@Column(nullable=false,updatable=false)
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	
	@Column(nullable=false,updatable=false)
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	@Column(nullable=false,updatable=false)
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	
	@Column(nullable=false,updatable=false)
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	
	@Column(nullable=false,updatable=false)
	public String getDecribe() {
		return decribe;
	}
	public void setDecribe(String decribe) {
		this.decribe = decribe;
	}
	
	@Column(nullable=false,updatable=false)
	public String getEmployProvince() {
		return employProvince;
	}
	public void setEmployProvince(String employProvince) {
		this.employProvince = employProvince;
	}
	
	@Column(nullable=false,updatable=false)
	public String getEmployCity() {
		return employCity;
	}
	public void setEmployCity(String employCity) {
		this.employCity = employCity;
	}
	
	@Column(nullable=false,updatable=false)
	public String getEmployTown() {
		return employTown;
	}
	public void setEmployTown(String employTown) {
		this.employTown = employTown;
	}
	
	@Column(nullable=false,updatable=false)
	public String getWorkProvince() {
		return workProvince;
	}
	public void setWorkProvince(String workProvince) {
		this.workProvince = workProvince;
	}
	
	@Column(nullable=false,updatable=false)
	public String getWorkCity() {
		return workCity;
	}
	public void setWorkCity(String workCity) {
		this.workCity = workCity;
	}
	
	@Column(nullable=false,updatable=false)
	public String getWorkTown() {
		return workTown;
	}
	public void setWorkTown(String workTown) {
		this.workTown = workTown;
	}
	
	@Column(nullable=false,updatable=false)
	public String getWorkAddress() {
		return workAddress;
	}
	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}
	
}
