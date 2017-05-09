package com.dgut.reallygoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgut.reallygoodapp.entity.CompanyUser;
import com.dgut.reallygoodapp.entity.Job;
import com.dgut.reallygoodapp.repository.IJobRepository;

@Component
@Service
@Transactional
public class DefaultJobService implements IJobService {

	@Autowired
	IJobRepository jobRepo;
	
	@Override
	public Job save(Job job) {
		return jobRepo.save(job);
	}

	@Override
	public Job findById(Integer id) {
		return jobRepo.findOne(id);
	}

	@Override
	public List<Job> findByCompany(CompanyUser companyUser) {
		return jobRepo.findJobByCompany(companyUser);
	}

}
