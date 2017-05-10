package com.dgut.reallygoodapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.dgut.reallygoodapp.util.DateEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Talk extends DateEntity {

	Integer userId;
	String userAccount;
	
	String talk;			//随想

	@Column(nullable=false)
	@JsonIgnore
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(nullable=false)
	@JsonIgnore
	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	@Column(nullable=false,updatable=false)
	public String getTalk() {
		return talk;
	}

	public void setTalk(String talk) {
		this.talk = talk;
	}
	
	
	
}
