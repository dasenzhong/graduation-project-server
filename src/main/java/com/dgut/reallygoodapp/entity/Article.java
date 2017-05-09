package com.dgut.reallygoodapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.dgut.reallygoodapp.util.BaseEntity;

@Entity
public class Article extends BaseEntity {

	String article;			//文章内容

	@Column(nullable=false,updatable=false)
	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}
	
	
}
