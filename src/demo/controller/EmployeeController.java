package demo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String addEmployee(@RequestParam int id, @RequestParam String name,
			@RequestParam int age, @RequestParam String sex) {
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setAge(age);
		employee.setSex(sex);
		this.employeeService.addEmployee(employee);
		return "forward:/getEmployeeList";
	}

	@RequestMapping("/editEmployee")
	public String editEmployeeList(Model model, HttpServletRequest request) {
		String id = request.getParameter("id");
		int id1 = Integer.valueOf(id);
		Employee employee = employeeService.getEmployeeById(id1);
		model.addAttribute("employee", employee);
		return "edit";
	}
}
