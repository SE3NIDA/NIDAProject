package com.java.stock.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CUSTOMERS database table.
 * 
 */
@Entity
@Table(name="CUSTOMERS")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUS_ID")
	private long cusId;

	@Column(name="CUS_ADDRS")
	private String cusAddrs;

	@Column(name="CUS_EMAIL")
	private String cusEmail;

	@Column(name="CUS_FNAME")
	private String cusFname;

	@Column(name="CUS_LNAME")
	private String cusLname;

	@Column(name="CUS_REMARK")
	private String cusRemark;

	@Column(name="CUS_TEL")
	private String cusTel;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="customer")
	private List<Order> orders;

	public Customer() {
	}

	public long getCusId() {
		return this.cusId;
	}

	public void setCusId(long cusId) {
		this.cusId = cusId;
	}

	public String getCusAddrs() {
		return this.cusAddrs;
	}

	public void setCusAddrs(String cusAddrs) {
		this.cusAddrs = cusAddrs;
	}

	public String getCusEmail() {
		return this.cusEmail;
	}

	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}

	public String getCusFname() {
		return this.cusFname;
	}

	public void setCusFname(String cusFname) {
		this.cusFname = cusFname;
	}

	public String getCusLname() {
		return this.cusLname;
	}

	public void setCusLname(String cusLname) {
		this.cusLname = cusLname;
	}

	public String getCusRemark() {
		return this.cusRemark;
	}

	public void setCusRemark(String cusRemark) {
		this.cusRemark = cusRemark;
	}

	public String getCusTel() {
		return this.cusTel;
	}

	public void setCusTel(String cusTel) {
		this.cusTel = cusTel;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setCustomer(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setCustomer(null);

		return order;
	}

}