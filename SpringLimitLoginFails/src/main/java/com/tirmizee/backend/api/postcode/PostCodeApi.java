package com.tirmizee.backend.api.postcode;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.dao.PostCodeDao;
import com.tirmizee.core.domain.PostCode;

@RestController
@RequestMapping(path = "api/postcode")
public class PostCodeApi {

	@Autowired
	private PostCodeDao postCodeDao; 
	
	@GetMapping(path = "/{SubDistrictCode}")
	public PostCode getPostcode(@PathVariable @NotNull String SubDistrictCode){
		return postCodeDao.findBySubdistrictCode(SubDistrictCode);
	}
	
}
