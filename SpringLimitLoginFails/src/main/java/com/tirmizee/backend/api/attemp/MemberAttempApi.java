package com.tirmizee.backend.api.attemp;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.api.attemp.data.MemberAttemptDTO;
import com.tirmizee.backend.api.attemp.data.SearchAttempDTO;
import com.tirmizee.backend.dao.MemberAttemptDao;
import com.tirmizee.core.datatable.PageRequestHelper;
import com.tirmizee.core.datatable.RequestTable;
import com.tirmizee.core.datatable.ResponseTable;

@RestController
@RequestMapping(path = "api/attemp")
public class MemberAttempApi {
	 
	@Autowired
	private MemberAttemptDao memberAttemptDao;
	
	@PreAuthorize("hasAnyAuthority('TR004')")
	@PostMapping(path = "/findByCriteria")
	public ResponseTable<MemberAttemptDTO> findByCriteria(@Valid @RequestBody RequestTable<SearchAttempDTO> requestTable){
		Pageable pageable = PageRequestHelper.build(requestTable, MemberAttemptDTO.class);
		Page<MemberAttemptDTO> page = memberAttemptDao.findByCriteria(requestTable.getSerch(), pageable);
		return new ResponseTable<>(page);
	}

}
