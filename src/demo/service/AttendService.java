package demo.service;

import java.util.List;

import javax.annotation.Resource;

import demo.beans.Attend;
import demo.dao.AttendDAO;


public class AttendService {

	@Resource(name = "attendDAO")
	private AttendDAO attendDAO;
	
	/**
	 * 返回整张Attend表的内容
	 * @return
	 */
	public List<Attend> getAllAttend() {
		return attendDAO.queryAllAttend();
	}
	
	/**
	 * 根据id来查询指定记录
	 * @param id
	 * @return 查得到返回Attend，查不到返回null
	 */
	public Attend getAttendById(int id){
		return this.attendDAO.queryAttendById(id);
	}
	
	/**
	 * 根据员工id来查询指定记录
	 * @param id
	 * @return 查得到返回Attend，查不到返回null
	 */
	public List<Attend> getAttendByEmpId(int empid){
		return this.attendDAO.queryAttendByEmpId(empid);
	}
	
	/**
	 * 插入记录
	 * @param attend
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int addAttend(Attend attend){
		return this.attendDAO.addAttend(attend);
	}
	
	/**
	 * 修改给定id的记录信息
	 * @param attend
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int editAttend(Attend attend){
		return attendDAO.editAttend(attend);
	}
	
	/**
	 * 根据员工id来删除记录
	 * @param id
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int deleteAttend(int id){
		return this.attendDAO.deleteAttend(id);
	}

	public static void main(String[] args) {
		AttendService es = new AttendService();
		// 打印整表
		System.out.println(es==null);
		List<Attend> list = es.getAllAttend();
		System.out.println("\n打印全表：");
		for (Attend e : list) {
			System.out.println(e.getId() + ";" + e.getEmpid() + ";" + e.getAttendDate() + ";" + e.getAttendType());
		}
		System.out.println("打印完毕");
	}
}
