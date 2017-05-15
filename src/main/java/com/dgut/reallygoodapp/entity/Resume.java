package com.dgut.reallygoodapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.dgut.reallygoodapp.util.BaseEntity;

@Entity
public class Resume extends BaseEntity {

	String name;				//简历名字
	String birthday;			//出生年月
	String telephone;			//电话
	String liveProvince;		//省份
	String liveCity;			//城市
	String liveTown;			//城镇
	String school;				//学校
	boolean isPrefect;			//是否完善
	
	StudentUser studentUser;

	@Column(nullable=false)
	public boolean isPrefect() {
		return isPrefect;
	}

	public void setPrefect(boolean isPrefect) {
		this.isPrefect = isPrefect;
	}

	@Column(nullable=true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable=true)
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Column(nullable=true)
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(nullable=true)
	public String getLiveProvince() {
		return liveProvince;
	}

	public void setLiveProvince(String liveProvince) {
		this.liveProvince = liveProvince;
	}

	@Column(nullable=true)
	public String getLiveCity() {
		return liveCity;
	}

	public void setLiveCity(String liveCity) {
		this.liveCity = liveCity;
	}

	@Column(nullable=true)
	public String getLiveTown() {
		return liveTown;
	}

	public void setLiveTown(String liveTown) {
		this.liveTown = liveTown;
	}

	@Column(nullable=true)
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@OneToOne(optional=false,cascade=CascadeType.REFRESH)
	@JoinColumn(name="student_id",referencedColumnName="id",unique=true)
	public StudentUser getStudentUser() {
		return studentUser;
	}

	public void setStudentUser(StudentUser studentUser) {
		this.studentUser = studentUser;
	}
	
	
}
