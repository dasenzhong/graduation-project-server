package com.dgut.reallygoodapp.service;

import java.util.List;

import com.dgut.reallygoodapp.entity.Honor;
import com.dgut.reallygoodapp.entity.Resume;

public interface IHonorService {

	Honor save(Honor honor);
	
	Honor findById(Integer id);
	
	List<Honor> findByResume(Resume resume);
}
