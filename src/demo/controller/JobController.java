package demo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import demo.beans.Job;
import demo.service.JobService;

@Controller
public class JobController {

	@Resource(name = "jobService")
	private JobService jobService;

	/**
	 * http://localhost:8080/SimpleJobSystem/getJobList
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getJobList")
	public String getJobList(HttpServletRequest request) {
		List<Job> list = jobService.getAllJob();
		request.getSession().setAttribute("list", list);
		return "JobList";
	}

	/**
	 * http://localhost:8080/SimpleJobSystem/addJob
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addJob", method = RequestMethod.GET)
	public ModelAndView addJob(HttpServletRequest request) {
		Job job = new Job();
		job.setId(Integer.valueOf(request.getParameter("id")));
		job.setEmpid(Integer.valueOf(request.getParameter("empid")));
		job.setJobType(request.getParameter("jobType"));
		job.setJobLevel(Integer.valueOf(request.getParameter("jobLevel")));
		job.setBaseSalary(Integer.valueOf(request.getParameter("baseSalary")));
		job.setDepartment(request.getParameter("department"));
		this.jobService.addJob(job);
		return new ModelAndView("redirect:/getJobList");
	}

	/**
	 * http://localhost:8080/SimpleJobSystem/editJob
	 * @param job
	 * @return
	 */
	@RequestMapping("/editJob")
	public ModelAndView editJobList(HttpServletRequest request) {
		Job job = new Job();
		job.setId(Integer.valueOf(request.getParameter("id")));
		job.setEmpid(Integer.valueOf(request.getParameter("empid")));
		job.setJobType(request.getParameter("jobType"));
		job.setJobLevel(Integer.valueOf(request.getParameter("jobLevel")));
		job.setBaseSalary(Integer.valueOf(request.getParameter("baseSalary")));
		job.setDepartment(request.getParameter("department"));
		this.jobService.editJob(job);
		return new ModelAndView("redirect:/getJobList");
	}
	
	/**
	 * http://localhost:8080/SimpleJobSystem/deleteJob
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteJob")
	public ModelAndView testedit(int id){
		this.jobService.deleteJob(id);
		return new ModelAndView("redirect:/getJobList");
	}
}
