package com.tirmizee.backend.api.product.data;

import java.io.Serializable;
import java.math.BigDecimal;

import com.tirmizee.core.annotaion.SortColumn;
import com.tirmizee.core.repository.ProductRepository;

public class ProductDTO implements Serializable{
	
	private static final long serialVersionUID = 2134926774873991788L;

	private Long productId;
	
	@SortColumn(ProductRepository.COL_PRODUCTCODE)
	private String productCode;
	
	@SortColumn(ProductRepository.COL_PRODUCTNAME)
	private String productName;
	
	private String productDesc;
	private String productImage;
	private BigDecimal productPrice;
	private java.sql.Date createDate;
	
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
	
}
