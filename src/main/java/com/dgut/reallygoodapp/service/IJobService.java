package com.dgut.reallygoodapp.service;

import java.util.List;

import com.dgut.reallygoodapp.entity.CompanyUser;
import com.dgut.reallygoodapp.entity.Job;

public interface IJobService {

	Job save(Job job);
	
	Job findById(Integer id);
	
	List<Job> findByCompany(CompanyUser companyUser);
}
