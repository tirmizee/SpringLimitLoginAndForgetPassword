package com.tirmizee.backend.api.district;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.api.district.data.SearchDistrictDTO;
import com.tirmizee.backend.dao.DistrictsDao;
import com.tirmizee.core.domain.Districts;

@RestController
@RequestMapping(path = "api/district")
public class DistrictApi {

	@Autowired
	private DistrictsDao districtsDao; 
	
	@PreAuthorize("hasAnyAuthority('TR005')")
	@PostMapping(path = "/findByTerm")
	public Page<Districts> findByTerm(@RequestBody @Valid SearchDistrictDTO search){
		return districtsDao.findByTerm(search);
	}
}
