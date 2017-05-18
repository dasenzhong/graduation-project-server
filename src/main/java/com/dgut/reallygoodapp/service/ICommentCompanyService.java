package com.dgut.reallygoodapp.service;

import java.util.List;

import com.dgut.reallygoodapp.entity.CommentCompany;
import com.dgut.reallygoodapp.entity.CompanyUser;

public interface ICommentCompanyService {
	
	CommentCompany save(CommentCompany commentCompany);
	
	CommentCompany findById(Integer id);
	
	List<CommentCompany> findByCompanyUser(CompanyUser companyUser);
}
