package com.tirmizee.backend.dao;

import org.springframework.data.domain.Page;

import com.tirmizee.backend.api.subdistrict.data.SearchSubDistrictDTO;
import com.tirmizee.core.domain.SubDistricts;
import com.tirmizee.core.repository.SubDistrictsRepository;

public interface SubDistrictsDao extends SubDistrictsRepository {
	
	Page<SubDistricts> findByTerm(SearchSubDistrictDTO search);

}
