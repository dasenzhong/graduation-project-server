package com.dgut.reallygoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgut.reallygoodapp.entity.CompanyUser;
import com.dgut.reallygoodapp.entity.NewsCompany;
import com.dgut.reallygoodapp.repository.INewsCompanyRepository;

@Service
@Component
@Transactional
public class DefaultNewsCompanyService implements INewsCompanyService {

	@Autowired
	INewsCompanyRepository newsCompanyRepo;
	
	@Override
	public NewsCompany save(NewsCompany newsCompany) {
		return newsCompanyRepo.save(newsCompany);
	}

	@Override
	public NewsCompany findById(Integer id) {
		return newsCompanyRepo.findOne(id);
	}

	@Override
	public List<NewsCompany> findByCompanyUser(CompanyUser companyUser) {
		return newsCompanyRepo.findNewsByCompanyUser(companyUser);
	}

}
