package demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.beans.Salary;
import demo.dao.SalaryDAO;


public class SalaryService {

	@Resource(name = "salaryDAO")
	private SalaryDAO salaryDAO;
	
	/**
	 * 返回整张Salary表的内容
	 * @return
	 */
	public List<Salary> getAllSalary() {
		return salaryDAO.queryAllSalary();
	}
	
	/**
	 * 根据id来查询指定记录
	 * @param id
	 * @return 查得到返回Salary，查不到返回null
	 */
	public Salary getSalaryById(int id){
		return this.salaryDAO.querySalaryById(id);
	}
	
	/**
	 * 根据员工id来查询指定记录
	 * @param id
	 * @return 查得到返回Salary，查不到返回null
	 */
	public List<Salary> getSalaryByEmpId(int empid){
		return this.salaryDAO.querySalaryByEmpId(empid);
	}
	
	/**
	 * 插入记录
	 * @param salary
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int addSalary(Salary salary){
		return this.salaryDAO.addSalary(salary);
	}
	
	/**
	 * 修改给定id的记录信息
	 * @param salary
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int editSalary(Salary salary){
		return salaryDAO.editSalary(salary);
	}
	
	/**
	 * 根据员工id来删除记录
	 * @param id
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int deleteSalary(int id){
		return this.salaryDAO.deleteSalary(id);
	}

	public static void main(String[] args) {
		SalaryService es = new SalaryService();
		// 打印整表
		System.out.println(es==null);
		List<Salary> list = es.getAllSalary();
		System.out.println("\n打印全表：");
		for (Salary e : list) {
			System.out.println(e.getId() + ";" + e.getEmpid() + ";" + e.getMounth() + ";" + e.getSalary());
		}
		System.out.println("打印完毕");
	}
}
