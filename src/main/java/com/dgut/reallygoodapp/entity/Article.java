package com.dgut.reallygoodapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.dgut.reallygoodapp.util.DateEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Article extends DateEntity{

	Integer userId;			//用户的账号ID
	String userAccount;		//用户的账号
	
	boolean isStudent;
	boolean isCompany;
	
	String title;
	String article;			//文章内容
	
	
	@Column(nullable=false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(nullable=false)
	@JsonIgnore
	public boolean isStudent() {
		return isStudent;
	}

	public void setStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}

	@Column(nullable=false)
	@JsonIgnore
	public boolean isCompany() {
		return isCompany;
	}

	public void setCompany(boolean isCompany) {
		this.isCompany = isCompany;
	}

	@Column(nullable=false)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(nullable=false)
	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	@Column(nullable=false,updatable=false)
	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}
	
}
