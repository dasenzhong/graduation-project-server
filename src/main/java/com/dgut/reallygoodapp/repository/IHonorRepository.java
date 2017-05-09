package com.dgut.reallygoodapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dgut.reallygoodapp.entity.Honor;
import com.dgut.reallygoodapp.entity.Resume;

@Repository
public interface IHonorRepository extends PagingAndSortingRepository<Honor, Integer> {

	@Query("from Honor h where h.resume = ?1")
	List<Honor> findHonorByResume(Resume resume);
}
