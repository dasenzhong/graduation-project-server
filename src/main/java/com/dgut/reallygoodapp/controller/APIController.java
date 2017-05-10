package com.dgut.reallygoodapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dgut.reallygoodapp.entity.Article;
import com.dgut.reallygoodapp.entity.CompanyUser;
import com.dgut.reallygoodapp.entity.Experience;
import com.dgut.reallygoodapp.entity.Honor;
import com.dgut.reallygoodapp.entity.Job;
import com.dgut.reallygoodapp.entity.Post;
import com.dgut.reallygoodapp.entity.Resume;
import com.dgut.reallygoodapp.entity.StudentUser;
import com.dgut.reallygoodapp.entity.Talk;
import com.dgut.reallygoodapp.service.IArticleService;
import com.dgut.reallygoodapp.service.ICompanyUserService;
import com.dgut.reallygoodapp.service.IExperienceService;
import com.dgut.reallygoodapp.service.IHonorService;
import com.dgut.reallygoodapp.service.IJobService;
import com.dgut.reallygoodapp.service.IPostService;
import com.dgut.reallygoodapp.service.IResumeService;
import com.dgut.reallygoodapp.service.IStudentUserService;
import com.dgut.reallygoodapp.service.ITalkService;

@RestController
@RequestMapping("/api")
public class APIController {

	@Autowired
	IStudentUserService StudentUserService;

	@Autowired
	ICompanyUserService CompanyUserService;
	
	@Autowired
	IJobService JobService;
	
	@Autowired
	IExperienceService ExperienceService;
	
	@Autowired
	IHonorService HonorService;
	
	@Autowired
	IPostService PostService;
	
	@Autowired
	ITalkService TalkService;
	
	@Autowired
	IArticleService ArticleService;
	
	@Autowired
	IResumeService ResumeService;

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
		
		Resume resume = new Resume();
		resume.setStudentUser(studentUser);
		
		studentUser.setResume(ResumeService.save(resume));

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
	
	///发布兼职
	@RequestMapping(value="/addjob",method=RequestMethod.POST)
	@ResponseBody
	public Job addJob(
			@RequestParam String jobName,
			@RequestParam String jobType,
			@RequestParam String number,
			@RequestParam String education,
			@RequestParam String money,
			@RequestParam String describe,
			@RequestParam String employProvince,
			@RequestParam String employCity,
			@RequestParam String employTown,
			@RequestParam String workProvince,
			@RequestParam String workCity,
			@RequestParam String workTown,
			@RequestParam String workAddress,
			HttpServletRequest request){
		
		CompanyUser companyUser = checkLoginCompany(request);
		
		Job job = new Job();
		
		job.setJobName(jobName);
		job.setJobType(jobType);
		job.setNumber(number);
		job.setEducation(education);
		job.setMoney(money);
		job.setDecribe(describe);
		job.setEmployProvince(employProvince);
		job.setEmployCity(employCity);
		job.setEmployTown(employTown);
		job.setWorkProvince(workProvince);
		job.setWorkCity(workCity);
		job.setWorkTown(workTown);
		job.setWorkAddress(workAddress);
		
		job.setCompanyUser(companyUser);
		
		return JobService.save(job);
		
	}
	
	@RequestMapping(value="/addexperience",method=RequestMethod.POST)
	@ResponseBody
	public Experience addExperience(
			@RequestParam String startTime,
			@RequestParam String endTime,
			@RequestParam String companyName,
			@RequestParam String companyPost,
			@RequestParam String describe,
			@RequestParam String type,
			HttpServletRequest request){
		
		Resume resume = ResumeService.findByStudentUser(checkLoginStudent(request));
		
		Experience experience = new Experience();
		
		experience.setStartTime(startTime);
		experience.setEndTime(endTime);
		experience.setCompanyName(companyName);
		experience.setCompanyPost(companyPost);
		experience.setDescribe(describe);
		experience.setType(type);
		
		experience.setResume(resume);
		
		return ExperienceService.save(experience);
		
	}
	
	//添加荣誉
	@RequestMapping(value="/addhonor",method=RequestMethod.POST)
	@ResponseBody
	public Honor addHonor(
			@RequestParam String time,
			@RequestParam String honorName,
			@RequestParam String level,
			HttpServletRequest request){
		
		Resume resume = ResumeService.findByStudentUser(checkLoginStudent(request));
		
		Honor honor = new Honor();

		honor.setTime(time);
		honor.setHonorName(honorName);
		honor.setLevel(level);
		
		honor.setResume(resume);
		
		return HonorService.save(honor);
		
	}
	
	//添加职务
	@RequestMapping(value="/addpost",method=RequestMethod.POST)
	@ResponseBody
	public Post addPost(
			@RequestParam String startTime,
			@RequestParam String endTime,
			@RequestParam String postName,
			@RequestParam String describe,
			HttpServletRequest request){
		
		Resume resume = ResumeService.findByStudentUser(checkLoginStudent(request));
		
		Post post = new Post();
		
		post.setStartTime(startTime);
		post.setEndTime(endTime);
		post.setPostName(postName);
		post.setDescribe(describe);
		
		post.setResume(resume);
		
		return PostService.save(post);
		
	}
	
	//添加文章
	@RequestMapping(value = "/addarticle",method=RequestMethod.POST)
	@ResponseBody
	public Article addArticle(
			@RequestParam String articleString,
			HttpServletRequest request){
		
		CompanyUser companyUser = checkLoginCompany(request);
		StudentUser studentUser = checkLoginStudent(request);
		
		Article article = new Article();
		article.setArticle(articleString);
		
		if (companyUser!=null) {
			article.setUserId(companyUser.getId());
			article.setUserAccount(companyUser.getAccount());
		}
		if (studentUser != null) {
			article.setUserId(studentUser.getId());
			article.setUserAccount(studentUser.getAccount());
		}
		
		return ArticleService.save(article);
	}
	
	//添加随想
	@RequestMapping(value = "/addtalk",method=RequestMethod.POST)
	@ResponseBody
	public Talk addTalk(
			@RequestParam String talkString,
			HttpServletRequest request){
		
		CompanyUser companyUser = checkLoginCompany(request);
		StudentUser studentUser = checkLoginStudent(request);
		
		Talk talk = new Talk();
		talk.setTalk(talkString);
		
		if (companyUser!=null) {
			talk.setUserId(companyUser.getId());
			talk.setUserAccount(companyUser.getAccount());
		}
		if (studentUser != null) {
			talk.setUserId(studentUser.getId());
			talk.setUserAccount(studentUser.getAccount());
		}
		
		return TalkService.save(talk);
	}
	
	//获取最新的兼职信息
	@RequestMapping(value="/getnewjob/{page}",method=RequestMethod.GET)
	@ResponseBody
	public Page<Job> getNewJob(@PathVariable int page){
		return JobService.getByCreateDatePage(page);
	}
	
	
}
