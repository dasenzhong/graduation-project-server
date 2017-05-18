package com.dgut.reallygoodapp.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dgut.reallygoodapp.entity.Article;
import com.dgut.reallygoodapp.entity.CommentCompany;
import com.dgut.reallygoodapp.entity.CompanyUser;
import com.dgut.reallygoodapp.entity.Experience;
import com.dgut.reallygoodapp.entity.Honor;
import com.dgut.reallygoodapp.entity.Job;
import com.dgut.reallygoodapp.entity.NewsCompany;
import com.dgut.reallygoodapp.entity.NewsStudent;
import com.dgut.reallygoodapp.entity.Post;
import com.dgut.reallygoodapp.entity.Resume;
import com.dgut.reallygoodapp.entity.StudentUser;
import com.dgut.reallygoodapp.entity.Talk;
import com.dgut.reallygoodapp.service.IArticleService;
import com.dgut.reallygoodapp.service.ICommentCompanyService;
import com.dgut.reallygoodapp.service.ICompanyUserService;
import com.dgut.reallygoodapp.service.IExperienceService;
import com.dgut.reallygoodapp.service.IHonorService;
import com.dgut.reallygoodapp.service.IJobService;
import com.dgut.reallygoodapp.service.INewsCompanyService;
import com.dgut.reallygoodapp.service.INewsStudentService;
import com.dgut.reallygoodapp.service.IPostService;
import com.dgut.reallygoodapp.service.IResumeService;
import com.dgut.reallygoodapp.service.IStudentUserService;
import com.dgut.reallygoodapp.service.ITalkService;
import com.fasterxml.jackson.annotation.JsonFormat.Value;

@RestController
@RequestMapping("/api")
public class APIController {

	private final Integer NEWS_DEAL_JOB = 1; 
	private final Integer NEWS_DEAL_AGENT = 2;
	private final Integer NEWS_DEAL_EVALUATION = 3;
	
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
	
	@Autowired
	INewsCompanyService NewsCompanyService;
	
	@Autowired
	INewsStudentService NewsStudentService;
	
	@Autowired
	ICommentCompanyService CommentCompanyService;

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
		resume.setPrefect(false);
		
		studentUser.setResume(ResumeService.save(resume));

