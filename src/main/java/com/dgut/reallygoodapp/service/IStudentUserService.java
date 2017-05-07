package com.dgut.reallygoodapp.service;

import com.dgut.reallygoodapp.entity.StudentUser;

public interface IStudentUserService {
	StudentUser save(StudentUser studentUser);	//保存学生用户
	
	StudentUser findByAccount(String account);	//通过账号查找学生用户
	
	StudentUser findById(Integer id);			//通过id查找学生用户
}
