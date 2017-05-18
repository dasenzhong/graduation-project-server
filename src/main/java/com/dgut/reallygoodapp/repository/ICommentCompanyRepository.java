package com.dgut.reallygoodapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dgut.reallygoodapp.entity.CommentCompany;
import com.dgut.reallygoodapp.entity.CompanyUser;

@Repository
public interface ICommentCompanyRepository extends PagingAndSortingRepository<CommentCompany, Integer> {
	
	@Query("from CommentCompany c where c.companyUser = ?1 order by c.createDate DESC")
	List<CommentCompany> findCommentByCompanyUser(CompanyUser companyUser);

}
