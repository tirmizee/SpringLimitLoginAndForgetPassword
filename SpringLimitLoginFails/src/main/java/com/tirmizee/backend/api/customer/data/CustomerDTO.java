package com.tirmizee.backend.api.customer.data;

import java.io.Serializable;

import com.tirmizee.core.annotaion.SortColumn;
import com.tirmizee.core.repository.CustomerRepository;

public class CustomerDTO implements Serializable {

	private static final long serialVersionUID = 8377315101379530437L;
	
	private Long customerId;
	
	@SortColumn(value = CustomerRepository.COL_CUSTOMERCODE)
	private String customerCode;
	
	@SortColumn(value = CustomerRepository.COL_CUSTOMERNAME)
	private String customerName;
	
	@SortColumn(value = CustomerRepository.COL_CUSTOMERSURNAME)
	private String customerSurname;
	
	@SortColumn(value = CustomerRepository.COL_CUSTOMERPHONE)
	private String customerPhone;
	
	@SortColumn(value = CustomerRepository.COL_CUSTOMERMOBILE)
	private String customerMobile;
	
	@SortColumn(value = CustomerRepository.COL_CUSTOMEREMAIL)
	private String customerEmail;
	
	private Boolean customerStatus;
	
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
	
}
