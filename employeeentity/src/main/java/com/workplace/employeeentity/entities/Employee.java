package com.workplace.employeeentity.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the employees database table.
 * 
 */

enum Gender{
	M, F
}

@Entity
@Table(name="employees")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="emp_no")
	private int empNo;

	@Temporal(TemporalType.DATE)
	@Column(name="birth_date")
	private Date birthDate;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Temporal(TemporalType.DATE)
	@Column(name="hire_date")
	private Date hireDate;

	@Column(name="last_name")
	private String lastName;

	//bi-directional many-to-one association to DeptEmp
	// One employee may have worked in different departments during different periods
	@OneToMany(mappedBy="employee")
	private Set<DeptEmp> deptEmps;

	//bi-directional many-to-one association to DeptManager
	@OneToMany(mappedBy="employee")
	private Set<DeptManager> deptManagers;

	//bi-directional many-to-one association to Salary
	@OneToMany(mappedBy="employee")
	private Set<Salary> salaries;

	//bi-directional many-to-one association to Title
	// One employee may have acquired different titles during different periods
	@OneToMany(mappedBy="employee")
	private Set<Title> titles;

	public Employee() {
	}

	public int getEmpNo() {
		return this.empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Set<DeptEmp> getDeptEmps() {
		return this.deptEmps;
	}

	public void setDeptEmps(Set<DeptEmp> deptEmps) {
		this.deptEmps = deptEmps;
	}

	public DeptEmp addDeptEmp(DeptEmp deptEmp) {
		getDeptEmps().add(deptEmp);
		deptEmp.setEmployee(this);

		return deptEmp;
	}

	public DeptEmp removeDeptEmp(DeptEmp deptEmp) {
		getDeptEmps().remove(deptEmp);
		deptEmp.setEmployee(null);

		return deptEmp;
	}

	public Set<DeptManager> getDeptManagers() {
		return this.deptManagers;
	}

	public void setDeptManagers(Set<DeptManager> deptManagers) {
		this.deptManagers = deptManagers;
	}

	public DeptManager addDeptManager(DeptManager deptManager) {
		getDeptManagers().add(deptManager);
		deptManager.setEmployee(this);

		return deptManager;
	}

	public DeptManager removeDeptManager(DeptManager deptManager) {
		getDeptManagers().remove(deptManager);
		deptManager.setEmployee(null);

		return deptManager;
	}

	public Set<Salary> getSalaries() {
		return this.salaries;
	}

	public void setSalaries(Set<Salary> salaries) {
		this.salaries = salaries;
	}

	public Salary addSalary(Salary salary) {
		getSalaries().add(salary);
		salary.setEmployee(this);

		return salary;
	}

	public Salary removeSalary(Salary salary) {
		getSalaries().remove(salary);
		salary.setEmployee(null);

		return salary;
	}

	public Set<Title> getTitles() {
		return this.titles;
	}

	public void setTitles(Set<Title> titles) {
		this.titles = titles;
	}

	public Title addTitle(Title title) {
		getTitles().add(title);
		title.setEmployee(this);

		return title;
	}

	public Title removeTitle(Title title) {
		getTitles().remove(title);
		title.setEmployee(null);

		return title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}