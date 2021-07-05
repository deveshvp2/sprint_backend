package com.abc.techstore.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_tbl")
public class ProductEntity {
	
	@Id
	private int productId;
	private String productName;
	private double productPrice;
	private String productDescription;
	private LocalDate productDom;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public LocalDate getProductDom() {
		return productDom;
	}
	public void setProductDom(LocalDate productDom) {
		this.productDom = productDom;
	}
	
	
}
