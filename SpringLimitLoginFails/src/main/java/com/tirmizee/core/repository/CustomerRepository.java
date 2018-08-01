package com.tirmizee.core.repository;

import com.tirmizee.core.domain.Customer;
import com.tirmizee.core.jdbcrepository.JdbcRepository;

public interface CustomerRepository extends JdbcRepository<Customer, Long> {
	
	public static final String TABLE_CUSTOMERS = "Customers";
	public static final String COL_CUSTOMERID = "CustomerId";
	public static final String COL_CUSTOMERCODE = "CustomerCode";
	public static final String COL_CUSTOMERNAME = "CustomerName";
	public static final String COL_CUSTOMERSURNAME = "CustomerSurname";
	public static final String COL_CUSTOMERPHONE = "CustomerPhone";
	public static final String COL_CUSTOMERMOBILE = "CustomerMobile";
	public static final String COL_CUSTOMEREMAIL = "CustomerEmail";
	public static final String COL_CUSTOMERSTATUS = "CustomerStatus";
	public static final String COL_CREATEDATE = "CreateDate";
	public static final String COL_UPDATEDATE = "UpdateDate";

	public static final String CUSTOMERID = "Customers.CustomerId";
	public static final String CUSTOMERCODE = "Customers.CustomerCode";
	public static final String CUSTOMERNAME = "Customers.CustomerName";
	public static final String CUSTOMERSURNAME = "Customers.CustomerSurname";
	public static final String CUSTOMERPHONE = "Customers.CustomerPhone";
	public static final String CUSTOMERMOBILE = "Customers.CustomerMobile";
	public static final String CUSTOMEREMAIL = "Customers.CustomerEmail";
	public static final String CUSTOMERSTATUS = "Customers.CustomerStatus";
	public static final String CREATEDATE = "Customers.CreateDate";
	public static final String UPDATEDATE = "Customers.UpdateDate";

}
