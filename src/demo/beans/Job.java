package demo.beans;

import java.io.Serializable;

/**
 * id, empid, jobType, jobLevel, baseSalary, department
 * 
 * @author sicmatr1x
 * 
 */
public class Job implements Serializable {
	private int id;
	private int empid;
	private String jobType;
	private int jobLevel;
	private int baseSalary;
	private String department;

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

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public int getJobLevel() {
		return jobLevel;
	}

	public void setJobLevel(int jobLevel) {
		this.jobLevel = jobLevel;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
