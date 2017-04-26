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
	 * 
	 * @param empid
	 * @param year
	 * @return
	 */
	public Award queryAwardByEmpId (int empid, Date year){
		return awardDAO.queryAwardByEmpId(empid, year);
	}
	
	/**
	 * 
	 * @param year
	 * @return
	 */
	public List<Award> queryYearAwardList(Date year){
		return this.awardDAO.queryYearAwardList(year);
	}
}
