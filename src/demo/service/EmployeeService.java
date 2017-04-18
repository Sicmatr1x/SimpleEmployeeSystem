package demo.service;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import demo.beans.Employee;
import demo.dao.EmployeeDAO;


public class EmployeeService {

	private EmployeeDAO employeeDAO = new EmployeeDAO();
	
	/**
	 * 
	 * @return
	 */
	public List<Employee> getAllEmployee() {
		return employeeDAO.queryAllEmployee();
	}
	
	public Employee getEmployeeById(int id){
		return this.employeeDAO.queryEmployeeById(id);
	}
	
	
	public int editEmployee(Employee employee){
		return employeeDAO.editEmployee(employee);
	}
	
	
	public int addEmployee(Employee employee){
		return this.employeeDAO.addEmployee(employee);
	}

	public static void main(String[] args) {
		EmployeeService es = new EmployeeService();
		// 打印整表
		List<Employee> list = es.getAllEmployee();
		System.out.println("\n打印全表：");
		for (Employee e : list) {
			System.out.println(e.getId() + ":" + e.getName() + ":" + e.getAge()
					+ ":" + e.getSex());
		}
		System.out.println("打印完毕");
	}
}
