package com.java.stock.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the RECIVE_PRODUCT database table.
 * 
 */
@Entity
@Table(name="RECIVE_PRODUCT")
public class ReciveProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReciveProductPK id;

	@Column(name="REC_AMOUNT")
	private BigDecimal recAmount;

	@Temporal(TemporalType.DATE)
	@Column(name="REC_DATE")
	private Date recDate;

	//bi-directional many-to-one association to Buy
	@ManyToOne
	@JoinColumn(name="REC_BUY_ID", referencedColumnName = "BUY_ID", insertable = false, updatable = false)
	private Buy buy;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="REC_PRO_ID", referencedColumnName = "PRO_ID", insertable = false, updatable = false)
	private Product product;

	public ReciveProduct() {
	}

	public ReciveProductPK getId() {
		return this.id;
	}

	public void setId(ReciveProductPK id) {
		this.id = id;
	}

	public BigDecimal getRecAmount() {
		return this.recAmount;
	}

	public void setRecAmount(BigDecimal recAmount) {
		this.recAmount = recAmount;
	}

	public Date getRecDate() {
		return this.recDate;
	}

	public void setRecDate(Date recDate) {
		this.recDate = recDate;
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