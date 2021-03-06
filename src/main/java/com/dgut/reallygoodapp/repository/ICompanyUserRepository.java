package com.dgut.reallygoodapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dgut.reallygoodapp.entity.CompanyUser;

@Repository
public interface ICompanyUserRepository extends PagingAndSortingRepository<CompanyUser, Integer> {

	@Query("from CompanyUser c where c.account = ?1")
	CompanyUser findCompanyUserByAccount(String account);
}
