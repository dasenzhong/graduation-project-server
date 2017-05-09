package com.dgut.reallygoodapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dgut.reallygoodapp.entity.CompanyUser;
import com.dgut.reallygoodapp.entity.Job;

@Repository
public interface IJobRepository extends PagingAndSortingRepository<Job, Integer> {

	@Query("from Job j where j.companyUser = ?1")
	List<Job> findJobByCompany(CompanyUser companyUser);
	
}
