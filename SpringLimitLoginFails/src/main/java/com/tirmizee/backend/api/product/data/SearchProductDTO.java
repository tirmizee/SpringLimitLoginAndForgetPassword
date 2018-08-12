package com.tirmizee.backend.api.product.data;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

public class SearchProductDTO implements Serializable {
	
	private static final long serialVersionUID = 2639310076978660964L;

	private String productCode;
	private String productName;
	private String productPrice;
	
	public String getProductCode() {
		return StringUtils.trimToNull(productCode);
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return StringUtils.trimToNull(productName);
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPrice() {
		return StringUtils.trimToNull(productPrice);
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

}
