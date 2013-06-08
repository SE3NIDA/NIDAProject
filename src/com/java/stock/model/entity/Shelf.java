package com.java.stock.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the SHELF database table.
 * 
 */
@Entity
public class Shelf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SH_ID")
	private long shId;

	@Column(name="SH_BLOCK")
	private BigDecimal shBlock;

	@Column(name="SH_FLOOR")
	private BigDecimal shFloor;

	@Column(name="SH_NAME")
	private String shName;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="shelf")
	private List<Product> products;

	//bi-directional many-to-one association to Warehouse
	@ManyToOne
	@JoinColumn(name="SH_WA_ID")
	private Warehouse warehouse;

	public Shelf() {
	}

	public long getShId() {
		return this.shId;
	}

	public void setShId(long shId) {
		this.shId = shId;
	}

	public BigDecimal getShBlock() {
		return this.shBlock;
	}

	public void setShBlock(BigDecimal shBlock) {
		this.shBlock = shBlock;
	}

	public BigDecimal getShFloor() {
		return this.shFloor;
	}

	public void setShFloor(BigDecimal shFloor) {
		this.shFloor = shFloor;
	}

	public String getShName() {
		return this.shName;
	}

	public void setShName(String shName) {
		this.shName = shName;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setShelf(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setShelf(null);

		return product;
	}

	public Warehouse getWarehouse() {
		return this.warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

}