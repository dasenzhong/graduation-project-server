package com.dgut.reallygoodapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.dgut.reallygoodapp.util.DateEntity;

@Entity
public class CommentCompany extends DateEntity{

	CompanyUser companyUser;
	
	String score;
	
	String comment;

	@ManyToOne(optional=false)
	public CompanyUser getCompanyUser() {
		return companyUser;
	}

	public void setCompanyUser(CompanyUser companyUser) {
		this.companyUser = companyUser;
	}

	@Column(nullable=false)
	public String getScore() {
		return score;
	}


	public void setScore(String score) {
		this.score = score;
	}

	@Column(nullable =false)
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
