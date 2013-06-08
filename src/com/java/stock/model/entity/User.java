package com.java.stock.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="US_EMP_ID")
	private long usEmpId;

	@Column(name="US_BY")
	private String usBy;

	@Temporal(TemporalType.DATE)
	@Column(name="US_CREDATE")
	private Date usCredate;

	@Column(name="US_LEVEL")
	private BigDecimal usLevel;

	@Column(name="US_NAME")
	private String usName;

	@Column(name="US_PASS")
	private String usPass;

	@Column(name="US_STATE")
	private String usState;

	@Temporal(TemporalType.DATE)
	@Column(name="US_UPDDATE")
	private Date usUpddate;

	//bi-directional many-to-one association to Buy
	@OneToMany(mappedBy="user")
	private List<Buy> buys;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="user")
	private List<Order> orders;

	//bi-directional one-to-one association to Employee
	@OneToOne
	@JoinColumn(name="US_EMP_ID")
	private Employee employee;

	public User() {
	}

	public long getUsEmpId() {
		return this.usEmpId;
	}

	public void setUsEmpId(long usEmpId) {
		this.usEmpId = usEmpId;
	}

	public String getUsBy() {
		return this.usBy;
	}

	public void setUsBy(String usBy) {
		this.usBy = usBy;
	}

	public Date getUsCredate() {
		return this.usCredate;
	}

	public void setUsCredate(Date usCredate) {
		this.usCredate = usCredate;
	}

	public BigDecimal getUsLevel() {
		return this.usLevel;
	}

	public void setUsLevel(BigDecimal usLevel) {
		this.usLevel = usLevel;
	}

	public String getUsName() {
		return this.usName;
	}

	public void setUsName(String usName) {
		this.usName = usName;
	}

	public String getUsPass() {
		return this.usPass;
	}

	public void setUsPass(String usPass) {
		this.usPass = usPass;
	}

	public String getUsState() {
		return this.usState;
	}

	public void setUsState(String usState) {
		this.usState = usState;
	}

	public Date getUsUpddate() {
		return this.usUpddate;
	}

	public void setUsUpddate(Date usUpddate) {
		this.usUpddate = usUpddate;
	}

	public List<Buy> getBuys() {
		return this.buys;
	}

	public void setBuys(List<Buy> buys) {
		this.buys = buys;
	}

	public Buy addBuy(Buy buy) {
		getBuys().add(buy);
		buy.setUser(this);

		return buy;
	}

	public Buy removeBuy(Buy buy) {
		getBuys().remove(buy);
		buy.setUser(null);

		return buy;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setUser(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setUser(null);

		return order;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}