package demo.beans;

import java.util.Date;

/**
 * id,empid,attendDate,attendType
 * 
 * @author sicmatr1x
 * 
 */
public class Attend {
	private int id;
	private int empid;
	private Date attendDate;
	private int attendType;

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

	public int getAttendType() {
		return attendType;
	}

	public void setAttendType(int attendType) {
		this.attendType = attendType;
	}
}
