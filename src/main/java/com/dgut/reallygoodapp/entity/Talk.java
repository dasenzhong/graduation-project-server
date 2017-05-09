package com.dgut.reallygoodapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.dgut.reallygoodapp.util.BaseEntity;

@Entity
public class Talk extends BaseEntity {

	String talk;			//随想

	@Column(nullable=false,updatable=false)
	public String getTalk() {
		return talk;
	}

	public void setTalk(String talk) {
		this.talk = talk;
	}
	
	
	
}
