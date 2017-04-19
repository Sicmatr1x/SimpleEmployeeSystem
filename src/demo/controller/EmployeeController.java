package demo.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	 * http://localhost:8080/SimpleEmployeeSystem/addEmployee
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public ModelAndView addEmployee(Employee employee,HttpServletRequest request) {
//		String id=(String)request.getParameter("id");
//		String name=(String)request.getParameter("name");
//		String age=(String)request.getParameter("age");
//		String sex=(String)request.getParameter("sex");
//		Employee employee = new Employee();
//		employee.setId(Integer.valueOf(id));
//		employee.setName(name);
//		employee.setAge(Integer.valueOf(age));
//		employee.setSex(sex);
		System.out.println(employee.getId() + ";" + employee.getName());
		this.employeeService.addEmployee(employee);
		return new ModelAndView("redirect:/getEmployeeList");
//		return "/getEmployeeList";
	}

	@RequestMapping("/editEmployee")
	public ModelAndView editEmployeeList(Employee employee) {
//		Employee employee = new Employee();
//		employee.setId(id);
//		employee.setName(name);
//		employee.setAge(age);
//		employee.setSex(sex);
		System.out.println(employee==null);
//		System.out.println(employee.getId() + ";" + employee.getName());
		this.employeeService.editEmployee(employee);
		return new ModelAndView("redirect:/getEmployeeList");
//		return "EmployeeList";
	}
	
	@RequestMapping("/deleteEmployee")
	public ModelAndView testedit(int id){
		this.employeeService.deleteEmployee(id);
		return new ModelAndView("redirect:/getEmployeeList");
	}
}
