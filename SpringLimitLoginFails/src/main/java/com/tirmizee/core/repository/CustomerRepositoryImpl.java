package com.tirmizee.core.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.core.domain.Customer;
import com.tirmizee.core.jdbcrepository.AbstractMssqlRepository;
import com.tirmizee.core.jdbcrepository.RowUnmapper;

@Repository("CustomerRepository")
public class CustomerRepositoryImpl extends AbstractMssqlRepository<Customer, Long> implements CustomerRepository {
	
	public static final RowMapper<Customer> ROW_MAPPER = new RowMapper<Customer>() {
		@Override
		public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getLong(COL_CUSTOMERID));
			customer.setCustomerCode(rs.getString(COL_CUSTOMERCODE));
			customer.setCustomerName(rs.getString(COL_CUSTOMERNAME));
			customer.setCustomerSurname(rs.getString(COL_CUSTOMERSURNAME));
			customer.setCustomerPhone(rs.getString(COL_CUSTOMERPHONE));
			customer.setCustomerMobile(rs.getString(COL_CUSTOMERMOBILE));
			customer.setCustomerEmail(rs.getString(COL_CUSTOMEREMAIL));
			customer.setCustomerStatus(rs.getBoolean(COL_CUSTOMERSTATUS));
			customer.setCreateDate(rs.getDate(COL_CREATEDATE));
			customer.setUpdateDate(rs.getDate(COL_UPDATEDATE));
			return customer.withPersisted(true);
		}
	};
	public static final RowUnmapper<Customer> ROW_UNMAPPER = new RowUnmapper<Customer>() {
		@Override
		public Map<String, Object> mapColumns(Customer param) {
			Map<String, Object> map = new LinkedHashMap<>();
			map.put(COL_CUSTOMERID , param.getCustomerId());
			map.put(COL_CUSTOMERCODE , param.getCustomerCode());
			map.put(COL_CUSTOMERNAME , param.getCustomerName());
			map.put(COL_CUSTOMERSURNAME , param.getCustomerSurname());
			map.put(COL_CUSTOMERPHONE , param.getCustomerPhone());
			map.put(COL_CUSTOMERMOBILE , param.getCustomerMobile());
			map.put(COL_CUSTOMEREMAIL , param.getCustomerEmail());
			map.put(COL_CUSTOMERSTATUS , param.getCustomerStatus());
			map.put(COL_CREATEDATE , param.getCreateDate());
			map.put(COL_UPDATEDATE , param.getUpdateDate());
			return map;
		}
	};

	public CustomerRepositoryImpl() {
		this(TABLE_CUSTOMERS);
	}

	public CustomerRepositoryImpl(String tableName) {
		super(ROW_MAPPER, ROW_UNMAPPER, tableName, COL_CUSTOMERID);
	}

}
