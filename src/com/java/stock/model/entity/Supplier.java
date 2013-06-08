package com.java.stock.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SUPPLIERS database table.
 * 
 */
@Entity
@Table(name="SUPPLIERS")
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SUP_ID")
	private long supId;

	@Column(name="SUP_ADDRS")
	private String supAddrs;

	@Column(name="SUP_NAME")
	private String supName;

	@Column(name="SUP_REMARK")
	private String supRemark;

	@Column(name="SUP_TEL")
	private String supTel;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="supplier")
	private List<Product> products;

	//bi-directional many-to-many association to Buy
	@ManyToMany
	@JoinTable(
		name="BUY_FROM_SUPPLIER"
		, joinColumns={
			@JoinColumn(name="BFS_SUP_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="BFS_BUY_ID")
			}
		)
	private List<Buy> buys;

	public Supplier() {
	}

	public long getSupId() {
		return this.supId;
	}

	public void setSupId(long supId) {
		this.supId = supId;
	}

	public String getSupAddrs() {
		return this.supAddrs;
	}

	public void setSupAddrs(String supAddrs) {
		this.supAddrs = supAddrs;
	}

	public String getSupName() {
		return this.supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public String getSupRemark() {
		return this.supRemark;
	}

	public void setSupRemark(String supRemark) {
		this.supRemark = supRemark;
	}

	public String getSupTel() {
		return this.supTel;
	}

	public void setSupTel(String supTel) {
		this.supTel = supTel;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setSupplier(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setSupplier(null);

		return product;
	}

	public List<Buy> getBuys() {
		return this.buys;
	}

	public void setBuys(List<Buy> buys) {
		this.buys = buys;
	}

}