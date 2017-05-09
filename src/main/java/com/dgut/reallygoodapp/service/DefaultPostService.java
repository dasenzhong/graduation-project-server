package com.dgut.reallygoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgut.reallygoodapp.entity.Post;
import com.dgut.reallygoodapp.entity.Resume;
import com.dgut.reallygoodapp.repository.IPostRepository;

@Component
@Service
@Transactional
public class DefaultPostService implements IPostService {

	@Autowired
	IPostRepository postRepo;
	
	@Override
	public Post save(Post post) {
		return postRepo.save(post);
	}

	@Override
	public Post findById(Integer id) {
		return postRepo.findOne(id);
	}

	@Override
	public List<Post> findByResume(Resume resume) {
		return postRepo.findPostByResume(resume);
	}

}
