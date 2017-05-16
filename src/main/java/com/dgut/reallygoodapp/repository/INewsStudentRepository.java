package com.dgut.reallygoodapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dgut.reallygoodapp.entity.NewsStudent;
import com.dgut.reallygoodapp.entity.StudentUser;

@Repository
public interface INewsStudentRepository extends PagingAndSortingRepository<NewsStudent, Integer> {

	@Query("from NewsStudent n where n.studentUser = ?1")
	List<NewsStudent> findByStudentUser(StudentUser studentUser);
	
}
