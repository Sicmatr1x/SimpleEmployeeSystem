package demo.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import demo.beans.Salary;
import demo.service.SalaryService;
import demo.service.DateFactory;

@Controller
public class SalaryController {

	@Resource(name = "salaryService")
	private SalaryService salaryService;

	/**
	 * http://localhost:8080/SimpleSalarySystem/getSalaryList
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getSalaryList")
	public String getSalaryList(HttpServletRequest request) {
		List<Salary> list = salaryService.getAllSalary();
		request.getSession().setAttribute("list", list);
		return "SalaryList";
	}

	/**
	 * http://localhost:8080/SimpleSalarySystem/addSalary
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addSalary", method = RequestMethod.GET)
	public ModelAndView addSalary(HttpServletRequest request) {
		Salary salary = new Salary();
		salary.setId(Integer.valueOf(request.getParameter("id")));
		salary.setEmpid(Integer.valueOf(request.getParameter("empid")));
		try {
			salary.setMounth(DateFactory.getDate(request.getParameter("mounth")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		salary.setSalary(Integer.valueOf(request.getParameter("salary")));
		this.salaryService.addSalary(salary);
		return new ModelAndView("redirect:/getSalaryList");
	}

	/**
	 * http://localhost:8080/SimpleSalarySystem/editSalary
	 * @param salary
	 * @return
	 */
	@RequestMapping("/editSalary")
	public ModelAndView editSalaryList(HttpServletRequest request) {
		Salary salary = new Salary();
		salary.setId(Integer.valueOf(request.getParameter("id")));
		salary.setEmpid(Integer.valueOf(request.getParameter("empid")));
		try {
			salary.setMounth(DateFactory.getDate(request.getParameter("mounth")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		salary.setSalary(Integer.valueOf(request.getParameter("salary")));
		this.salaryService.editSalary(salary);
		return new ModelAndView("redirect:/getSalaryList");
	}
	
	/**
	 * http://localhost:8080/SimpleSalarySystem/deleteSalary
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteSalary")
	public ModelAndView testedit(int id){
		this.salaryService.deleteSalary(id);
		return new ModelAndView("redirect:/getSalaryList");
	}
}
