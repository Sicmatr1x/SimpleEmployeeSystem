package demo.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * id,empid,attendDate,attendType
 * 
 * @author sicmatr1x
 * 
 */
@SuppressWarnings("serial")
public class Attend implements Serializable{
	private int id;
	private int empid;
	private Date attendDate;
	private int overtime;
	private int dayoff;

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

	public Date getAttendDate() {
		return attendDate;
	}

	public void setAttendDate(Date attendDate) {
		this.attendDate = attendDate;
	}

	public int getOvertime() {
		return overtime;
	}

	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}

	public int getDayoff() {
		return dayoff;
	}

	public void setDayoff(int dayoff) {
		this.dayoff = dayoff;
	}


}
