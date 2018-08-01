package com.tirmizee.backend.api.province;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.api.province.data.SearchProvinceDTO;
import com.tirmizee.backend.dao.ProvinceDao;
import com.tirmizee.core.domain.Province;

@RestController
@RequestMapping(path = "api/province")
public class ProvinceApi {

	@Autowired
	private ProvinceDao provinceDao; 
	
	@PreAuthorize("hasAnyAuthority('TR005')")
	@PostMapping(path = "/findAll")
	public Page<Province> findAll(@RequestBody SearchProvinceDTO search){
		return provinceDao.findByTerm(search);
	}
	
}
