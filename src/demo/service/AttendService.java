package demo.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import demo.beans.Attend;
import demo.dao.AttendDAO;
import demo.dao.BenefitDAO;
import demo.dao.JobDAO;
import demo.dao.SalaryDAO;


public class AttendService {

	@Resource(name = "attendDAO")
	private AttendDAO attendDAO;
	
	@Resource(name = "benefitDAO")
	private BenefitDAO benefitDAO;
	
	@Resource(name = "jobDAO")
	private JobDAO jobDAO;
	
	@Resource(name = "salaryDAO")
	private SalaryDAO salaryDAO;
	
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
	 * @param empid
	 * @return 查得到返回Attend，查不到返回null
	 */
	public List<Attend> getAttendByEmpId(int empid){
		return this.attendDAO.queryAttendByEmpId(empid);
	}
	
	/**
	 * 插入记录的同时计算加班津贴(benefit.bene)和每月的月工资(salary.salary)
	 * @param attend
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int addAttend(Attend attend){
		// 插入数据到Attend表
		int addAttendResult = this.attendDAO.addAttend(attend);
		return addAttendResult;
	}
	
	/**
	 * 修改给定id的记录信息
	 * @param attend
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int editAttend(Attend attend){
		// 修改数据到Attend表
		int editAttendResult = this.attendDAO.editAttend(attend);
		return editAttendResult;
	}
	
	/**
	 * 根据记录id来删除记录
	 * @param id
	 * @return -1表示抛异常，其它为mybatis返回:1表示成功;0表示失败
	 */
	public int deleteAttend(int id){
		return this.attendDAO.deleteAttend(id);
	}
	
	/**
	 * 使用SQL语句批量添加attend记录
	 * @param sql
	 * @return
	 * @throws ParseException
	 */
	public List<Integer> addAttendBySQL(String sql) throws ParseException{
		List<Integer> resultList = new ArrayList<>();
		String[] workStrings = sql.split(";");
		for(int i = 0; i < workStrings.length; i++){
			int beg = workStrings[i].indexOf("(");
			int end = workStrings[i].indexOf(")", beg);
			String valueString = workStrings[i].substring(beg + ")".length(), end);
			valueString = valueString.replace(" ", "");
			valueString = valueString.replace("\"", "");
			String[] tStrings = valueString.split(",");
			// 生成attend对象
			Attend attend = new Attend();
//			for(int j = 0; j < tStrings.length; j++){
//				System.out.println("tStrings[" + j + "]=" + tStrings[j]);
//			}
			// 写入数据
			attend.setId(Integer.valueOf(tStrings[0]));
			attend.setEmpid(Integer.valueOf(tStrings[1]));
			attend.setAttendDate(DateFactory.getDate(tStrings[2]));
			attend.setOvertime(Integer.valueOf(tStrings[3]));
			attend.setDayoff(Integer.valueOf(tStrings[4]));
			Integer result = this.addAttend(attend);
			resultList.add(result);
		}
		return resultList;
	}

	public static void main(String[] args) {
		AttendService es = new AttendService();
		// 打印整表
		System.out.println(es==null);
		List<Attend> list = es.getAllAttend();
		System.out.println("\n打印全表：");
		for (Attend e : list) {
			System.out.println(e.getId() + ";" + e.getEmpid() + ";" + e.getAttendDate() + ";" + e.getOvertime() + ";" + e.getDayoff());
		}
		System.out.println("打印完毕");
	}
}
