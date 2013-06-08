package com.java.stock.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the WAREHOUSE database table.
 * 
 */
@Entity
public class Warehouse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="WA_ID")
	private long waId;

	@Column(name="WA_EMAIL")
	private String waEmail;

	@Column(name="WA_LOCATE")
	private String waLocate;

	@Column(name="WA_NAME")
	private String waName;

	@Column(name="WA_TEL")
	private String waTel;
	
	@Column(name="WA_STATUS")
	private String waStatus;
	
	@Column(name="WA_UPBY")
	private String waUpby;
	
	@Temporal(TemporalType.DATE)
	@Column(name="WA_CREDATE")
	private Date waCredate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="WA_UPDATE")
	private Date waUpdate;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="warehouse")
	private List<Employee> employees;

	//bi-directional many-to-one association to Shelf
	@OneToMany(mappedBy="warehouse")
	private List<Shelf> shelfs;

	//bi-directional many-to-one association to Summary
	@OneToMany(mappedBy="warehouse")
	private List<Summary> summaries;

	public Warehouse() {
	}

	public long getWaId() {
		return this.waId;
	}

	public void setWaId(long waId) {
		this.waId = waId;
	}

	public String getWaEmail() {
		return this.waEmail;
	}

	public void setWaEmail(String waEmail) {
		this.waEmail = waEmail;
	}

	public String getWaLocate() {
		return this.waLocate;
	}

	public void setWaLocate(String waLocate) {
		this.waLocate = waLocate;
	}

	public String getWaName() {
		return this.waName;
	}

	public void setWaName(String waName) {
		this.waName = waName;
	}

	public String getWaTel() {
		return this.waTel;
	}

	public void setWaTel(String waTel) {
		this.waTel = waTel;
	}
	

	public String getWaStatus() {
		return waStatus;
	}

	public void setWaStatus(String waStatus) {
		this.waStatus = waStatus;
	}

	public String getWaUpby() {
		return waUpby;
	}

	public void setWaUpby(String waUpby) {
		this.waUpby = waUpby;
	}

	public Date getWaCredate() {
		return waCredate;
	}

	public void setWaCredate(Date waCredate) {
		this.waCredate = waCredate;
	}

	public Date getWaUpdate() {
		return waUpdate;
	}

	public void setWaUpdate(Date waUpdate) {
		this.waUpdate = waUpdate;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setWarehouse(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setWarehouse(null);

		return employee;
	}

	public List<Shelf> getShelfs() {
		return this.shelfs;
	}

	public void setShelfs(List<Shelf> shelfs) {
		this.shelfs = shelfs;
	}

	public Shelf addShelf(Shelf shelf) {
		getShelfs().add(shelf);
		shelf.setWarehouse(this);

		return shelf;
	}

	public Shelf removeShelf(Shelf shelf) {
		getShelfs().remove(shelf);
		shelf.setWarehouse(null);

		return shelf;
	}

	public List<Summary> getSummaries() {
		return this.summaries;
	}

	public void setSummaries(List<Summary> summaries) {
		this.summaries = summaries;
	}

	public Summary addSummary(Summary summary) {
		getSummaries().add(summary);
		summary.setWarehouse(this);

		return summary;
	}

	public Summary removeSummary(Summary summary) {
		getSummaries().remove(summary);
		summary.setWarehouse(null);

		return summary;
	}

}