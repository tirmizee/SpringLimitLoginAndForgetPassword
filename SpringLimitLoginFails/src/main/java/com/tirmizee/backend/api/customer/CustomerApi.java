package com.tirmizee.backend.api.customer;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.api.customer.data.CustomerDTO;
import com.tirmizee.backend.api.customer.data.SearchCustomerDTO;
import com.tirmizee.backend.dao.CustomerDao;
import com.tirmizee.core.datatable.PageRequestHelper;
import com.tirmizee.core.datatable.RequestTable;
import com.tirmizee.core.datatable.ResponseTable;

@RestController
@RequestMapping(path = "api/customer")
public class CustomerApi {
	
	@Autowired
	private CustomerDao customerDao;
	
	@PreAuthorize("hasAnyAuthority('TR005')")
	@PostMapping(path = "/findByCriteria")
	public ResponseTable<CustomerDTO> findByCriteria(@RequestBody @Valid RequestTable<SearchCustomerDTO> request){
		Pageable pageable = PageRequestHelper.build(request, CustomerDTO.class);
		Page<CustomerDTO> page = customerDao.findByCriteria(request.getSerch(), pageable);
		return new ResponseTable<>(page);
	} 

}
