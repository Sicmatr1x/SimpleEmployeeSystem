package demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import demo.beans.Job;
import demo.beans.Salary;
import demo.dao.JobDAO;
import demo.dao.SalaryDAO;


public class SalaryService {

	@Resource(name = "salaryDAO")
	private SalaryDAO salaryDAO;
	
	@Resource(name = "jobDAO")
	private JobDAO jobDAO;
	
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
	 * 根据mounth来查询指定记录
	 * @param date
	 * @return
	 */
	public List<Salary> getSalaryByDate(Date date){
		return this.salaryDAO.querySalaryByDate(date);
	}
	
	/**
	 * 根据部门来查询指定记录
	 * @param empid
	 * @return
	 */
	public List<Salary> getSalaryByDepartment(String department){
		List<Salary> salaryList = new ArrayList<>();
		
		// 获取属于department的员工集合
		List<Job> jobList = this.jobDAO.queryJobByDepartment(department);
		System.out.println("jobList.size()=" + jobList.size());
		for(Job tJob : jobList){
			// 获取单个员工的记录
			List<Salary> tList = this.getSalaryByEmpId(tJob.getEmpid());
			salaryList.addAll(salaryList.size(), tList);
		}
		return salaryList;
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
