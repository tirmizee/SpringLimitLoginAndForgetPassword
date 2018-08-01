package com.tirmizee.core.domain;

import org.springframework.data.domain.Persistable;

public class Customer implements Persistable<Long>{

	private static final long serialVersionUID = 5848124687287084714L;
	private transient boolean persisted;
	
	private Long customerId;
	private String customerCode;
	private String customerName;
	private String customerSurname;
	private String customerPhone;
	private String customerMobile;
	private String customerEmail;
	private Boolean customerStatus;
	private java.sql.Date createDate;
	private java.sql.Date updateDate;
	
	@Override
	public Long getId() {
		return customerId;
	}

	@Override
	public boolean isNew() {
		return !persisted;
	}
	
	public boolean isPersisted() {
		return persisted;
	}

	public void setPersisted(boolean persisted) {
		this.persisted = persisted;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerSurname() {
		return customerSurname;
	}

	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Boolean getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(Boolean customerStatus) {
		this.customerStatus = customerStatus;
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

	public Customer withPersisted(boolean persisted) {
		this.persisted = persisted;
		return this;
	}

}
