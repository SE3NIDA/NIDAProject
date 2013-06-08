package com.java.stock.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SUMMARY database table.
 * 
 */
@Entity
public class Summary implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SummaryPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="SUM_DATE")
	private Date sumDate;

	@Column(name="SUM_DIF_AMOUNT")
	private BigDecimal sumDifAmount;

	@Column(name="SUM_REAL_COUNT")
	private BigDecimal sumRealCount;

	@Column(name="SUM_YEAR")
	private String sumYear;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="SUM_PRO_ID", referencedColumnName = "PRO_ID", insertable = false, updatable = false)
	private Product product;

	//bi-directional many-to-one association to Warehouse
	@ManyToOne
	@JoinColumn(name="SUM_WA_ID", referencedColumnName = "WA_ID", insertable = false, updatable = false)
	private Warehouse warehouse;

	public Summary() {
	}

	public SummaryPK getId() {
		return this.id;
	}

	public void setId(SummaryPK id) {
		this.id = id;
	}

	public Date getSumDate() {
		return this.sumDate;
	}

	public void setSumDate(Date sumDate) {
		this.sumDate = sumDate;
	}

	public BigDecimal getSumDifAmount() {
		return this.sumDifAmount;
	}

	public void setSumDifAmount(BigDecimal sumDifAmount) {
		this.sumDifAmount = sumDifAmount;
	}

	public BigDecimal getSumRealCount() {
		return this.sumRealCount;
	}

	public void setSumRealCount(BigDecimal sumRealCount) {
		this.sumRealCount = sumRealCount;
	}

	public String getSumYear() {
		return this.sumYear;
	}

	public void setSumYear(String sumYear) {
		this.sumYear = sumYear;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Warehouse getWarehouse() {
		return this.warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

}