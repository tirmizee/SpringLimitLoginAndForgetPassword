package com.tirmizee.backend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.backend.api.customer.data.CustomerDTO;
import com.tirmizee.backend.api.customer.data.SearchCustomerDTO;
import com.tirmizee.core.repository.CustomerRepositoryImpl;

@Repository
public class CustomerDaoImpl extends CustomerRepositoryImpl implements CustomerDao{
	
	public static final RowMapper<CustomerDTO> PAGE_CUSTOMER_MAPPER = new RowMapper<CustomerDTO>() {
		@Override
		public CustomerDTO mapRow(ResultSet rs, int arg1) throws SQLException {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerId(rs.getLong(COL_CUSTOMERID));
			customerDTO.setCustomerCode(rs.getString(COL_CUSTOMERCODE));
			customerDTO.setCustomerName(rs.getString(COL_CUSTOMERNAME));
			customerDTO.setCustomerSurname(rs.getString(COL_CUSTOMERSURNAME));
			customerDTO.setCustomerPhone(rs.getString(COL_CUSTOMERPHONE));
			customerDTO.setCustomerMobile(rs.getString(COL_CUSTOMERMOBILE));
			customerDTO.setCustomerEmail(rs.getString(COL_CUSTOMEREMAIL));
			customerDTO.setCustomerStatus(rs.getBoolean(COL_CUSTOMERSTATUS));
			return customerDTO;
		}
	};

	@Override
	public Page<CustomerDTO> findByCriteria(SearchCustomerDTO search, Pageable pageable) {
		
		List<Object> params = new LinkedList<>();

		StringBuilder statement = new StringBuilder()
			.append(" SELECT ")
				.append(COL_CUSTOMERID).append(" , ")
				.append(COL_CUSTOMERCODE).append(" , ")
				.append(COL_CUSTOMERNAME).append(" , ")
				.append(COL_CUSTOMERSURNAME).append(" , ")
				.append(COL_CUSTOMEREMAIL).append(" , ")
				.append(COL_CUSTOMERSTATUS).append(" , ")
				.append(COL_CUSTOMERPHONE).append(" , ")
				.append(COL_CUSTOMERMOBILE)
			.append(" FROM ").append(TABLE_CUSTOMERS)
			.append(" WHERE ").append(COL_CUSTOMERID).append(" IS NOT NULL ");
		
		if (search.getCustomerCode() != null) {
			statement.append(" AND ").append(COL_CUSTOMERCODE).append(" LIKE ? ");
			params.add("%" + StringUtils.trimToEmpty(search.getCustomerCode()) + "%");
		}
		if (search.getCustomerName() != null) {
			statement.append(" AND ").append(COL_CUSTOMERNAME).append(" LIKE ? ");
			params.add("%" + StringUtils.trimToEmpty(search.getCustomerName()) + "%");
		}
		if (search.getCustomerSurname() != null) {
			statement.append(" AND ").append(COL_CUSTOMERSURNAME).append(" LIKE ? ");
			params.add("%" + StringUtils.trimToEmpty(search.getCustomerSurname()) + "%");
		}
		if (search.getCustomerEmail() != null) {
			statement.append(" AND ").append(COL_CUSTOMEREMAIL).append(" LIKE ? ");
			params.add("%" + StringUtils.trimToEmpty(search.getCustomerEmail()) + "%");
		}
		if (search.getCustomerMobile() != null) {
			statement.append(" AND ").append(COL_CUSTOMERMOBILE).append(" LIKE ? ");
			params.add("%" + StringUtils.trimToEmpty(search.getCustomerMobile()) + "%");
		}
		
		String statementPage = getSqlGenerator().selectAll(getTable(), statement, pageable);
		List<CustomerDTO> content = getJdbcOps().query(statementPage, params.toArray(),PAGE_CUSTOMER_MAPPER);
		Long total = count(statement.toString(), params.toArray());
		
		return new PageImpl<>(content, pageable, total);
	}

}
