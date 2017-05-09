package com.dgut.reallygoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgut.reallygoodapp.entity.Honor;
import com.dgut.reallygoodapp.entity.Resume;
import com.dgut.reallygoodapp.repository.IHonorRepository;

@Component
@Service
@Transactional
public class DefaultHonorService implements IHonorService {

	@Autowired
	IHonorRepository honorRepo;
	
	@Override
	public Honor save(Honor honor) {
		return honorRepo.save(honor);
	}

	@Override
	public Honor findById(Integer id) {
		return honorRepo.findOne(id);
	}

	@Override
	public List<Honor> findByResume(Resume resume) {
		return honorRepo.findHonorByResume(resume);
	}

}
