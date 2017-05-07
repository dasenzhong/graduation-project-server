package com.dgut.reallygoodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgut.reallygoodapp.entity.CompanyUser;
import com.dgut.reallygoodapp.repository.ICompanyUserRepository;

@Component
@Service
@Transactional
public class DefaultCompanyUserService implements ICompanyUserService {

	@Autowired
	ICompanyUserRepository companyUserRepo;
	
	@Override
	public CompanyUser save(CompanyUser companyUser) {
		return companyUserRepo.save(companyUser);
	}

	@Override
	public CompanyUser findByAccount(String account) {
		return companyUserRepo.findCompanyUserByAccount(account);
	}

	@Override
	public CompanyUser findById(Integer id) {
		return companyUserRepo.findOne(id);
	}

}
