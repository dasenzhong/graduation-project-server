package com.dgut.reallygoodapp.util;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public class UserEntity extends BaseEntity {
	
	String account;			//账号
	String passwordHash;	//密码
	
	@Column(unique = true,nullable = false)
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	@Column(nullable = false)
	@JsonIgnore
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
}
