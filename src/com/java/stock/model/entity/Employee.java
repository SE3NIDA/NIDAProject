package com.java.stock.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the EMPLOYEES database table.
 * 
 */
@Entity
@Table(name="EMPLOYEES")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EMP_ID")
	private long empId;

	@Column(name="EMP_ADDR")
	private String empAddr;

	@Column(name="EMP_EMAIL")
	private String empEmail;

	@Column(name="EMP_FNAME")
	private String empFname;

	@Column(name="EMP_LNAME")
	private String empLname;

	@Column(name="EMP_POSITION")
	private String empPosition;

	@Column(name="EMP_SALARY")
	private BigDecimal empSalary;

	@Temporal(TemporalType.DATE)
	@Column(name="EMP_STRDATE")
	private Date empStrdate;

	@Column(name="EMP_TEL")
	private String empTel;
	
	@Column(name="EMP_STATE")
	private String empStatus;

	//bi-directional many-to-one association to Warehouse
	@ManyToOne
	@JoinColumn(name="EMP_WA_ID")
	private Warehouse warehouse;

	//bi-directional one-to-one association to User
	@OneToOne(mappedBy="employee")
	private User user;

	public Employee() {
	}

	public long getEmpId() {
		return this.empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpAddr() {
		return this.empAddr;
	}

	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}

	public String getEmpEmail() {
		return this.empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpFname() {
		return this.empFname;
	}

	public void setEmpFname(String empFname) {
		this.empFname = empFname;
	}

	public String getEmpLname() {
		return this.empLname;
	}

	public void setEmpLname(String empLname) {
		this.empLname = empLname;
	}

	public String getEmpPosition() {
		return this.empPosition;
	}

	public void setEmpPosition(String empPosition) {
		this.empPosition = empPosition;
	}

	public BigDecimal getEmpSalary() {
		return this.empSalary;
	}

	public void setEmpSalary(BigDecimal empSalary) {
		this.empSalary = empSalary;
	}

	public Date getEmpStrdate() {
		return this.empStrdate;
	}

	public void setEmpStrdate(Date empStrdate) {
		this.empStrdate = empStrdate;
	}

	public String getEmpTel() {
		return this.empTel;
	}

	public void setEmpTel(String empTel) {
		this.empTel = empTel;
	}
	

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	public Warehouse getWarehouse() {
		return this.warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}