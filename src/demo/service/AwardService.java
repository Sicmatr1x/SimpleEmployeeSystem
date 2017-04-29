package demo.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import demo.beans.Award;
import demo.dao.AwardDAO;

public class AwardService {
	
	@Resource(name = "awardDAO")
	private AwardDAO awardDAO;
	
	/**
	 * 使用benefit,salary表来计算指定年的某员工全年工资,津贴,年终奖;
	 * 该员工需符合以下条件才会计算,否则返回null:
	 * 1.有指定年的1-12月的benefit记录;
	 * 2.有指定年的1-12月的salary记录;
	 * @param empid 员工工号
	 * @param year 年份
	 * @return
	 */
	public Award queryAwardByEmpId (int empid, Date year){
		return awardDAO.queryAwardByEmpId(empid, year);
	}
	
	/**
	 * 使用benefit,salary表来计算指定年的所有满足以下条件员工全年工资,津贴,年终奖;
	 * 该员工需符合以下条件才会计算,否则返回null:
	 * 1.有指定年的1-12月的benefit记录;
	 * 2.有指定年的1-12月的salary记录;
	 * @param year 年份
	 * @return 用Award表示的计算结果,不符合条件的不会出现
	 */
	public List<Award> queryYearAwardList(Date year){
		return this.awardDAO.queryYearAwardList(year);
	}
}
