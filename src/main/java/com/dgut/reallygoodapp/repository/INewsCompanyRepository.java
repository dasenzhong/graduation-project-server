package com.dgut.reallygoodapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dgut.reallygoodapp.entity.CompanyUser;
import com.dgut.reallygoodapp.entity.NewsCompany;

@Repository
public interface INewsCompanyRepository extends PagingAndSortingRepository<NewsCompany, Integer> {

	@Query("from NewsCompany n where n.companyUser = ?1")
	List<NewsCompany> findNewsByCompanyUser(CompanyUser companyUser);
	
}
