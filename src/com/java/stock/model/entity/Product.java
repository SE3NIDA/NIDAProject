package com.java.stock.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PRODUCTS database table.
 * 
 */
@Entity
@Table(name="PRODUCTS")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRO_ID")
	private long proId;

	@Column(name="PRO_BALANCE")
	private BigDecimal proBalance;

	@Temporal(TemporalType.DATE)
	@Column(name="PRO_DATE")
	private Date proDate;

	@Column(name="PRO_NAME")
	private String proName;

	@Column(name="PRO_PRICE")
	private BigDecimal proPrice;

	//bi-directional many-to-one association to BuysDetail
	@OneToMany(mappedBy="product")
	private List<BuysDetail> buysDetails;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="product")
	private List<OrderDetail> orderDetails;

	//bi-directional many-to-one association to ProductType
	@ManyToOne
	@JoinColumn(name="PRO_PDT_ID")
	private ProductType productType;

	//bi-directional many-to-one association to Shelf
	@ManyToOne
	@JoinColumn(name="PRO_SH_ID")
	private Shelf shelf;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name="PRO_SUP_ID")
	private Supplier supplier;

	//bi-directional many-to-one association to ReciveProduct
	@OneToMany(mappedBy="product")
	private List<ReciveProduct> reciveProducts;

	//bi-directional many-to-one association to Summary
	@OneToMany(mappedBy="product")
	private List<Summary> summaries;

	public Product() {
	}

	public long getProId() {
		return this.proId;
	}

	public void setProId(long proId) {
		this.proId = proId;
	}

	public BigDecimal getProBalance() {
		return this.proBalance;
	}

	public void setProBalance(BigDecimal proBalance) {
		this.proBalance = proBalance;
	}

	public Date getProDate() {
		return this.proDate;
	}

	public void setProDate(Date proDate) {
		this.proDate = proDate;
	}

	public String getProName() {
		return this.proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public BigDecimal getProPrice() {
		return this.proPrice;
	}

	public void setProPrice(BigDecimal proPrice) {
		this.proPrice = proPrice;
	}

	public List<BuysDetail> getBuysDetails() {
		return this.buysDetails;
	}

	public void setBuysDetails(List<BuysDetail> buysDetails) {
		this.buysDetails = buysDetails;
	}

	public BuysDetail addBuysDetail(BuysDetail buysDetail) {
		getBuysDetails().add(buysDetail);
		buysDetail.setProduct(this);

		return buysDetail;
	}

	public BuysDetail removeBuysDetail(BuysDetail buysDetail) {
		getBuysDetails().remove(buysDetail);
		buysDetail.setProduct(null);

		return buysDetail;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setProduct(this);

		return orderDetail;
	}

	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setProduct(null);

		return orderDetail;
	}

	public ProductType getProductType() {
		return this.productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Shelf getShelf() {
		return this.shelf;
	}

	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<ReciveProduct> getReciveProducts() {
		return this.reciveProducts;
	}

	public void setReciveProducts(List<ReciveProduct> reciveProducts) {
		this.reciveProducts = reciveProducts;
	}

	public ReciveProduct addReciveProduct(ReciveProduct reciveProduct) {
		getReciveProducts().add(reciveProduct);
		reciveProduct.setProduct(this);

		return reciveProduct;
	}

	public ReciveProduct removeReciveProduct(ReciveProduct reciveProduct) {
		getReciveProducts().remove(reciveProduct);
		reciveProduct.setProduct(null);

		return reciveProduct;
	}

	public List<Summary> getSummaries() {
		return this.summaries;
	}

	public void setSummaries(List<Summary> summaries) {
		this.summaries = summaries;
	}

	public Summary addSummary(Summary summary) {
		getSummaries().add(summary);
		summary.setProduct(this);

		return summary;
	}

	public Summary removeSummary(Summary summary) {
		getSummaries().remove(summary);
		summary.setProduct(null);

		return summary;
	}

}