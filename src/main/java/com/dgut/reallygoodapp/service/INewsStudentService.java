package com.dgut.reallygoodapp.service;

import java.util.List;

import com.dgut.reallygoodapp.entity.NewsStudent;
import com.dgut.reallygoodapp.entity.StudentUser;

public interface INewsStudentService {

	NewsStudent save(NewsStudent newsStudent);
	
	NewsStudent findById(Integer id);
	
	List<NewsStudent> findByStudentUser(StudentUser studentUser);
}
