package com.tirmizee.backend.dao;

import org.springframework.data.domain.Page;

import com.tirmizee.backend.api.skin.data.SearchSkinDTO;
import com.tirmizee.core.domain.Skin;
import com.tirmizee.core.repository.SkinRepository;

public interface SkinDao extends SkinRepository {
	
	Page<Skin> findByTerm(SearchSkinDTO search);

}
