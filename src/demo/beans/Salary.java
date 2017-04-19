package demo.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * id, empid, mounth, salary
 * 
 * @author sicmatr1x
 * 
 */
public class Salary implements Serializable {
	private int id;
	private int empid;
	private Date mounth;
	private int salary;

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

	public Date getMounth() {
		return mounth;
	}

	public void setMounth(Date mounth) {
		this.mounth = mounth;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
