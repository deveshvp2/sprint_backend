package com.abc.techstore.model;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;



public class Product {
	
	
	private int productId;
	
	@NotEmpty(message="Product name is required")
	private String productName;
	
	@NotNull(message="Please provide a price")
	@Positive(message="Only positive values are allowed")
	private double productPrice;
	
	private String productDescription;
	
	@NotNull(message="Please provide date of manufacturing")
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
