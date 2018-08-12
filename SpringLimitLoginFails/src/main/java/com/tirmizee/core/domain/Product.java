package com.tirmizee.core.domain;

import java.math.BigDecimal;

import org.springframework.data.domain.Persistable;

public class Product implements Persistable<Long> {

	private static final long serialVersionUID = 3797420837185463937L;
	
	private Long productId;
	private String productCode;
	private String productName;
	private String productDesc;
	private String productImage;
	private BigDecimal productPrice;
	private java.sql.Date createDate;
	private java.sql.Date updateDate;

	@Override
	public Long getId() {
		return productId;
	}

	@Override
	public boolean isNew() {
		return productId == null;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public java.sql.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.sql.Date createDate) {
		this.createDate = createDate;
	}

	public java.sql.Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.sql.Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
