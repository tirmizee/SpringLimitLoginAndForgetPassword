package com.tirmizee.backend.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tirmizee.backend.api.product.data.ProductDTO;
import com.tirmizee.backend.api.product.data.SearchProductDTO;
import com.tirmizee.core.repository.ProductRepository;

public interface ProductDao extends ProductRepository {
	
	Page<ProductDTO> findByCritria(SearchProductDTO search, Pageable pageable);
	
	Boolean existsImageName(String imgName);

}
