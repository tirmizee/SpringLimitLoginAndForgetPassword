package com.tirmizee.backend.api.subdistrict;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.api.subdistrict.data.SearchSubDistrictDTO;
import com.tirmizee.backend.dao.SubDistrictsDao;
import com.tirmizee.core.domain.SubDistricts;

@RestController
@RequestMapping(path = "api/subdistrict")
public class SubDistrictsApi {

	@Autowired
	private SubDistrictsDao subDistrictsDao;
	
	@PostMapping(path = "/findByTerm")
	public Page<SubDistricts> findByTerm(@RequestBody @Valid SearchSubDistrictDTO search){
		return subDistrictsDao.findByTerm(search);
	}

}
