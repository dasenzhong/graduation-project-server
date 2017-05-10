package com.dgut.reallygoodapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dgut.reallygoodapp.entity.Experience;
import com.dgut.reallygoodapp.entity.Resume;

@Repository
public interface IExperienceRepository extends PagingAndSortingRepository<Experience, Integer> {

	@Query("from Experience e where e.resume = ?1 order by e.createDate DESC")
	List<Experience> findExperienceByResume(Resume resume);
	
}
