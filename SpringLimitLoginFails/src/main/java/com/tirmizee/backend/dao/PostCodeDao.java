package com.tirmizee.backend.dao;

import com.tirmizee.core.domain.PostCode;
import com.tirmizee.core.repository.PostCodeRepository;

public interface PostCodeDao extends PostCodeRepository {
	
	PostCode findBySubdistrictCode(String code);

}
