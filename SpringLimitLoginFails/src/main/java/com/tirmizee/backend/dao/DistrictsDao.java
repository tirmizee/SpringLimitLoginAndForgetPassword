package com.tirmizee.backend.dao;

import org.springframework.data.domain.Page;

import com.tirmizee.backend.api.district.data.SearchDistrictDTO;
import com.tirmizee.core.domain.Districts;
import com.tirmizee.core.repository.DistrictsRepository;

public interface DistrictsDao extends DistrictsRepository {
	
	Page<Districts> findByTerm(SearchDistrictDTO search);

}
