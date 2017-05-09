package com.dgut.reallygoodapp.service;

import java.util.List;

import com.dgut.reallygoodapp.entity.Experience;
import com.dgut.reallygoodapp.entity.Resume;

public interface IExperienceService {

	Experience save(Experience experience);
	
	Experience findById(Integer id);
	
	List<Experience> findByResume(Resume resume);
}
