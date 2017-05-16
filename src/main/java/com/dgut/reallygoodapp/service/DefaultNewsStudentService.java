package com.dgut.reallygoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgut.reallygoodapp.entity.NewsStudent;
import com.dgut.reallygoodapp.entity.StudentUser;
import com.dgut.reallygoodapp.repository.INewsStudentRepository;

@Service
@Component
@Transactional
public class DefaultNewsStudentService implements INewsStudentService {

	@Autowired
	INewsStudentRepository newsStudentRepo;
	
	@Override
	public NewsStudent save(NewsStudent newsStudent) {
		return newsStudentRepo.save(newsStudent);
	}

	@Override
	public NewsStudent findById(Integer id) {
		return newsStudentRepo.findOne(id);
	}

	@Override
	public List<NewsStudent> findByStudentUser(StudentUser studentUser) {
		return newsStudentRepo.findByStudentUser(studentUser);
	}

}
