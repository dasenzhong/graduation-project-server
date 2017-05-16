package com.dgut.reallygoodapp.service;

import java.util.List;

import com.dgut.reallygoodapp.entity.CompanyUser;
import com.dgut.reallygoodapp.entity.NewsCompany;

public interface INewsCompanyService {

	NewsCompany save(NewsCompany newsCompany);
	
	NewsCompany findById(Integer id);
	
	List<NewsCompany> findByCompanyUser(CompanyUser companyUser);
}
