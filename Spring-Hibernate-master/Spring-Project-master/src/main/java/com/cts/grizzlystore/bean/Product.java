package com.cts.grizzlystore.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
	
	@Id
	private String productId;
	private String productName;
	private String productCategory;
	private String productBrand;
	private String productDescription;
	private String productPrice;
	
	
	@Column
	public String getProductId() {
		return productId;
	}

	@Column
	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductCategory() {
		return productCategory;
	}


	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}


	public String getProductBrand() {
		return productBrand;
	}


	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public String getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}


	public Product() {
		super();
	}


	public Product(String productId, String productName, String productCategory, String productBrand,
			String productDescription, String productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productBrand = productBrand;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
	}
	
	
	
	
	
}
