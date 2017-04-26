package demo.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工年终奖金
 * @author sicmatr1x
 *
 */
@SuppressWarnings("serial")
public class Award implements Serializable {
	private int id;
	private int empid;
	private Date year;
	private int allBenefit;
	private int allSalary;
	/**
	 * 员工的年终奖金计算公式=（员工本年度的工资总和＋津贴的总和）/12
	 */
	private int award;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	public int getAllBenefit() {
		return allBenefit;
	}
	public void setAllBenefit(int allBenefit) {
		this.allBenefit = allBenefit;
	}
	public int getAllSalary() {
		return allSalary;
	}
	public void setAllSalary(int allSalary) {
		this.allSalary = allSalary;
	}
	public int getAward() {
		return award;
	}
	public void setAward(int award) {
		this.award = award;
	}
	
	
}
