package com.java.stock.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PRODUCT_TYPE database table.
 * 
 */
@Entity
@Table(name="PRODUCT_TYPE")
public class ProductType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PDT_ID")
	private long pdtId;

	@Column(name="PDT_DESC")
	private String pdtDesc;

	@Column(name="PDT_NAME")
	private String pdtName;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="productType")
	private List<Product> products;

	public ProductType() {
	}

	public long getPdtId() {
		return this.pdtId;
	}

	public void setPdtId(long pdtId) {
		this.pdtId = pdtId;
	}

	public String getPdtDesc() {
		return this.pdtDesc;
	}

	public void setPdtDesc(String pdtDesc) {
		this.pdtDesc = pdtDesc;
	}

	public String getPdtName() {
		return this.pdtName;
	}

	public void setPdtName(String pdtName) {
		this.pdtName = pdtName;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProductType(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProductType(null);

		return product;
	}

}