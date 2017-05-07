package com.dgut.reallygoodapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.dgut.reallygoodapp.entity.StudentUser;

public interface IStudentUserRepository extends PagingAndSortingRepository<StudentUser, Integer> {

	@Query("from StudentUser s where s.account = ?1")
	StudentUser findStudentUserByAccount(String account);
	
}
