package com.dgut.reallygoodapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloudage.membercenter.entity.User;
import com.dgut.reallygoodapp.entity.CompanyUser;
import com.dgut.reallygoodapp.entity.StudentUser;
import com.dgut.reallygoodapp.service.ICompanyUserService;
import com.dgut.reallygoodapp.service.IStudentUserService;
import com.dgut.reallygoodapp.util.UserEntity;

@RestController
@RequestMapping("/api")
public class APIController {

	@Autowired
	IStudentUserService StudentUserService;

	@Autowired
	ICompanyUserService CompanyUserService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public @ResponseBody String hello() {

		return "HELLO WORLD";
	}

	// 学生注册
	@RequestMapping(value = "/registerstudent", method = RequestMethod.POST)
	@ResponseBody
	public StudentUser registerStudent(@RequestParam String account, @RequestParam String password,
			@RequestParam String sex, HttpServletRequest request) {

		StudentUser studentUser = new StudentUser();
		studentUser.setAccount(account);
		studentUser.setPasswordHash(password);
		studentUser.setSex(sex);

		return StudentUserService.save(studentUser);

	}

	// 公司注册
	@RequestMapping(value = "/registercompany", method = RequestMethod.POST)
	@ResponseBody
	public CompanyUser registerCompany(@RequestParam String account, @RequestParam String password,
			@RequestParam String province, @RequestParam String city, @RequestParam String town,
			@RequestParam String companyName, HttpServletRequest request) {

		CompanyUser companyUser = new CompanyUser();
		companyUser.setAccount(account);
		companyUser.setPasswordHash(password);
		companyUser.setProvince(province);
		companyUser.setCity(city);
		companyUser.setTown(town);
		companyUser.setCompanyName(companyName);

		return CompanyUserService.save(companyUser);

	}

	@RequestMapping(value = "/loginstudent", method = RequestMethod.POST)
	@ResponseBody
	public StudentUser loginStudent(@RequestParam String account, @RequestParam String password,
			HttpServletRequest request) {

		StudentUser studentUser = StudentUserService.findByAccount(account);
		if (studentUser != null && studentUser.getPasswordHash().equals(password)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("uid", studentUser.getId());
			return studentUser;
		} else {
			return null;
		}

	}

	@RequestMapping(value = "/logincompany", method = RequestMethod.POST)
	@ResponseBody
	public StudentUser loginCompany(@RequestParam String account, @RequestParam String password,
			HttpServletRequest request) {

		StudentUser companyUser = StudentUserService.findByAccount(account);
		if (companyUser != null && companyUser.getPasswordHash().equals(password)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("uid", companyUser.getId());
			return companyUser;
		} else {
			return null;
		}

	}

	// 检查是否登录
	@RequestMapping(value = "/checkloginstudent", method = RequestMethod.GET)
	@ResponseBody
	public StudentUser checkLoginStudent(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		Integer id = (Integer) session.getAttribute("uid");
		return StudentUserService.findById(id);
	}

	// 检查是否登录
	@RequestMapping(value = "/checklogincompany", method = RequestMethod.GET)
	@ResponseBody
	public CompanyUser checkLoginCompany(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		Integer id = (Integer) session.getAttribute("uid");
		return CompanyUserService.findById(id);
	}

	// 退出
	@RequestMapping(value = "/exitstudent")
	public void exitStudent(HttpServletRequest request) {
		StudentUser studentUser = checkLoginStudent(request);
		if (studentUser != null) {
			request.getSession(true).removeAttribute("uid");
		}
	}

	// 退出
	@RequestMapping(value = "/exitcompany")
	public void exitCompany(HttpServletRequest request) {
		CompanyUser companyUser = checkLoginCompany(request);
		if (companyUser != null) {
			request.getSession(true).removeAttribute("uid");
		}
	}
}