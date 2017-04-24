package demo.service;

import java.util.List;

import javax.annotation.Resource;

import demo.beans.Employee;
import demo.dao.EmployeeDAO;


public class EmployeeService {

	@Resource(name = "employeeDAO")
	private EmployeeDAO employeeDAO;
	
	/**
	 * 返回整张Employee表的内容
	 * @return
	 */
	public List<Employee> getAllEmployee() {
		return employeeDAO.queryAllEmployee();
	}
	
	/**
	 * 根据id来查询指定员工
	 * @param id
	 * @return 查得到返回Employee，查不到返回null
	 */
	public Employee getEmployeeById(int id){
		return this.employeeDAO.queryEmployeeById(id);
	}
	
	/**
	 * 插入员工
	 * @param employee
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int addEmployee(Employee employee){
		return this.employeeDAO.addEmployee(employee);
	}
	
	/**
	 * 修改给定id的员工信息
	 * @param employee
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int editEmployee(Employee employee){
		return employeeDAO.editEmployee(employee);
	}
	
	/**
	 * 根据员工id来删除员工
	 * @param id
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int deleteEmployee(int id){
		return this.employeeDAO.deleteEmployee(id);
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