		return StudentUserService.save(studentUser);

	}

	// 公司注册
	@RequestMapping(value = "/registercompany", method = RequestMethod.POST)
	@ResponseBody
	public CompanyUser registerCompany(
			@RequestParam String account,
			@RequestParam String password,
			@RequestParam String province,
			@RequestParam String city,
			@RequestParam String town,
			@RequestParam String companyName,
			@RequestParam String comapnyType,
			@RequestParam String companyNumber,
			@RequestParam String companyIndustry,
			HttpServletRequest request) {

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
		
		List<StudentUser> agentList =new ArrayList<>();
		job.setAgentList(agentList);
		
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
	@RequestMapping(value = "/addarticlestudent",method=RequestMethod.POST)
	@ResponseBody
	public Article addArticleStudent(
			@RequestParam String title,
			@RequestParam String articleString,
			HttpServletRequest request){
		
		StudentUser studentUser = checkLoginStudent(request);
		
		Article article = new Article();
		article.setArticle(articleString);
		article.setTitle(title);

		article.setUserId(studentUser.getId());
		article.setUserAccount(studentUser.getAccount());
		
		article.setStudent(true);
		article.setCompany(false);
		
		return ArticleService.save(article);
	}
	
	@RequestMapping(value = "/addarticlecompany",method=RequestMethod.POST)
	@ResponseBody
	public Article addArticleCompany(
			@RequestParam String title,
			@RequestParam String articleString,
			HttpServletRequest request){
		
		CompanyUser companyUser = checkLoginCompany(request);
		
		Article article = new Article();
		article.setArticle(articleString);
		article.setTitle(title);

		article.setUserId(companyUser.getId());
		article.setUserAccount(companyUser.getAccount());
		
		article.setStudent(false);
		article.setCompany(true);
		
		return ArticleService.save(article);
	}
	
	//添加随想
	@RequestMapping(value = "/addtalkstudent",method=RequestMethod.POST)
	@ResponseBody
	public Talk addTalkStudent(
			@RequestParam String talkString,
			HttpServletRequest request){
		
		StudentUser studentUser = checkLoginStudent(request);
		
		Talk talk = new Talk();
		talk.setTalk(talkString);

		talk.setUserId(studentUser.getId());
		talk.setUserAccount(studentUser.getAccount());
		
		talk.setStudent(true);
		talk.setCompany(false);
		
		
		return TalkService.save(talk);
	}
	
	@RequestMapping(value = "/addtalkcompany",method=RequestMethod.POST)
	@ResponseBody
	public Talk addTalkCompany(
			@RequestParam String talkString,
			HttpServletRequest request){
		
		CompanyUser companyUser = checkLoginCompany(request);
		
		Talk talk = new Talk();
		talk.setTalk(talkString);

		talk.setUserId(companyUser.getId());
		talk.setUserAccount(companyUser.getAccount());
		
		talk.setStudent(false);
		talk.setCompany(true);
		
		
		return TalkService.save(talk);
	}
	
	//保存简历基本信息
	@RequestMapping(value="/saveresume",method = RequestMethod.POST)
	@ResponseBody
	public Resume saveResume(
			@RequestParam String name,
			@RequestParam String birthday,
			@RequestParam String telephone,
			@RequestParam String liveProvince,
			@RequestParam String liveCity,
			@RequestParam String liveTown,
			@RequestParam String school,
			HttpServletRequest request){
		
		Resume resume = ResumeService.findByStudentUser(checkLoginStudent(request));

		if (resume == null) {
			return null;
		} else {
			resume.setName(name);
			resume.setBirthday(birthday);
			resume.setTelephone(telephone);
			resume.setLiveProvince(liveProvince);
			resume.setLiveCity(liveCity);
			resume.setLiveTown(liveTown);
			resume.setSchool(school);
			
			if (name!=null && birthday !=null && telephone!=null 
					&& liveProvince!=null && school!=null & !name.isEmpty()
					&& !birthday.isEmpty() && !telephone.isEmpty() && !liveProvince.isEmpty()
					&& !school.isEmpty()) {
				
				resume.setPrefect(true);
			}else {
				resume.setPrefect(false);
			}
			
			return ResumeService.save(resume);
		}
		
		
	}
	
	//获取最新的兼职信息
	@RequestMapping(value="/getnewjob/{page}",method=RequestMethod.GET)
	@ResponseBody
	public Page<Job> getNewJob(@PathVariable int page){
		return JobService.getByCreateDatePage(page);
	}
	
	//获取工作经验
	@RequestMapping(value="/getexperience",method=RequestMethod.GET)
	@ResponseBody
	public List<Experience> getExperience(HttpServletRequest request){
		
		Resume resume = ResumeService.findByStudentUser(checkLoginStudent(request));
		
		return ExperienceService.findByResume(resume);
	}
	
	//获取校内荣誉
	@RequestMapping(value = "/gethonor", method = RequestMethod.GET)
	@ResponseBody
	public List<Honor> getHonor(HttpServletRequest request) {

		Resume resume = ResumeService.findByStudentUser(checkLoginStudent(request));

		return HonorService.findByResume(resume);
	}
		
	//获取校内职务
	@RequestMapping(value = "/getpost", method = RequestMethod.GET)
	@ResponseBody
	public List<Post> getPost(HttpServletRequest request) {

		Resume resume = ResumeService.findByStudentUser(checkLoginStudent(request));

		return PostService.findByResume(resume);
	}
	
	//获取个人基本信息
	@RequestMapping(value="/getinfo",method=RequestMethod.POST)
	@ResponseBody
	public Resume getInfo(HttpServletRequest request){
		
		return ResumeService.findByStudentUser(checkLoginStudent(request));
		
	}
	
	//获取工作信息
	@RequestMapping(value = "/getjob/{jobid}",method=RequestMethod.GET)
	@ResponseBody
	public Job getJob(
			@PathVariable Integer jobid,
			HttpServletRequest request){
		
		return JobService.findById(jobid);
		
	}
	
	//申请工作
	@RequestMapping(value = "/applyjob",method=RequestMethod.POST)
	@ResponseBody
	public NewsCompany applyJob(
			@RequestParam String companyUserId,
			@RequestParam String jobId,
			HttpServletRequest request){
		
		CompanyUser companyUser = CompanyUserService.findById(Integer.valueOf(companyUserId));
		
		Job job = JobService.findById(Integer.valueOf(jobId));
		
		Resume resume = ResumeService.findByStudentUser(checkLoginStudent(request));
		
		String newsText = "有人对你发布的——" + job.getJobName() +"——进行了投递简历";
		
		NewsCompany newsCompany = new NewsCompany();
		
		newsCompany.setCompanyUser(companyUser);
		newsCompany.setJob(job);
		newsCompany.setResume(resume);
		newsCompany.setNewsText(newsText);
		newsCompany.setRead(false);
		newsCompany.setDeal(NEWS_DEAL_JOB);
		newsCompany.setIsdeal(false);
		
		return NewsCompanyService.save(newsCompany);
		
	}
	
	//申请代理人
	@RequestMapping(value="/applyagent",method=RequestMethod.POST)
	@ResponseBody
	public NewsCompany applyAgent(
			@RequestParam String companyUserId,
			@RequestParam String jobId,
			HttpServletRequest request){
		
		CompanyUser companyUser = CompanyUserService.findById(Integer.valueOf(companyUserId));
		
		Job job = JobService.findById(Integer.valueOf(jobId));
		
		Resume resume = ResumeService.findByStudentUser(checkLoginStudent(request));
		
		String newsText = "有人对你发布的——" + job.getJobName() +"——申请代理人担保";
		
		NewsCompany newsCompany = new NewsCompany();
		
		newsCompany.setCompanyUser(companyUser);
		newsCompany.setJob(job);
		newsCompany.setResume(resume);
		newsCompany.setNewsText(newsText);
		newsCompany.setRead(false);
		newsCompany.setDeal(NEWS_DEAL_AGENT);
		newsCompany.setIsdeal(false);
		
		return NewsCompanyService.save(newsCompany);
	}
	
	//获得公司消息
	@RequestMapping(value = "/getcompanynews",method = RequestMethod.GET)
	@ResponseBody
	public List<NewsCompany> getCompanyNews(HttpServletRequest request){
		
		CompanyUser companyUser = checkLoginCompany(request);
		
		return NewsCompanyService.findByCompanyUser(companyUser);
	}
	
	//获得学生消息
	@RequestMapping(value = "/getstudentnews", method = RequestMethod.GET)
	@ResponseBody
	public List<NewsStudent> getStudentNews(HttpServletRequest request) {

		StudentUser studentUser = checkLoginStudent(request);

		return NewsStudentService.findByStudentUser(studentUser);
	}
	
	//通过ID获得companyNews
	@RequestMapping(value = "/getcompanynewsbyid/{newsId}",method=RequestMethod.GET)
	@ResponseBody
	public NewsCompany getCompanyNewsById(
			@PathVariable int newsId,
			HttpServletRequest request){
		
		return NewsCompanyService.findById(newsId);
		
	}
	
	//通过ID获得companyNews
	@RequestMapping(value = "/getstudentnewsbyid/{newsId}", method = RequestMethod.GET)
	@ResponseBody
	public NewsStudent getStudentNewsById(
			@PathVariable int newsId,
			HttpServletRequest request) {

		return NewsStudentService.findById(newsId);

	}
	
	
	//通过ID获得工作经验
	@RequestMapping(value="/getexperiencebyresumeid/{resumeid}",method=RequestMethod.GET)
	@ResponseBody
	public List<Experience> getExperienceByResumeId(
			@PathVariable int resumeid,
			HttpServletRequest request){
		
		return ExperienceService.findByResume(ResumeService.findById(resumeid));
	}
	
	//通过ID获得工作经验
		@RequestMapping(value="/gethonorbyresumeid/{resumeid}",method=RequestMethod.GET)
		@ResponseBody
		public List<Honor> getHonorByResumeId(
				@PathVariable int resumeid,
				HttpServletRequest request){
			
			return HonorService.findByResume(ResumeService.findById(resumeid));
		}
		
	//通过ID获得工作经验
	@RequestMapping(value = "/getpostbyresumeid/{resumeid}", method = RequestMethod.GET)
	@ResponseBody
	public List<Post> getPostByResumeId(
			@PathVariable int resumeid,
			HttpServletRequest request) {

		return PostService.findByResume(ResumeService.findById(resumeid));
	}
	
	//投递简历处理
	@RequestMapping(value="/jobapplyunpass",method=RequestMethod.POST)
	@ResponseBody
	public NewsStudent jobApplyUnPass(
			@RequestParam String studentUserId,
			@RequestParam String jobId,
			@RequestParam String newscompanyId,
			HttpServletRequest request){
		
		StudentUser studentUser = StudentUserService.findById(Integer.valueOf(studentUserId));
		
		Job job = JobService.findById(Integer.valueOf(jobId));
		
		NewsStudent newsStudent = new NewsStudent();
		
		newsStudent.setStudentUser(studentUser);
		newsStudent.setJob(job);
		newsStudent.setRead(false);
		newsStudent.setDeal(NEWS_DEAL_JOB);
		newsStudent.setPass(false);
		newsStudent.setNewsText("你对——" + job.getJobName() + "——投递的简历已被浏览");
		newsStudent.setMeetTime(null);
		newsStudent.setMeetAddress(null);
		newsStudent.setTelephone(null);
		
		NewsCompany newsCompany = NewsCompanyService.findById(Integer.valueOf(newscompanyId));
		newsCompany.setIsdeal(true);
		
		NewsCompanyService.save(newsCompany);
		
		return NewsStudentService.save(newsStudent);
	}
	
	//投递简历处理
	@RequestMapping(value = "/jobapplypass", method = RequestMethod.POST)
	@ResponseBody
	public NewsStudent jobApplyPass(
			@RequestParam String studentUserId,
			@RequestParam String jobId,
			@RequestParam String newscompanyId,
			@RequestParam String meettime,
			@RequestParam String meetaddress,
			@RequestParam String telephone,
			HttpServletRequest request) {

		StudentUser studentUser = StudentUserService.findById(Integer.valueOf(studentUserId));

		Job job = JobService.findById(Integer.valueOf(jobId));

		NewsStudent newsStudent = new NewsStudent();

		newsStudent.setStudentUser(studentUser);
		newsStudent.setJob(job);
		newsStudent.setRead(false);
		newsStudent.setDeal(NEWS_DEAL_JOB);
		newsStudent.setPass(false);
		newsStudent.setNewsText("你对——" + job.getJobName() + "——投递的简历已被录用");
		newsStudent.setMeetTime(meettime);
		newsStudent.setMeetAddress(meetaddress);
		newsStudent.setTelephone(telephone);

		NewsCompany newsCompany = NewsCompanyService.findById(Integer.valueOf(newscompanyId));
		newsCompany.setIsdeal(true);

		NewsCompanyService.save(newsCompany);

		return NewsStudentService.save(newsStudent);
	}
		
	//申请代理处理
	@RequestMapping(value = "/agentapplyunpass", method = RequestMethod.POST)
	@ResponseBody
	public NewsStudent agentApplyUnPass(
			@RequestParam String studentUserId,
			@RequestParam String jobId,
			@RequestParam String newscompanyId,
			HttpServletRequest request) {

		StudentUser studentUser = StudentUserService.findById(Integer.valueOf(studentUserId));

		Job job = JobService.findById(Integer.valueOf(jobId));

		NewsStudent newsStudent = new NewsStudent();

		newsStudent.setStudentUser(studentUser);
		newsStudent.setJob(job);
		newsStudent.setRead(false);
		newsStudent.setDeal(NEWS_DEAL_AGENT);
		newsStudent.setPass(false);
		newsStudent.setNewsText("你对——" + job.getJobName() + "——申请的代理已被浏览");
		newsStudent.setMeetTime(null);
		newsStudent.setMeetAddress(null);
		newsStudent.setTelephone(null);

		NewsCompany newsCompany = NewsCompanyService.findById(Integer.valueOf(newscompanyId));
		newsCompany.setIsdeal(true);

		NewsCompanyService.save(newsCompany);

		return NewsStudentService.save(newsStudent);
	}
	
	//申请代理处理
	@RequestMapping(value = "/agentapplypass", method = RequestMethod.POST)
	@ResponseBody
	public NewsStudent agentApplyPass(
			@RequestParam String studentUserId,
			@RequestParam String jobId,
			@RequestParam String newscompanyId,
			HttpServletRequest request) {

		StudentUser studentUser = StudentUserService.findById(Integer.valueOf(studentUserId));

		Job job = JobService.findById(Integer.valueOf(jobId));
		
		List<StudentUser> agentList = job.getAgentList();
		if (agentList == null) {
			agentList = new ArrayList<>();
		}
		agentList.add(studentUser);
		job.setAgentList(agentList);
		JobService.save(job);

		NewsStudent newsStudent = new NewsStudent();

		newsStudent.setStudentUser(studentUser);
		newsStudent.setJob(job);
		newsStudent.setRead(false);
		newsStudent.setDeal(NEWS_DEAL_AGENT);
		newsStudent.setPass(true);
		newsStudent.setNewsText("你对——" + job.getJobName() + "——申请的代理已被允许");
		newsStudent.setMeetTime(null);
		newsStudent.setMeetAddress(null);
		newsStudent.setTelephone(null);

		NewsCompany newsCompany = NewsCompanyService.findById(Integer.valueOf(newscompanyId));
		newsCompany.setIsdeal(true);

		NewsCompanyService.save(newsCompany);

		return NewsStudentService.save(newsStudent);
	}
		
	//添加评价
	@RequestMapping(value = "/addcommentcompany",method=RequestMethod.POST)
	@ResponseBody
	public CommentCompany addCommnetCompany(
			@RequestParam String companyuserId,
			@RequestParam String score,
			@RequestParam String comment,
			HttpServletRequest request){
		
		CompanyUser companyUser = CompanyUserService.findById(Integer.valueOf(companyuserId));
		
		CommentCompany commentCompany = new CommentCompany();
		
		commentCompany.setCompanyUser(companyUser);
		commentCompany.setScore(score);
		commentCompany.setComment(comment);
		
		return CommentCompanyService.save(commentCompany);
		
	}
	
	//保存头像
	@RequestMapping(value ="/saveavatarcompany",method = RequestMethod.POST)
	@ResponseBody
	public String saveAvatarCompany(
			MultipartFile avatar,
			HttpServletRequest request){
		
		CompanyUser companyUser = checkLoginCompany(request);
		

		if (avatar != null && companyUser != null) {
			try {

				String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
				FileUtils.copyInputStreamToFile(avatar.getInputStream(), new File(realPath, "comapny" + companyUser.getAccount() + ".png"));
				companyUser.setAvatar("upload/"+ "comapny" + companyUser.getAccount() + ".png");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "保存成功";
		}
		
		return "保存失败";
	}
	
	//保存头像
	@RequestMapping(value = "/saveavatarstudent", method = RequestMethod.POST)
	@ResponseBody
	public String saveAvatarStudent(
			MultipartFile avatar,
			HttpServletRequest request) {

		StudentUser studentUser = checkLoginStudent(request);

		if (avatar != null && studentUser != null) {
			try {

				String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
				FileUtils.copyInputStreamToFile(avatar.getInputStream(),new File(realPath, "student" + studentUser.getAccount() + ".png"));
				studentUser.setAvatar("upload/" + "student" + studentUser.getAccount() + ".png");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "保存成功";
		}

		return "保存失败";
	}
}
