package com.java.stock.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the BUYS database table.
 * 
 */
@Entity
@Table(name="BUYS")
public class Buy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BUY_ID")
	private long buyId;

	@Temporal(TemporalType.DATE)
	@Column(name="BUY_DATE")
	private Date buyDate;

	@Column(name="BUY_PAID")
	private BigDecimal buyPaid;

	@Column(name="BUY_STATUS")
	private String buyStatus;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="BUY_EMP_ID")
	private User user;

	//bi-directional many-to-one association to BuysDetail
	@OneToMany(mappedBy="buy")
	private List<BuysDetail> buysDetails;

	//bi-directional many-to-one association to ReciveProduct
	@OneToMany(mappedBy="buy")
	private List<ReciveProduct> reciveProducts;

	//bi-directional many-to-many association to Supplier
	@ManyToMany(mappedBy="buys")
	private List<Supplier> suppliers;

	public Buy() {
	}

	public long getBuyId() {
		return this.buyId;
	}

	public void setBuyId(long buyId) {
		this.buyId = buyId;
	}

	public Date getBuyDate() {
		return this.buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public BigDecimal getBuyPaid() {
		return this.buyPaid;
	}

	public void setBuyPaid(BigDecimal buyPaid) {
		this.buyPaid = buyPaid;
	}

	public String getBuyStatus() {
		return this.buyStatus;
	}

	public void setBuyStatus(String buyStatus) {
		this.buyStatus = buyStatus;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<BuysDetail> getBuysDetails() {
		return this.buysDetails;
	}

	public void setBuysDetails(List<BuysDetail> buysDetails) {
		this.buysDetails = buysDetails;
	}

	public BuysDetail addBuysDetail(BuysDetail buysDetail) {
		getBuysDetails().add(buysDetail);
		buysDetail.setBuy(this);

		return buysDetail;
	}

	public BuysDetail removeBuysDetail(BuysDetail buysDetail) {
		getBuysDetails().remove(buysDetail);
		buysDetail.setBuy(null);

		return buysDetail;
	}

	public List<ReciveProduct> getReciveProducts() {
		return this.reciveProducts;
	}

	public void setReciveProducts(List<ReciveProduct> reciveProducts) {
		this.reciveProducts = reciveProducts;
	}

	public ReciveProduct addReciveProduct(ReciveProduct reciveProduct) {
		getReciveProducts().add(reciveProduct);
		reciveProduct.setBuy(this);

		return reciveProduct;
	}

	public ReciveProduct removeReciveProduct(ReciveProduct reciveProduct) {
		getReciveProducts().remove(reciveProduct);
		reciveProduct.setBuy(null);

		return reciveProduct;
	}

	public List<Supplier> getSuppliers() {
		return this.suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

}