package com.dgut.reallygoodapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dgut.reallygoodapp.entity.Resume;
import com.dgut.reallygoodapp.entity.StudentUser;

@Repository
public interface IResumeRepository extends PagingAndSortingRepository<Resume, Integer> {
	
	@Query("from Resume r where r.studentUser = ?1")
	List<Resume> findResumeByStudentUser(StudentUser studentUser);

}
