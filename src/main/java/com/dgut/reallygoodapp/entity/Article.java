package com.dgut.reallygoodapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.dgut.reallygoodapp.util.DateEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Article extends DateEntity{

	Integer userId;			//用户的账号ID
	String userAccount;		//用户的账号
	
	String article;			//文章内容
	
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
	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}
	
}
