package com.dgut.reallygoodapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dgut.reallygoodapp.entity.Post;
import com.dgut.reallygoodapp.entity.Resume;

@Repository
public interface IPostRepository extends PagingAndSortingRepository<Post, Integer> {

	@Query("from Post p where p.resume = ?1 order by p.createDate DESC")
	List<Post> findPostByResume(Resume resume);
	
	
}
