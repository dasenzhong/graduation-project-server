package com.dgut.reallygoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgut.reallygoodapp.entity.Experience;
import com.dgut.reallygoodapp.entity.Resume;
import com.dgut.reallygoodapp.repository.IExperienceRepository;

@Component
@Service
@Transactional
public class DefaultExperienceService implements IExperienceService {

	@Autowired
	IExperienceRepository experienceRepo;
	
	@Override
	public Experience save(Experience experience) {
		return experienceRepo.save(experience);
	}

	@Override
	public Experience findById(Integer id) {
		return experienceRepo.findOne(id);
	}

	@Override
	public List<Experience> findByResume(Resume resume) {
		return experienceRepo.findExperienceByResume(resume);
	}

}
