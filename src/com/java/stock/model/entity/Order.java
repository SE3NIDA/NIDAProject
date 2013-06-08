package com.java.stock.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ORDERS database table.
 * 
 */
@Entity
@Table(name="ORDERS")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="OR_ID")
	private long orId;

	@Temporal(TemporalType.DATE)
	@Column(name="OR_DATE")
	private Date orDate;

	@Temporal(TemporalType.DATE)
	@Column(name="OR_DELIDATE")
	private Date orDelidate;

	@Column(name="OR_STATUS")
	private String orStatus;

	@Column(name="OR_TOTALAMOUNT")
	private BigDecimal orTotalamount;

	@Column(name="OR_TOTALPRICE")
	private BigDecimal orTotalprice;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="OR_CUS_ID")
	private Customer customer;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="OR_EMP_ID")
	private User user;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="order")
	private List<OrderDetail> orderDetails;

	public Order() {
	}

	public long getOrId() {
		return this.orId;
	}

	public void setOrId(long orId) {
		this.orId = orId;
	}

	public Date getOrDate() {
		return this.orDate;
	}

	public void setOrDate(Date orDate) {
		this.orDate = orDate;
	}

	public Date getOrDelidate() {
		return this.orDelidate;
	}

	public void setOrDelidate(Date orDelidate) {
		this.orDelidate = orDelidate;
	}

	public String getOrStatus() {
		return this.orStatus;
	}

	public void setOrStatus(String orStatus) {
		this.orStatus = orStatus;
	}

	public BigDecimal getOrTotalamount() {
		return this.orTotalamount;
	}

	public void setOrTotalamount(BigDecimal orTotalamount) {
		this.orTotalamount = orTotalamount;
	}

	public BigDecimal getOrTotalprice() {
		return this.orTotalprice;
	}

	public void setOrTotalprice(BigDecimal orTotalprice) {
		this.orTotalprice = orTotalprice;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setOrder(this);

		return orderDetail;
	}

	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setOrder(null);

		return orderDetail;
	}

}