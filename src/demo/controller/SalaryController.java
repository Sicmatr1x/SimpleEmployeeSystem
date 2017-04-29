package demo.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
	 * http://localhost:8080/SimpleEmployeeSystem/getSalaryList
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
	 * http://localhost:8080/SimpleEmployeeSystem/queryEmployeeSalary?empid=
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryEmployeeSalary")
	public String queryEmployeeSalary(HttpServletRequest request) {
		int empid = Integer.valueOf(request.getParameter("empid"));
//		System.out.println("queryEmployeeSalary:" + empid);
		List<Salary> list = salaryService.getSalaryByEmpId(empid);
		request.getSession().setAttribute("list", list);
		return "QueryEmployeeSalary";
	}
	
	/**
	 * http://localhost:8080/SimpleEmployeeSystem/querySalaryByDate?mounth=
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/querySalaryByDate")
	public String querySalaryByDate(HttpServletRequest request) {
		Date mounth;
		try {
			mounth = DateFactory.getDate(request.getParameter("mounth"));
//			System.out.println("queryEmployeeSalary:" + mounth);
			List<Salary> list = salaryService.getSalaryByDate(mounth);
			request.getSession().setAttribute("list", list);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "QuerySalaryByDate";
	}
	
	/**
	 * http://localhost:8080/SimpleEmployeeSystem/queryDepartmentSalary?department=
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryDepartmentSalary")
	public String queryDepartmentSalary(HttpServletRequest request) {
		String department = request.getParameter("department");
//		System.out.println("queryDepartmentSalary:" + department);
		List<Salary> list = salaryService.getSalaryByDepartment(department);
		request.getSession().setAttribute("list", list);
		request.getSession().setAttribute("department", department);
		return "QueryDepartmentSalary";
	}

	/**
	 * http://localhost:8080/SimpleEmployeeSystem/addSalary?id=?&empid=?&mounth=?&salary=?
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
	 * http://localhost:8080/SimpleEmployeeSystem/editSalary?id=?&empid=?&mounth=?&salary=?
	 * 
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
	 * http://localhost:8080/SimpleEmployeeSystem/deleteSalary?id=
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteSalary")
	public ModelAndView testedit(int id){
		this.salaryService.deleteSalary(id);
		return new ModelAndView("redirect:/getSalaryList");
	}
}
