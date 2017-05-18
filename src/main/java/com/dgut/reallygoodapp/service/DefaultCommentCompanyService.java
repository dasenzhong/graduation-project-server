package com.dgut.reallygoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dgut.reallygoodapp.entity.CommentCompany;
import com.dgut.reallygoodapp.entity.CompanyUser;
import com.dgut.reallygoodapp.repository.ICommentCompanyRepository;

public class DefaultCommentCompanyService implements ICommentCompanyService {

	@Autowired
	ICommentCompanyRepository CommentCompanyRepo;
	
	@Override
	public CommentCompany save(CommentCompany commentCompany) {
		return CommentCompanyRepo.save(commentCompany);
	}

	@Override
	public CommentCompany findById(Integer id) {
		return CommentCompanyRepo.findOne(id);
	}

	@Override
	public List<CommentCompany> findByCompanyUser(CompanyUser companyUser) {
		return CommentCompanyRepo.findCommentByCompanyUser(companyUser);
	}

}
