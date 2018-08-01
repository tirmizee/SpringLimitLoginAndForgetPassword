package com.tirmizee.backend.api.customer.data;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

public class SearchCustomerDTO implements Serializable {

	private static final long serialVersionUID = 628770085843732496L;
	
	private String customerCode;
	private String customerName;
	private String customerSurname;
	private String customerEmail;
	private String customerMobile;

	public String getCustomerCode() {
		return StringUtils.trimToNull(customerCode);
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return StringUtils.trimToNull(customerName);
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerSurname() {
		return StringUtils.trimToNull(customerSurname);
	}

	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}

	public String getCustomerEmail() {
		return StringUtils.trimToNull(customerEmail);
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerMobile() {
		return StringUtils.trimToNull(customerMobile);
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}
	
}
