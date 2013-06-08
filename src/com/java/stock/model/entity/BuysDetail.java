package com.java.stock.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the BUYS_DETAIL database table.
 * 
 */
@Entity
@Table(name="BUYS_DETAIL")
public class BuysDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BuysDetailPK id;

	@Column(name="BUYD_AMOUNT")
	private BigDecimal buydAmount;

	@Column(name="BUYD_PRICE")
	private BigDecimal buydPrice;

	//bi-directional many-to-one association to Buy
	@ManyToOne
	@JoinColumn(name="BUYD_BUY_ID", referencedColumnName = "BUY_ID", insertable = false, updatable = false)
	private Buy buy;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="BUYD_PRO_ID", referencedColumnName = "PRO_ID", insertable = false, updatable = false)
	private Product product;

	public BuysDetail() {
	}

	public BuysDetailPK getId() {
		return this.id;
	}

	public void setId(BuysDetailPK id) {
		this.id = id;
	}

	public BigDecimal getBuydAmount() {
		return this.buydAmount;
	}

	public void setBuydAmount(BigDecimal buydAmount) {
		this.buydAmount = buydAmount;
	}

	public BigDecimal getBuydPrice() {
		return this.buydPrice;
	}

	public void setBuydPrice(BigDecimal buydPrice) {
		this.buydPrice = buydPrice;
	}

	public Buy getBuy() {
		return this.buy;
	}

	public void setBuy(Buy buy) {
		this.buy = buy;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}