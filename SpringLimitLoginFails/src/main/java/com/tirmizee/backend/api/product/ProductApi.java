package com.tirmizee.backend.api.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.api.product.data.ProductDTO;
import com.tirmizee.backend.api.product.data.SearchProductDTO;
import com.tirmizee.backend.dao.ProductDao;
import com.tirmizee.core.datatable.PageRequestHelper;
import com.tirmizee.core.datatable.RequestTable;
import com.tirmizee.core.datatable.ResponseTable;

@RestController
@RequestMapping(path = "api/product")
public class ProductApi {
	
	@Autowired
	private ProductDao productDao;
	
	@PreAuthorize("hasAnyAuthority('TR005')")
	@PostMapping(path = "/findByCriteria")
	public ResponseTable<ProductDTO> findByCriteria(@RequestBody @Valid RequestTable<SearchProductDTO> request){
		Pageable pageable = PageRequestHelper.build(request, ProductDTO.class);
		Page<ProductDTO> page = productDao.findByCritria(request.getSerch(), pageable);
		return new ResponseTable<>(page);
	}

}
