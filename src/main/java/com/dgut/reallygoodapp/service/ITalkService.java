package com.dgut.reallygoodapp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dgut.reallygoodapp.entity.Talk;

public interface ITalkService {

	Talk save(Talk talk);
	
	Talk findById(Integer id);
	
	List<Talk> findByUserId(Integer userId);
	
	List<Talk> findByUserAccount(String userAccount);
	
	Page<Talk> getByCreateDatePage(int page);
}
