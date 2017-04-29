package demo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import demo.beans.Employee;
import demo.service.EmployeeService;

@Controller
public class EmployeeController {

	@Resource(name = "employeeService")
	private EmployeeService employeeService;

	/**
	 * http://localhost:8080/SimpleEmployeeSystem/getEmployeeList
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getEmployeeList")
	public String getEmployeeList(HttpServletRequest request) {
		List<Employee> list = employeeService.getAllEmployee();
		request.getSession().setAttribute("list", list);
		return "EmployeeList";
	}

	/**
	 * http://localhost:8080/SimpleEmployeeSystem/addEmployee?id=?&name=?&age=?&sex=?
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public ModelAndView addEmployee(Employee employee,HttpServletRequest request) {
		this.employeeService.addEmployee(employee);
		return new ModelAndView("redirect:/getEmployeeList");
	}

	/**
	 * http://localhost:8080/SimpleEmployeeSystem/editEmployee?id=?&name=?&age=?&sex=?
	 * 
	 * @param employee
	 * @return
	 */
	@RequestMapping("/editEmployee")
	public ModelAndView editEmployeeList(Employee employee) {
		this.employeeService.editEmployee(employee);
		return new ModelAndView("redirect:/getEmployeeList");
	}
	
	/**
	 * http://localhost:8080/SimpleEmployeeSystem/deleteEmployee?id=?
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteEmployee")
	public ModelAndView testedit(int id){
		this.employeeService.deleteEmployee(id);
		return new ModelAndView("redirect:/getEmployeeList");
	}
}
