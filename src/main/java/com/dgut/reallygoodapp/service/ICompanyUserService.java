package com.dgut.reallygoodapp.service;

import com.dgut.reallygoodapp.entity.CompanyUser;

public interface ICompanyUserService {

	CompanyUser save(CompanyUser companyUser);	//保存公司用户
	
	CompanyUser findByAccount(String account);	//通过账号查找公司用户
	
	CompanyUser findById(Integer id);			//通过id查找公司用户
}
