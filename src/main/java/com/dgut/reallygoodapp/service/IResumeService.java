package com.dgut.reallygoodapp.service;

import java.util.List;

import com.dgut.reallygoodapp.entity.Resume;
import com.dgut.reallygoodapp.entity.StudentUser;

public interface IResumeService {

	Resume save(Resume resume);
	
	Resume findById(Integer id);
	
	Resume findByStudentUser(StudentUser studentUser);
}
