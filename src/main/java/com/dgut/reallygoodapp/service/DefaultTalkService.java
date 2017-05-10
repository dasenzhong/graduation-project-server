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

import com.dgut.reallygoodapp.entity.Talk;
import com.dgut.reallygoodapp.repository.ITalkRepository;

@Component
@Service
@Transactional
public class DefaultTalkService implements ITalkService {
	
	@Autowired
	ITalkRepository talkRepo;

	@Override
	public Talk save(Talk talk) {
		return talkRepo.save(talk);
	}

	@Override
	public Talk findById(Integer id) {
		return talkRepo.findOne(id);
	}

	@Override
	public List<Talk> findByUserId(Integer userId) {
		return talkRepo.findTalkByUserId(userId);
	}

	@Override
	public List<Talk> findByUserAccount(String userAccount) {
		return talkRepo.findTalkByUserAccount(userAccount);
	}

	@Override
	public Page<Talk> getByCreateDatePage(int page) {
		Sort sort = new Sort(Direction.DESC,"createDate");
		PageRequest pageRequest = new PageRequest(page, 20, sort);
		return talkRepo.findAll(pageRequest);
	}

}
