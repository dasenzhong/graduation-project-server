package com.dgut.reallygoodapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dgut.reallygoodapp.entity.Resume;
import com.dgut.reallygoodapp.entity.StudentUser;

@Repository
public interface IResumeRepository extends PagingAndSortingRepository<Resume, Integer> {
	
	@Query("from Resume r where r.studentUser = ?1")
	Resume findResumeByStudentUser(StudentUser studentUser);

}
