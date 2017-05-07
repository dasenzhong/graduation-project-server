package com.dgut.reallygoodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgut.reallygoodapp.entity.StudentUser;
import com.dgut.reallygoodapp.repository.IStudentUserRepository;

@Component
@Service
@Transactional
public class DefaultStudentUserService implements IStudentUserService {

	@Autowired
	IStudentUserRepository studentUserRepo;
	
	@Override
	public StudentUser save(StudentUser studentUser) {
		return studentUserRepo.save(studentUser);
	}

	@Override
	public StudentUser findByAccount(String account) {
		return studentUserRepo.findStudentUserByAccount(account);
	}

	@Override
	public StudentUser findById(Integer id) {
		return studentUserRepo.findOne(id);
	}

}
