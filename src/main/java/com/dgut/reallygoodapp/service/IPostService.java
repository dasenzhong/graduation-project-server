package com.dgut.reallygoodapp.service;

import java.util.List;

import com.dgut.reallygoodapp.entity.Post;
import com.dgut.reallygoodapp.entity.Resume;

public interface IPostService {

	Post save(Post post);
	
	Post findById(Integer id);
	
	List<Post> findByResume(Resume resume);
}
