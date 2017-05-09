package com.dgut.reallygoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgut.reallygoodapp.entity.Resume;
import com.dgut.reallygoodapp.entity.StudentUser;
import com.dgut.reallygoodapp.repository.IResumeRepository;

@Component
@Service
@Transactional
public class DefaultResumeService implements IResumeService {

	@Autowired
	IResumeRepository resumeRepo;
	
	@Override
	public Resume save(Resume resume) {
		return resumeRepo.save(resume);
	}

	@Override
	public Resume findById(Integer id) {
		return resumeRepo.findOne(id);
	}

	@Override
	public List<Resume> findByStudentUser(StudentUser studentUser) {
		return resumeRepo.findResumeByStudentUser(studentUser);
	}

}
