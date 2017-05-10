package com.dgut.reallygoodapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dgut.reallygoodapp.entity.Article;

@Repository
public interface IArticleRepository extends PagingAndSortingRepository<Article, Integer> {

	@Query("from Article a where a.userId = ?1 order by a.createDate DESC")
	List<Article> findArticleByUserId(Integer userId);
	
	@Query("from Article a where a.userAccount = ?1 order by a.createDate DESC")
	List<Article> findArticleByUserAccount(String userAccount);
	
}
