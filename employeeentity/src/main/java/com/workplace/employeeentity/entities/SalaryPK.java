package com.workplace.employeeentity.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * The primary key class for the salaries database table.
 * 
 */
@Embeddable
public class SalaryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="emp_no", insertable=false, updatable=false)
	private int empNo;

	@Temporal(TemporalType.DATE)
	@Column(name="from_date")
	private Date fromDate;

	public SalaryPK() {
	}
	public int getEmpNo() {
		return this.empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public Date getFromDate() {
		return this.fromDate;
	}
	public void setFromDate(java.util.Date fromDate) {
		this.fromDate = fromDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SalaryPK)) {
			return false;
		}
		SalaryPK castOther = (SalaryPK)other;
		return 
			(this.empNo == castOther.empNo)
			&& this.fromDate.equals(castOther.fromDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.empNo;
		hash = hash * prime + this.fromDate.hashCode();
		
		return hash;
	}
}