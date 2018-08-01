package com.tirmizee.backend.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tirmizee.backend.api.customer.data.CustomerDTO;
import com.tirmizee.backend.api.customer.data.SearchCustomerDTO;
import com.tirmizee.core.repository.CustomerRepository;

public interface CustomerDao extends CustomerRepository {
	
	Page<CustomerDTO> findByCriteria(SearchCustomerDTO search, Pageable pageable);

}
