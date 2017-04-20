package demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.beans.Job;
import demo.dao.JobDAO;


public class JobService {

	@Resource(name = "jobDAO")
	private JobDAO jobDAO;
	
	/**
	 * 返回整张Job表的内容
	 * @return
	 */
	public List<Job> getAllJob() {
		return jobDAO.queryAllJob();
	}
	
	/**
	 * 根据id来查询指定记录
	 * @param id
	 * @return 查得到返回Job，查不到返回null
	 */
	public Job getJobById(int id){
		return this.jobDAO.queryJobById(id);
	}
	
	/**
	 * 根据员工id来查询指定记录
	 * @param id
	 * @return 查得到返回Job，查不到返回null
	 */
	public List<Job> getJobByEmpId(int empid){
		return this.jobDAO.queryJobByEmpId(empid);
	}
	
	/**
	 * 插入记录
	 * @param job
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int addJob(Job job){
		return this.jobDAO.addJob(job);
	}
	
	/**
	 * 修改给定id的记录信息
	 * @param job
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int editJob(Job job){
		return jobDAO.editJob(job);
	}
	
	/**
	 * 根据员工id来删除记录
	 * @param id
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int deleteJob(int id){
		return this.jobDAO.deleteJob(id);
	}

	public static void main(String[] args) {
		JobService es = new JobService();
		// 打印整表
		System.out.println(es==null);
		List<Job> list = es.getAllJob();
		System.out.println("\n打印全表：");
		for (Job e : list) {
			System.out.println(e.getId() + ";" + e.getEmpid() + ";" + e.getJobType() + ";" + e.getJobLevel()
 					+ ";" + e.getBaseSalary()+ ";" + e.getBaseSalary());
		}
		System.out.println("打印完毕");
	}
}
