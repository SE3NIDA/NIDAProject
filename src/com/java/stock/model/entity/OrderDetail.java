package com.java.stock.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ORDER_DETAIL database table.
 * 
 */
@Entity
@Table(name="ORDER_DETAIL")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderDetailPK id;

	@Column(name="ORD_AMOUNT")
	private BigDecimal ordAmount;

	@Column(name="ORD_PRICE")
	private BigDecimal ordPrice;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="ORD_OR_ID", referencedColumnName = "OR_ID", insertable = false, updatable = false)
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="ORD_PRO_ID", referencedColumnName = "PRO_ID", insertable = false, updatable = false)
	private Product product;

	public OrderDetail() {
	}

	public OrderDetailPK getId() {
		return this.id;
	}

	public void setId(OrderDetailPK id) {
		this.id = id;
	}

	public BigDecimal getOrdAmount() {
		return this.ordAmount;
	}

	public void setOrdAmount(BigDecimal ordAmount) {
		this.ordAmount = ordAmount;
	}

	public BigDecimal getOrdPrice() {
		return this.ordPrice;
	}

	public void setOrdPrice(BigDecimal ordPrice) {
		this.ordPrice = ordPrice;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}