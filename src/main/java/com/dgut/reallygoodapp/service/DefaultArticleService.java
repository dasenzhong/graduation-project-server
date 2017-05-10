package com.dgut.reallygoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgut.reallygoodapp.entity.Article;
import com.dgut.reallygoodapp.repository.IArticleRepository;

@Component
@Service
@Transactional
public class DefaultArticleService implements IArticleService {

	@Autowired
	IArticleRepository articleRepo;
	
	@Override
	public Article save(Article article) {
		return articleRepo.save(article);
	}

	@Override
	public Article findById(Integer id) {
		return articleRepo.findOne(id);
	}

	@Override
	public List<Article> findByUserId(Integer userId) {
		return articleRepo.findArticleByUserId(userId);
	}

	@Override
	public List<Article> findByUserAccount(String userAccount) {
		return articleRepo.findArticleByUserAccount(userAccount);
	}

	@Override
	public Page<Article> getByCreateDatePage(int page) {
		Sort sort = new Sort(Direction.DESC,"createDate");
		PageRequest pageRequest = new PageRequest(page, 20, sort);
		return articleRepo.findAll(pageRequest);
	}

}
