package com.dgut.reallygoodapp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dgut.reallygoodapp.entity.Article;

public interface IArticleService {

	Article save(Article article);
	
	Article findById(Integer id);
	
	List<Article> findByUserId(Integer userId);
	
	List<Article> findByUserAccount(String userAccount);

	Page<Article> getByCreateDatePage(int page);
}
