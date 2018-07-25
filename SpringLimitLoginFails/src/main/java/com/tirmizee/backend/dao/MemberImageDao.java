package com.tirmizee.backend.dao;

import com.tirmizee.core.domain.MemberImage;
import com.tirmizee.core.repository.MemberImageRepository;

public interface MemberImageDao extends MemberImageRepository {
	
	MemberImage findByUsername(String username);

}
